# Funcionalidade Extra 2: Persistência de Progresso do Usuário

## Visão Geral

A segunda funcionalidade extra proposta é a **Persistência Local de Dados** usando o pacote `shared_preferences`. Esta funcionalidade permitirá que o aplicativo salve e recupere o progresso do usuário, incluindo módulos completados e pontuações de quizzes.

## Objetivo

Melhorar a experiência do usuário salvando:
- ✅ Módulos completados
- 📊 Pontuações obtidas em cada quiz
- 🎯 Progresso geral no aplicativo
- ⏱️ Data da última atividade

## Benefícios

1. **Continuidade**: Usuário mantém seu progresso mesmo após fechar o app
2. **Motivação**: Visualizar conquistas incentiva o aprendizado contínuo
3. **Personalização**: App pode recomendar próximos módulos baseado no histórico
4. **Gamificação**: Base para sistema de conquistas e badges futuros

---

## Implementação Técnica

### 1. Dependência Necessária

Adicionar ao `pubspec.yaml`:

```yaml
dependencies:
  shared_preferences: ^2.2.0
```

Executar:
```bash
flutter pub get
```

### 2. Estrutura de Dados

#### Model: UserProgress

```dart
// lib/shared/models/user_progress.dart

class UserProgress {
  /// ID do módulo
  final String moduleId;
  
  /// Se o módulo foi completado
  final bool isCompleted;
  
  /// Melhor pontuação obtida no quiz (0-100)
  final int? bestScore;
  
  /// Data da última tentativa
  final DateTime? lastAttemptDate;
  
  /// Número de tentativas do quiz
  final int attemptCount;

  const UserProgress({
    required this.moduleId,
    this.isCompleted = false,
    this.bestScore,
    this.lastAttemptDate,
    this.attemptCount = 0,
  });

  // Serialização JSON para SharedPreferences
  Map<String, dynamic> toJson() {
    return {
      'moduleId': moduleId,
      'isCompleted': isCompleted,
      'bestScore': bestScore,
      'lastAttemptDate': lastAttemptDate?.toIso8601String(),
      'attemptCount': attemptCount,
    };
  }

  factory UserProgress.fromJson(Map<String, dynamic> json) {
    return UserProgress(
      moduleId: json['moduleId'] as String,
      isCompleted: json['isCompleted'] as bool,
      bestScore: json['bestScore'] as int?,
      lastAttemptDate: json['lastAttemptDate'] != null
          ? DateTime.parse(json['lastAttemptDate'] as String)
          : null,
      attemptCount: json['attemptCount'] as int,
    );
  }
}
```

### 3. Service: ProgressService

```dart
// lib/core/services/progress_service.dart

import 'package:shared_preferences/shared_preferences.dart';
import 'dart:convert';
import '../../shared/models/user_progress.dart';

/// Service responsável por gerenciar persistência do progresso do usuário.
/// 
/// PADRÃO SINGLETON: Garante uma única instância compartilhada.
class ProgressService {
  static final ProgressService _instance = ProgressService._internal();
  factory ProgressService() => _instance;
  ProgressService._internal();

  // Chaves para SharedPreferences
  static const String _keyProgressList = 'user_progress_list';
  static const String _keyTotalScore = 'total_score';
  static const String _keyModulesCompleted = 'modules_completed_count';

  /// Salva o progresso de um módulo
  Future<void> saveModuleProgress(UserProgress progress) async {
    final prefs = await SharedPreferences.getInstance();
    
    // Recupera lista existente
    final progressList = await getAllProgress();
    
    // Remove progresso antigo do mesmo módulo
    progressList.removeWhere((p) => p.moduleId == progress.moduleId);
    
    // Adiciona novo progresso
    progressList.add(progress);
    
    // Converte para JSON e salva
    final jsonList = progressList.map((p) => p.toJson()).toList();
    await prefs.setString(_keyProgressList, jsonEncode(jsonList));
  }

  /// Recupera progresso de um módulo específico
  Future<UserProgress?> getModuleProgress(String moduleId) async {
    final progressList = await getAllProgress();
    
    try {
      return progressList.firstWhere((p) => p.moduleId == moduleId);
    } catch (e) {
      return null;
    }
  }

  /// Recupera todo o progresso do usuário
  Future<List<UserProgress>> getAllProgress() async {
    final prefs = await SharedPreferences.getInstance();
    final jsonString = prefs.getString(_keyProgressList);
    
    if (jsonString == null) return [];
    
    final List<dynamic> jsonList = jsonDecode(jsonString);
    return jsonList.map((json) => UserProgress.fromJson(json)).toList();
  }

  /// Marca um módulo como completado
  Future<void> markModuleAsCompleted(String moduleId, int score) async {
    final currentProgress = await getModuleProgress(moduleId);
    
    final newProgress = UserProgress(
      moduleId: moduleId,
      isCompleted: true,
      bestScore: currentProgress?.bestScore != null
          ? (score > currentProgress!.bestScore! ? score : currentProgress.bestScore)
          : score,
      lastAttemptDate: DateTime.now(),
      attemptCount: (currentProgress?.attemptCount ?? 0) + 1,
    );
    
    await saveModuleProgress(newProgress);
    await _updateStats();
  }

  /// Atualiza estatísticas gerais
  Future<void> _updateStats() async {
    final prefs = await SharedPreferences.getInstance();
    final progressList = await getAllProgress();
    
    final completedCount = progressList.where((p) => p.isCompleted).length;
    final totalScore = progressList
        .where((p) => p.bestScore != null)
        .fold<int>(0, (sum, p) => sum + p.bestScore!);
    
    await prefs.setInt(_keyModulesCompleted, completedCount);
    await prefs.setInt(_keyTotalScore, totalScore);
  }

  /// Obtém estatísticas gerais
  Future<Map<String, int>> getStats() async {
    final prefs = await SharedPreferences.getInstance();
    
    return {
      'modulesCompleted': prefs.getInt(_keyModulesCompleted) ?? 0,
      'totalScore': prefs.getInt(_keyTotalScore) ?? 0,
    };
  }

  /// Limpa todo o progresso (útil para testes ou reset)
  Future<void> clearAllProgress() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove(_keyProgressList);
    await prefs.remove(_keyTotalScore);
    await prefs.remove(_keyModulesCompleted);
  }
}
```

### 4. Integração nas Telas

#### ModulesListScreen - Mostrar Indicadores de Conclusão

```dart
// Adicionar no build do card de módulo:

FutureBuilder<UserProgress?>(
  future: ProgressService().getModuleProgress(module.id),
  builder: (context, snapshot) {
    final progress = snapshot.data;
    
    return Stack(
      children: [
        // Card existente...
        
        // Badge de conclusão
        if (progress?.isCompleted == true)
          Positioned(
            top: 8,
            right: 8,
            child: Container(
              padding: EdgeInsets.all(8),
              decoration: BoxDecoration(
                color: Colors.green,
                shape: BoxShape.circle,
              ),
              child: Icon(Icons.check, color: Colors.white, size: 16),
            ),
          ),
      ],
    );
  },
)
```

#### QuizResultScreen - Salvar Resultado

```dart
@override
void initState() {
  super.initState();
  _saveProgress();
}

Future<void> _saveProgress() async {
  // Calcular pontuação em porcentagem
  final scorePercentage = ((score / totalQuestions) * 100).round();
  
  // Salvar progresso
  await ProgressService().markModuleAsCompleted(
    widget.moduleId,
    scorePercentage,
  );
}
```

#### HomeScreen - Dashboard de Progresso

```dart
// Adicionar seção de estatísticas:

FutureBuilder<Map<String, int>>(
  future: ProgressService().getStats(),
  builder: (context, snapshot) {
    if (!snapshot.hasData) return SizedBox.shrink();
    
    final stats = snapshot.data!;
    
    return Card(
      child: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            Text('Your Progress', style: Theme.of(context).textTheme.titleLarge),
            SizedBox(height: 12),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                _StatItem(
                  icon: Icons.check_circle,
                  label: 'Completed',
                  value: '${stats['modulesCompleted']}',
                ),
                _StatItem(
                  icon: Icons.star,
                  label: 'Total Score',
                  value: '${stats['totalScore']}',
                ),
              ],
            ),
          ],
        ),
      ),
    );
  },
)
```

---

## Melhorias Futuras

Com esta base de persistência, podemos facilmente adicionar:

1. **Sistema de Conquistas (Achievements)**
   - Desbloquear badges por completar todos os módulos
   - Conquistas por pontuação perfeita

2. **Modo Streak**
   - Contar dias consecutivos de estudo
   - Notificações para manter a sequência

3. **Análise de Desempenho**
   - Gráficos de evolução
   - Tópicos que precisam de revisão

4. **Sincronização na Nuvem**
   - Backup do progresso no Firebase
   - Acesso multi-dispositivo

---

## Testes Recomendados

```dart
// test/services/progress_service_test.dart

void main() {
  late ProgressService service;
  
  setUp(() {
    service = ProgressService();
    SharedPreferences.setMockInitialValues({});
  });
  
  test('Deve salvar e recuperar progresso do módulo', () async {
    final progress = UserProgress(
      moduleId: 'greetings',
      isCompleted: true,
      bestScore: 90,
    );
    
    await service.saveModuleProgress(progress);
    final retrieved = await service.getModuleProgress('greetings');
    
    expect(retrieved?.moduleId, 'greetings');
    expect(retrieved?.bestScore, 90);
  });
  
  test('Deve atualizar best score apenas se novo for maior', () async {
    await service.markModuleAsCompleted('greetings', 80);
    await service.markModuleAsCompleted('greetings', 70);
    
    final progress = await service.getModuleProgress('greetings');
    expect(progress?.bestScore, 80);
  });
}
```

---

## Considerações de Segurança

⚠️ **Importante**: `SharedPreferences` armazena dados localmente sem criptografia.
- ✅ Adequado para: Preferências, progresso de jogos, configurações
- ❌ Inadequado para: Senhas, tokens de autenticação, dados sensíveis

Para dados sensíveis, usar `flutter_secure_storage` em vez de `shared_preferences`.

---

## Conclusão

Esta funcionalidade extra:
- ✅ Melhora significativamente a UX
- ✅ É tecnicamente simples de implementar
- ✅ Prepara o app para funcionalidades avançadas
- ✅ Demonstra conhecimento de gerenciamento de estado persistente
- ✅ Alinha-se com boas práticas de desenvolvimento mobile

A implementação completa levaria aproximadamente 2-3 horas para um desenvolvedor júnior familiarizado com Flutter.
