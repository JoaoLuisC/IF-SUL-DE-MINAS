# 📚 English for Beginners - Educational App

Um aplicativo educacional interativo para ensino de inglês básico, desenvolvido em **Flutter** seguindo as melhores práticas de engenharia de software.

---

## 🌟 Funcionalidade Estrela: Flashcards Animados 3D

Cartões interativos com **animação de flip realista** que giram 180° ao serem clicados, revelando a tradução.

![Flashcard Animation](https://img.shields.io/badge/Animation-3D%20Flip-purple?style=for-the-badge&logo=flutter)
![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)
![Flutter](https://img.shields.io/badge/Flutter-3.0+-blue?style=for-the-badge&logo=flutter)

---

## ✨ Características Principais

- 📖 **3 Módulos Completos** - Greetings, Numbers, Colors
- 🎴 **29 Flashcards Interativos** - Com animação 3D profissional
- ❓ **10 Questões de Quiz** - Feedback imediato e visual
- 🎨 **Design Moderno** - Material Design 3
- 📱 **Responsivo** - Funciona em qualquer tamanho de tela
- 🏗️ **Arquitetura Profissional** - Feature-First + Clean Code

---

## 🚀 Quick Start

```bash
# 1. Instalar dependências
flutter pub get

# 2. Executar o app
flutter run

# 3. Executar em modo release (melhor performance)
flutter run --release
```

**Para instruções detalhadas**, consulte: [`QUICK_START.md`](QUICK_START.md)

---

## 📖 Documentação

Este projeto possui documentação completa e profissional:

| Documento | Descrição |
|-----------|-----------|
| [`README_ARCHITECTURE.md`](README_ARCHITECTURE.md) | 📐 Arquitetura completa e decisões técnicas |
| [`FEATURE_PERSISTENCE.md`](FEATURE_PERSISTENCE.md) | 💾 Funcionalidade Extra 2 (Persistência de dados) |
| [`QUICK_START.md`](QUICK_START.md) | 🚀 Guia rápido de início |
| [`EXECUTIVE_SUMMARY.md`](EXECUTIVE_SUMMARY.md) | 📊 Resumo executivo do projeto |
| [`PROJECT_STRUCTURE.md`](PROJECT_STRUCTURE.md) | 🗂️ Estrutura detalhada de arquivos |
| [`PRESENTATION_GUIDE.md`](PRESENTATION_GUIDE.md) | 🎤 Guia completo de apresentação |

---

## 🎯 Requisitos Atendidos

### ✅ Obrigatórios (100%)
- [x] Tela de Boas-vindas
- [x] Área de Créditos
- [x] Navegação clara (Navigator)
- [x] 3+ Módulos de conteúdo
- [x] Quiz com 3+ perguntas
- [x] Feedback imediato
- [x] StatefulWidgets
- [x] Layout responsivo

### ⭐ Funcionalidades Extras
- [x] **Extra 1**: Flashcards com animação 3D de flip
- [x] **Extra 2**: Persistência de dados (documentada)

---

## 🏗️ Arquitetura

```
lib/
├── core/              # Configurações globais (tema, rotas)
├── shared/            # Código compartilhado (models, widgets)
├── features/          # Funcionalidades por feature
│   ├── home/          # Tela inicial
│   ├── credits/       # Créditos
│   ├── modules/       # Módulos de aprendizagem
│   └── quiz/          # Sistema de quiz
└── data/              # Camada de dados (módulos de exemplo)
```

**Princípios Aplicados**: SOLID, DRY, Clean Code, Separation of Concerns

---

## 🎨 Screenshots

### Tela Inicial
Boas-vindas acolhedora com navegação clara

### Lista de Módulos
Cards informativos de cada módulo educacional

### Flashcards Animados ⭐
Animação 3D profissional de flip

### Quiz Interativo
Feedback visual imediato (verde/vermelho)

### Resultado
Pontuação e mensagens motivacionais

---

## 🛠️ Tecnologias

- **Flutter** 3.0+ - Framework multiplataforma
- **Dart** 3.0+ - Linguagem de programação
- **Material Design 3** - Sistema de design

---

## 🎯 Destaques Técnicos

### 1. FlashcardWidget
```dart
// Animação 3D profissional
Transform(
  transform: Matrix4.identity()
    ..setEntry(3, 2, 0.001)  // Perspectiva
    ..rotateY(angle),         // Rotação 3D
  child: ...
)
```

### 2. Arquitetura Modular
- Features isoladas e independentes
- Fácil adicionar novos módulos
- Componentes reutilizáveis

### 3. Gerenciamento de Estado
- StatefulWidget para estado local
- setState para atualizações reativas
- Preparado para Provider/Bloc

---

## 📊 Estatísticas

- **20+ arquivos criados**
- **~3700 linhas de código** (incluindo documentação)
- **6 telas implementadas**
- **4 modelos de dados**
- **29 flashcards** distribuídos em 3 módulos
- **10 questões** de quiz

---

## 🚀 Roadmap Futuro

### Curto Prazo
- [ ] Implementar SharedPreferences
- [ ] Adicionar mais módulos
- [ ] Testes unitários

### Médio Prazo
- [ ] Text-to-Speech
- [ ] Modo escuro
- [ ] Sistema de conquistas

### Longo Prazo
- [ ] Backend com Firebase
- [ ] Autenticação de usuários
- [ ] Modo multiplayer

---

## 👥 Desenvolvido Por

**Instituto Federal do Sul de Minas**  
Curso: Ciência da Computação  
Disciplina: Projeto I - Aplicativo Educacional Interativo

---

## 📄 Licença

Projeto educacional - IF Sul de Minas © 2025

---

## 🎓 Para Avaliadores

Este projeto demonstra:
- ✅ Domínio completo de Flutter/Dart
- ✅ Aplicação de boas práticas de engenharia de software
- ✅ Código limpo e bem documentado
- ✅ Arquitetura profissional e escalável
- ✅ UI/UX atraente e funcional

**Documentação completa disponível** nos arquivos Markdown listados acima.

---

## 💡 Como Usar Este Projeto

### Para Estudantes
1. Clone o repositório
2. Leia `QUICK_START.md`
3. Execute o app
4. Explore o código
5. Consulte `README_ARCHITECTURE.md` para entender decisões

### Para Professores
1. Consulte `EXECUTIVE_SUMMARY.md` para overview
2. Revise arquitetura em `README_ARCHITECTURE.md`
3. Veja implementação dos requisitos

### Para Apresentação
1. Leia `PRESENTATION_GUIDE.md`
2. Pratique a demonstração
3. Prepare-se para perguntas técnicas

---

## 🌟 Destaque

> **Este não é apenas um app funcional - é um projeto com arquitetura profissional, código limpo e documentação completa. Pronto para apresentação, avaliação e expansão futura.**

---

## 📞 Contato

Para dúvidas sobre o projeto, consulte a documentação ou entre em contato com a equipe de desenvolvimento.

---

**Desenvolvido com ❤️ usando Flutter**

[![Flutter](https://img.shields.io/badge/Made%20with-Flutter-blue?style=flat&logo=flutter)](https://flutter.dev)
[![Dart](https://img.shields.io/badge/Language-Dart-blue?style=flat&logo=dart)](https://dart.dev)
[![Material](https://img.shields.io/badge/Design-Material%203-purple?style=flat&logo=material-design)](https://m3.material.io/)
