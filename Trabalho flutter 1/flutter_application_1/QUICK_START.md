# 🚀 Quick Start Guide

## Primeiros Passos

### 1. Verificar Instalação do Flutter

```bash
flutter doctor
```

Certifique-se de que todos os itens estão marcados com ✓.

### 2. Instalar Dependências

```bash
flutter pub get
```

### 3. Executar o Aplicativo

```bash
# Executar em modo debug
flutter run

# OU executar em modo release (melhor performance)
flutter run --release
```

---

## 📁 Estrutura do Código

### Principais Diretórios

- **`lib/core/`** - Configurações globais (tema, rotas)
- **`lib/shared/`** - Componentes compartilhados (models, widgets)
- **`lib/features/`** - Funcionalidades isoladas por tela
- **`lib/data/`** - Dados de exemplo dos módulos

### Arquivos Principais

1. **`main.dart`** - Ponto de entrada, configuração de rotas
2. **`app_theme.dart`** - Tema e cores do aplicativo
3. **`flashcard_widget.dart`** - ⭐ Widget estrela com animação de flip
4. **`sample_modules.dart`** - Dados dos 3 módulos de inglês

---

## 🎯 Fluxo do Usuário

```
HomeScreen
    ↓
ModulesListScreen (Lista de 3 módulos)
    ↓
LearningModuleScreen (Lições + Flashcards)
    ↓
QuizScreen (Perguntas)
    ↓
QuizResultScreen (Pontuação)
```

---

## 🌟 Testando a Funcionalidade Estrela

### Flashcards Interativos

1. Execute o app
2. Clique em **"Start Learning"**
3. Selecione qualquer módulo (ex: "Basic Greetings")
4. Navegue até a seção de **Flashcards**
5. **Clique em qualquer cartão** para ver a animação de flip 3D
6. Observe a transição suave de inglês → português

---

## 🔧 Modificando o Conteúdo

### Adicionar Novo Módulo

Edite: `lib/data/modules/sample_modules.dart`

```dart
static LearningModule _createNewModule() {
  return LearningModule(
    id: 'animals',           // ID único
    title: 'Animals',        // Título exibido
    description: 'Learn animal names',
    iconPath: 'assets/images/animals.png',
    colorValue: 0xFFFF9800,  // Cor laranja
    
    lessons: [
      Lesson(
        title: 'Farm Animals',
        content: 'Learn about common farm animals...',
        imagePath: 'assets/images/farm.png',
      ),
    ],
    
    flashcards: [
      Flashcard.simple('Dog', 'Cachorro'),
      Flashcard.simple('Cat', 'Gato'),
      // ... mais flashcards
    ],
    
    quizQuestions: [
      Question(
        questionText: 'What is "cachorro" in English?',
        options: ['Dog', 'Cat', 'Bird', 'Fish'],
        correctAnswerIndex: 0,
      ),
      // ... mais questões
    ],
  );
}

// Adicionar à lista de módulos
static List<LearningModule> getAllModules() {
  return [
    _createGreetingsModule(),
    _createNumbersModule(),
    _createColorsModule(),
    _createNewModule(),  // ← Novo módulo
  ];
}
```

### Personalizar Cores

Edite: `lib/core/theme/app_theme.dart`

```dart
static const Color primaryColor = Color(0xFFYOURCOLOR);
static const Color secondaryColor = Color(0xFFYOURCOLOR);
```

---

## 🐛 Solução de Problemas Comuns

### Erro: "Target of URI doesn't exist"

**Solução**: Execute `flutter pub get` para resolver imports.

### Erro: "No devices found"

**Solução**: 
- Android: Conecte dispositivo ou inicie emulador
- iOS: Abra simulador do Xcode
- Web: Execute `flutter run -d chrome`

### Erro de compilação no iOS

**Solução**: Execute no diretório `ios/`:
```bash
cd ios
pod install
cd ..
flutter clean
flutter run
```

### App muito lento no emulador

**Solução**: Use `flutter run --release` ou teste em dispositivo físico.

---

## 📚 Próximos Passos

### Para Desenvolvedores

1. **Implementar Funcionalidade Extra 2**
   - Consulte `FEATURE_PERSISTENCE.md`
   - Adicione `shared_preferences` ao `pubspec.yaml`
   - Implemente `ProgressService`

2. **Adicionar Mais Módulos**
   - Animais, Comidas, Família, etc.
   - Siga o padrão em `sample_modules.dart`

3. **Melhorar UI/UX**
   - Adicionar imagens reais
   - Criar animações de transição
   - Implementar modo escuro

4. **Testes**
   - Criar testes unitários para models
   - Criar testes de widget para `FlashcardWidget`
   - Criar testes de integração

### Para Apresentação

1. **Demo Script**:
   - Mostre a tela inicial
   - Demonstre navegação entre módulos
   - **DESTAQUE**: Flashcards com animação
   - Faça um quiz completo
   - Mostre a tela de resultados

2. **Pontos a Enfatizar**:
   - ✨ Arquitetura modular e escalável
   - 🎨 Design responsivo e atraente
   - 🔄 Componentes reutilizáveis
   - 📱 Funciona em múltiplas plataformas
   - 🌟 Animação 3D dos flashcards

3. **Perguntas Esperadas**:
   - "Como adicionar novos módulos?" → Mostrar `sample_modules.dart`
   - "Como funciona a animação?" → Explicar `AnimationController` + `Matrix4`
   - "É responsivo?" → Testar em diferentes tamanhos de tela
   - "Pode expandir?" → Mencionar funcionalidade extra 2 e roadmap

---

## 📖 Documentação Completa

- **`README_ARCHITECTURE.md`** - Arquitetura detalhada e decisões técnicas
- **`FEATURE_PERSISTENCE.md`** - Funcionalidade extra 2 (persistência)
- Este arquivo (`QUICK_START.md`) - Guia rápido

---

## ✅ Checklist Pré-Apresentação

- [ ] App compila sem erros
- [ ] Testado em dispositivo/emulador
- [ ] Todos os 3 módulos funcionam
- [ ] Flashcards giram corretamente
- [ ] Quizzes mostram feedback
- [ ] Navegação fluida entre telas
- [ ] README revisado
- [ ] Slides/apresentação preparados
- [ ] Demo praticada

---

## 🎓 Critérios de Avaliação Atendidos

| Critério | Status | Localização |
|----------|--------|-------------|
| Tela de Boas-vindas | ✅ | `home_screen.dart` |
| Créditos | ✅ | `credits_screen.dart` |
| 3+ Módulos | ✅ | `sample_modules.dart` (3 módulos) |
| Navegação | ✅ | `main.dart` + `app_routes.dart` |
| Quiz (3+ questões) | ✅ | `quiz_screen.dart` |
| Feedback imediato | ✅ | `quiz_screen.dart` (cores + mensagens) |
| StatefulWidgets | ✅ | `quiz_screen.dart`, `flashcard_widget.dart` |
| Responsividade | ✅ | Uso de `MediaQuery` em todos os layouts |
| Código limpo | ✅ | Comentários + estrutura organizada |
| Funcionalidade Extra 1 | ✅ | **Flashcards animados** (`flashcard_widget.dart`) |
| Funcionalidade Extra 2 | ✅ | Documentada em `FEATURE_PERSISTENCE.md` |

---

## 💡 Dicas Finais

1. **Performance**: Sempre teste em modo release antes de apresentar
2. **Demonstração**: Prepare um "caminho feliz" através do app
3. **Backup**: Tenha screenshots/vídeo caso haja problema técnico
4. **Código**: Esteja pronto para explicar qualquer parte do código
5. **Expansão**: Mencione melhorias futuras para mostrar visão de longo prazo

---

**Boa sorte com o projeto! 🚀**

Em caso de dúvidas, consulte a documentação completa ou a equipe de desenvolvimento.
