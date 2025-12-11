# 📚 English for Beginners - Aplicativo Educacional Interativo

## 📋 Visão Geral do Projeto

Aplicativo móvel educacional desenvolvido em **Flutter** para ensinar inglês básico de forma interativa e didática. O projeto atende aos requisitos do **Projeto I: Aplicativo Educacional Interativo** com foco em boas práticas de engenharia de software.

### 🎯 Tema Escolhido
**Aula de Inglês para Iniciantes** - Vocabulário básico e frases essenciais

---

## 🏗️ Arquitetura do Projeto

### Estrutura de Pastas

A arquitetura segue o padrão **Feature-First** combinado com **Clean Architecture**:

```
lib/
├── core/                          # Núcleo do aplicativo
│   ├── constants/                 # Constantes globais
│   ├── routes/                    # Configuração de rotas
│   │   └── app_routes.dart        # Rotas nomeadas
│   └── theme/                     # Configuração de tema
│       └── app_theme.dart         # Tema Material Design 3
│
├── shared/                        # Componentes compartilhados
│   ├── models/                    # Modelos de dados
│   │   ├── flashcard.dart         # 🌟 Modelo de Flashcard
│   │   ├── lesson.dart            # Modelo de Lição
│   │   ├── question.dart          # Modelo de Questão
│   │   └── learning_module.dart   # Modelo de Módulo
│   └── widgets/                   # Widgets reutilizáveis
│       └── flashcard_widget.dart  # 🌟 Widget de Flashcard Animado
│
├── features/                      # Funcionalidades (Features)
│   ├── home/                      # Feature: Tela Inicial
│   │   └── screens/
│   │       └── home_screen.dart
│   │
│   ├── credits/                   # Feature: Créditos
│   │   └── screens/
│   │       └── credits_screen.dart
│   │
│   ├── modules/                   # Feature: Módulos de Aprendizagem
│   │   ├── screens/
│   │   │   ├── modules_list_screen.dart
│   │   │   └── learning_module_screen.dart
│   │   └── widgets/
│   │
│   └── quiz/                      # Feature: Sistema de Quiz
│       └── screens/
│           ├── quiz_screen.dart
│           └── quiz_result_screen.dart
│
├── data/                          # Camada de dados
│   └── modules/
│       └── sample_modules.dart    # Dados de exemplo
│
└── main.dart                      # Ponto de entrada
```

### 🎨 Decisões Arquiteturais

#### 1. **Separação por Features**
- Cada funcionalidade está isolada em sua própria pasta
- Facilita manutenção e escalabilidade
- Permite trabalho paralelo de múltiplos desenvolvedores

#### 2. **Modelos de Dados Imutáveis**
- Uso de `const` e `final` para segurança
- Serialização JSON para futura integração com APIs
- Validação de dados no construtor

#### 3. **Widgets Reutilizáveis**
- `FlashcardWidget` totalmente genérico e parametrizável
- Separação clara entre lógica e apresentação
- Componentes atômicos e compostos

#### 4. **Gerenciamento de Estado**
- `StatefulWidget` para estado local (Quiz, Flashcards)
- Estado mínimo necessário (YAGNI principle)
- Preparado para migração futura para Provider/Bloc se necessário

---

## 🌟 Funcionalidade Estrela: Flashcards Interativos

### Requisitos Atendidos
✅ Cartão mostra palavra/frase em inglês na frente  
✅ Animação de flip (180°) ao clicar  
✅ Tradução em português no verso  
✅ Efeito suave e realista  
✅ Estado gerenciado internamente  
✅ Totalmente reutilizável  

### Implementação Técnica

**Arquivo**: `lib/shared/widgets/flashcard_widget.dart`

#### Técnicas Utilizadas:

1. **AnimationController** com `SingleTickerProviderStateMixin`
   - Controla a duração e estado da animação
   - Duração: 600ms para movimento natural

2. **Transform Matrix4** para rotação 3D
   ```dart
   Matrix4.identity()
     ..setEntry(3, 2, 0.001)  // Perspectiva 3D
     ..rotateY(angle)          // Rotação no eixo Y
   ```

3. **CurvedAnimation** para movimento fluido
   - Curva: `Curves.easeInOut`
   - Suaviza início e fim da animação

4. **Lógica de Flip**
   - Detecta quando mostrar frente vs. verso
   - Espelha horizontalmente o verso para corrigir inversão
   - Indicadores visuais (EN/PT)

### Uso do Widget

```dart
FlashcardWidget(
  flashcard: Flashcard(
    frontText: 'Hello',
    backText: 'Olá',
    category: 'greetings',
  ),
  width: 300,      // Opcional
  height: 200,     // Opcional
  onTap: () {      // Opcional
    print('Card flipped!');
  },
)
```

---

## 📱 Telas Principais

### 1. HomeScreen (Tela de Boas-vindas)
- Design atrativo com gradiente
- Botões de navegação clara
- Informações sobre funcionalidades

### 2. ModulesListScreen (Lista de Módulos)
- Cards informativos de cada módulo
- Indicadores de conteúdo (lições, flashcards, questões)
- Navegação direta para módulos

### 3. LearningModuleScreen (Conteúdo do Módulo)
- **PageView** para navegação fluida
- Alterna entre lições e flashcards
- Barra de progresso visual
- Conclusão com acesso ao quiz

### 4. QuizScreen (Quiz Interativo)
- **StatefulWidget** para gerenciamento de estado
- Estados gerenciados:
  - Índice da questão atual
  - Pontuação do usuário
  - Resposta selecionada
  - Feedback visual
- Feedback imediato com cores (verde/vermelho)
- Explicações opcionais

### 5. QuizResultScreen (Resultado)
- Pontuação visual atraente
- Mensagens motivacionais baseadas em desempenho
- Estatísticas detalhadas
- Opções de navegação

### 6. CreditsScreen (Créditos)
- Informações sobre desenvolvedores
- Tecnologias utilizadas
- Versão do aplicativo

---

## 🎯 Módulos de Conteúdo

### Módulo 1: Basic Greetings (Saudações)
- **Lições**: 2
- **Flashcards**: 9 (Hello, Good morning, etc.)
- **Questões**: 4
- **Cor Temática**: Roxo (#6200EE)

### Módulo 2: Numbers 1-10 (Números)
- **Lições**: 1
- **Flashcards**: 10 (One to Ten)
- **Questões**: 3
- **Cor Temática**: Ciano (#03DAC6)

### Módulo 3: Basic Colors (Cores)
- **Lições**: 1
- **Flashcards**: 10 (Red, Blue, Yellow, etc.)
- **Questões**: 3
- **Cor Temática**: Vermelho Suave (#FF6B6B)

---

## 🚀 Navegação e Rotas

### Sistema de Rotas Nomeadas

```dart
// Rotas simples
Navigator.pushNamed(context, AppRoutes.home);
Navigator.pushNamed(context, AppRoutes.credits);
Navigator.pushNamed(context, AppRoutes.modules);

// Rotas com argumentos
Navigator.pushNamed(
  context,
  AppRoutes.learningModule,
  arguments: 'greetings',  // moduleId
);

Navigator.pushNamed(
  context,
  AppRoutes.quiz,
  arguments: 'numbers',    // moduleId
);

Navigator.pushNamed(
  context,
  AppRoutes.quizResult,
  arguments: {
    'score': 8,
    'total': 10,
  },
);
```

### Vantagens das Rotas Nomeadas
- ✅ Código mais limpo e legível
- ✅ Fácil manutenção
- ✅ Tipagem segura com constantes
- ✅ Suporte a deep linking futuro

---

## 🎨 Design e UX

### Paleta de Cores

```dart
Primary Color:   #6200EE (Roxo vibrante)
Secondary Color: #03DAC6 (Ciano)
Background:      #F5F5F5 (Cinza claro)
Success:         #4CAF50 (Verde)
Error:           #B00020 (Vermelho)
```

### Princípios de Design

1. **Material Design 3**
   - Componentes modernos
   - Elevação consistente
   - Bordas arredondadas (12px)

2. **Responsividade**
   - `MediaQuery` para dimensões dinâmicas
   - Layouts flexíveis
   - Suporte a diferentes tamanhos de tela

3. **Feedback Visual**
   - Animações suaves
   - Cores semânticas (verde = correto, vermelho = erro)
   - Indicadores de progresso

4. **Acessibilidade**
   - Tamanhos de fonte legíveis
   - Contraste adequado
   - Ícones informativos

---

## 📦 Dependências

### pubspec.yaml

```yaml
dependencies:
  flutter:
    sdk: flutter
  # (Nenhuma dependência externa no core)
  # shared_preferences: ^2.2.0  # Para funcionalidade extra 2
```

### Por que Mínimas Dependências?

- ✅ App mais leve
- ✅ Menos conflitos de versão
- ✅ Melhor controle sobre o código
- ✅ Aprendizado dos fundamentos do Flutter

---

## 🔧 Como Executar

### Pré-requisitos
- Flutter SDK (3.0+)
- Dart SDK (3.0+)
- IDE (VS Code, Android Studio)

### Passos

```bash
# 1. Instalar dependências
flutter pub get

# 2. Verificar dispositivos disponíveis
flutter devices

# 3. Executar em modo debug
flutter run

# 4. Executar em modo release (melhor performance)
flutter run --release
```

### Plataformas Suportadas
- ✅ Android
- ✅ iOS
- ✅ Web
- ✅ Windows
- ✅ macOS
- ✅ Linux

---

## 🧪 Testes (Próximos Passos)

### Estrutura de Testes Sugerida

```
test/
├── models/
│   ├── flashcard_test.dart
│   ├── lesson_test.dart
│   └── question_test.dart
├── widgets/
│   └── flashcard_widget_test.dart
└── screens/
    ├── quiz_screen_test.dart
    └── learning_module_screen_test.dart
```

### Exemplos de Testes

```dart
// Teste unitário - Model
test('Question deve validar resposta correta', () {
  final question = Question(
    questionText: 'Test?',
    options: ['A', 'B', 'C'],
    correctAnswerIndex: 1,
  );
  
  expect(question.isCorrect(1), true);
  expect(question.isCorrect(0), false);
});

// Teste de widget
testWidgets('FlashcardWidget deve girar ao clicar', (tester) async {
  final flashcard = Flashcard.simple('Hello', 'Olá');
  
  await tester.pumpWidget(
    MaterialApp(
      home: FlashcardWidget(flashcard: flashcard),
    ),
  );
  
  // Simula tap
  await tester.tap(find.byType(FlashcardWidget));
  await tester.pumpAndSettle();
  
  // Verifica se texto mudou
  expect(find.text('Olá'), findsOneWidget);
});
```

---

## 📚 Funcionalidade Extra 2: Persistência de Dados

Ver documentação detalhada em: [`FEATURE_PERSISTENCE.md`](FEATURE_PERSISTENCE.md)

### Resumo

Implementação de **SharedPreferences** para salvar:
- Módulos completados
- Pontuações de quizzes
- Progresso geral
- Estatísticas do usuário

**Benefícios**: Continuidade, motivação, base para gamificação

---

## 🎓 Conceitos de Engenharia de Software Demonstrados

### 1. Clean Code
- ✅ Nomes descritivos e significativos
- ✅ Funções pequenas e focadas
- ✅ Comentários explicativos (não redundantes)
- ✅ Formatação consistente

### 2. SOLID Principles

#### Single Responsibility
- Cada classe tem uma única responsabilidade
- `FlashcardWidget` → apenas exibir e animar flashcard
- `QuizScreen` → apenas gerenciar quiz

#### Open/Closed
- `LearningModule` pode ser estendido sem modificar código existente
- Novos módulos adicionados via dados, não código

#### Dependency Inversion
- Telas dependem de abstrações (`LearningModule`), não implementações
- Fácil trocar `SampleModules` por API real

### 3. DRY (Don't Repeat Yourself)
- Widgets reutilizáveis (`FlashcardWidget`)
- Tema centralizado (`AppTheme`)
- Rotas em constantes (`AppRoutes`)

### 4. Separation of Concerns
- UI separada de lógica de negócio
- Models separados de Views
- Navegação centralizada

### 5. Code Reusability
- `FlashcardWidget` usado em qualquer lugar
- `LearningModuleScreen` genérico para qualquer módulo
- Componentes modulares

---

## 🚀 Melhorias Futuras

### Curto Prazo
1. ✨ Adicionar animações de transição entre telas
2. 🔊 Integrar Text-to-Speech para pronúncia
3. 🎨 Mais temas visuais (modo escuro)
4. 📊 Gráficos de progresso

### Médio Prazo
1. 🌐 Integração com API REST para conteúdo dinâmico
2. 👤 Sistema de autenticação de usuários
3. 🏆 Sistema de conquistas e badges
4. 📱 Notificações push para lembrete de estudo

### Longo Prazo
1. ☁️ Sincronização na nuvem (Firebase)
2. 🤝 Modo multiplayer/competitivo
3. 🎤 Exercícios de pronúncia com IA
4. 📈 Analytics e machine learning para personalização

---

## 👥 Equipe de Desenvolvimento

**Instituto Federal do Sul de Minas**  
Curso: Ciência da Computação  
Disciplina: Projeto I

### Papéis Sugeridos para Equipe

- **Arquiteto de Software**: Define estrutura e padrões
- **Desenvolvedor Frontend**: Implementa telas e widgets
- **Desenvolvedor Backend**: Integração futura com APIs
- **Designer UX/UI**: Melhora experiência do usuário
- **QA Engineer**: Cria e executa testes

---

## 📝 Convenções de Código

### Nomenclatura

```dart
// Classes: PascalCase
class FlashcardWidget {}

// Métodos e variáveis: camelCase
void buildCard() {}
int currentScore = 0;

// Constantes: lowerCamelCase (ou UPPER_SNAKE_CASE para globais)
const double cardHeight = 200.0;
static const String API_URL = 'https://api.example.com';

// Arquivos: snake_case
flashcard_widget.dart
learning_module_screen.dart
```

### Comentários

```dart
/// Comentários de documentação (três barras)
/// Usados para classes e métodos públicos
/// Aparecem no autocomplete do IDE

// Comentários inline (duas barras)
// Usados para explicar lógica complexa

/* Comentários de bloco */
/* Usados para comentar seções grandes temporariamente */
```

### Organização de Imports

```dart
// 1. Imports do Dart
import 'dart:math';

// 2. Imports do Flutter
import 'package:flutter/material.dart';

// 3. Imports de packages externos
import 'package:shared_preferences/shared_preferences.dart';

// 4. Imports relativos do projeto
import '../models/flashcard.dart';
import '../../core/theme/app_theme.dart';
```

---

## 📖 Recursos de Aprendizagem

### Documentação Oficial
- [Flutter Docs](https://docs.flutter.dev/)
- [Dart Language Tour](https://dart.dev/guides/language/language-tour)
- [Material Design](https://m3.material.io/)

### Tutoriais Recomendados
- Flutter Animations Cookbook
- State Management Best Practices
- Clean Architecture in Flutter

### Comunidade
- [Flutter Community](https://flutter.dev/community)
- [Stack Overflow - Flutter](https://stackoverflow.com/questions/tagged/flutter)
- [Reddit - r/FlutterDev](https://reddit.com/r/FlutterDev)

---

## 📄 Licença

Este projeto é de uso educacional para o **Instituto Federal do Sul de Minas**.

---

## ✅ Checklist de Requisitos Atendidos

### Requisitos Obrigatórios
- [x] Tela de Boas-vindas (Home)
- [x] Área de Créditos
- [x] Navegação clara (Navigator com rotas nomeadas)
- [x] Mínimo 3 módulos de conteúdo
- [x] Texto e elementos visuais em cada módulo
- [x] Quiz ao final de cada módulo
- [x] Mínimo 3 perguntas por quiz
- [x] Feedback imediato nas questões
- [x] Mensagem de congratulação
- [x] Uso de StatefulWidgets
- [x] Validação de dados
- [x] Layout responsivo

### Funcionalidades Extras
- [x] **Extra 1**: Flashcards Interativos com animação de flip
- [x] **Extra 2**: Documentação para Persistência de Dados

### Boas Práticas
- [x] Código limpo (Clean Code)
- [x] Componentes reutilizáveis
- [x] Organização modular
- [x] Comentários explicativos
- [x] Arquitetura escalável
- [x] Separação de responsabilidades

---

## 🎉 Conclusão

Este projeto demonstra:
- ✅ Domínio de Flutter e Dart
- ✅ Compreensão de arquitetura de software
- ✅ Aplicação de boas práticas
- ✅ Criatividade na solução de problemas
- ✅ Código pronto para produção

**Status**: ✨ Pronto para apresentação e extensão futura!

---

**Desenvolvido com ❤️ usando Flutter**
