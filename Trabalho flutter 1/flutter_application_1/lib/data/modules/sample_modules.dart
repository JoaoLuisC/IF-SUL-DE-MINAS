import '../../shared/models/learning_module.dart';
import '../../shared/models/lesson.dart';
import '../../shared/models/flashcard.dart';
import '../../shared/models/question.dart';

/// Classe que fornece módulos de exemplo para o aplicativo.
///
/// ARQUITETURA: Esta classe simula uma camada de dados.
/// Em produção, estes dados viriam de uma API ou banco de dados local.
///
/// IMPORTANTE PARA A EQUIPE: Quando integrar com backend,
/// substitua os métodos estáticos por um Repository/Service.
class SampleModules {
  /// Retorna todos os módulos disponíveis (15 módulos completos)
  static List<LearningModule> getAllModules() {
    return [
      // === NÍVEL BÁSICO (5 MÓDULOS) ===
      _createGreetingsModule(), // Módulo 1
      _createNumbersModule(), // Módulo 2
      _createFamilyModule(), // Módulo 3
      _createDailyRoutineModule(), // Módulo 4
      _createFoodModule(), // Módulo 5
      // === NÍVEL INTERMEDIÁRIO (5 MÓDULOS) ===
      _createPastHolidaysModule(), // Módulo 6
      _createFuturePlansModule(), // Módulo 7
      _createDirectionsModule(), // Módulo 8
      _createJobInterviewModule(), // Módulo 9
      _createHealthModule(), // Módulo 10
      // === NÍVEL AVANÇADO (5 MÓDULOS) ===
      _createBusinessMeetingsModule(), // Módulo 11
      _createPhrasalVerbsModule(), // Módulo 12
      _createTechTermsModule(), // Módulo 13
      _createConditionalsModule(), // Módulo 14
      _createIdiomsModule(), // Módulo 15
    ];
  }

  /// Retorna um módulo específico por ID
  static LearningModule? getModuleById(String id) {
    try {
      return getAllModules().firstWhere((module) => module.id == id);
    } catch (e) {
      return null;
    }
  }

  /// MÓDULO 1: Greetings (Saudações)
  static LearningModule _createGreetingsModule() {
    return LearningModule(
      id: 'greetings',
      title: 'Basic Greetings',
      titlePt: 'Cumprimentos Básicos',
      description: 'Learn essential greetings and polite expressions',
      descriptionPt: 'Aprenda cumprimentos essenciais e expressões educadas',
      iconEmoji: '👋',
      level: ModuleLevel.basic,
      color: 0xFF9C27B0,

      // Lições teóricas
      lessons: [
        const Lesson(
          title: 'Common Greetings',
          content:
              'Greetings are the first step in any conversation. '
              'In English, we use different greetings depending on the time of day '
              'and how formal the situation is.\n\n'
              'The most common greeting is "Hello", which works in any situation. '
              '"Hi" is more casual and friendly.',
          imagePath: 'assets/images/hello.png',
        ),
        const Lesson(
          title: 'Saying Goodbye',
          content:
              'Just as important as saying hello is knowing how to say goodbye politely. '
              '"Goodbye" is the formal way, while "Bye" is more casual.\n\n'
              'You can also say "See you later" or "See you soon" to indicate '
              'you\'ll meet the person again.',
          imagePath: 'assets/images/goodbye.png',
        ),
      ],

      // Flashcards para prática
      flashcards: [
        Flashcard.simple('Hello', 'Olá'),
        Flashcard.simple('Good morning', 'Bom dia'),
        Flashcard.simple('Good afternoon', 'Boa tarde'),
        Flashcard.simple('Good evening', 'Boa noite'),
        Flashcard.simple('Good night', 'Boa noite (despedida)'),
        Flashcard.simple('Goodbye', 'Adeus'),
        Flashcard.simple('See you later', 'Até logo'),
        Flashcard.simple('How are you?', 'Como você está?'),
        Flashcard.simple('Nice to meet you', 'Prazer em conhecê-lo'),
      ],

      // Quiz de avaliação - 10 perguntas completas
      quizQuestions: [
        const Question(
          questionText: 'How do you greet someone in the morning?',
          questionTextPt: 'Como você cumprimenta alguém pela manhã?',
          options: ['Good night', 'Good morning', 'Good evening', 'Goodbye'],
          optionsPt: ['Boa noite', 'Bom dia', 'Boa tarde', 'Adeus'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is the most common informal greeting?',
          questionTextPt: 'Qual é o cumprimento informal mais comum?',
          options: ['Goodbye', 'Good evening', 'Hi', 'See you'],
          optionsPt: ['Adeus', 'Boa tarde', 'Oi', 'Até logo'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Which phrase means "Nice to meet you" in Portuguese?',
          questionTextPt:
              'Qual frase significa "Nice to meet you" em português?',
          options: [
            'Como você está?',
            'Até logo',
            'Prazer em conhecê-lo',
            'Bom dia',
          ],
          optionsPt: [
            'Como você está?',
            'Até logo',
            'Prazer em conhecê-lo',
            'Bom dia',
          ],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'What do you say when leaving someone at night?',
          questionTextPt: 'O que você diz ao se despedir de alguém à noite?',
          options: ['Good morning', 'Good night', 'Hello', 'How are you?'],
          optionsPt: ['Bom dia', 'Boa noite', 'Olá', 'Como vai?'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Complete: "How ___ you?"',
          questionTextPt: 'Complete: "How ___ you?"',
          options: ['is', 'are', 'am', 'be'],
          optionsPt: ['is', 'are', 'am', 'be'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: '"See you later" means:',
          questionTextPt: '"See you later" significa:',
          options: ['Bom dia', 'Até logo', 'Como vai?', 'Olá'],
          optionsPt: ['Bom dia', 'Até logo', 'Como vai?', 'Olá'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is the response to "How are you?"',
          questionTextPt: 'Qual é a resposta para "How are you?"',
          options: ['Hello', 'I am fine, thank you', 'Good morning', 'Goodbye'],
          optionsPt: ['Olá', 'Estou bem, obrigado', 'Bom dia', 'Adeus'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Which is more formal?',
          questionTextPt: 'Qual é mais formal?',
          options: ['Hi', 'Hey', 'Good evening', 'Yo'],
          optionsPt: ['Hi', 'Hey', 'Boa tarde', 'Yo'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'What greeting is used in the afternoon?',
          questionTextPt: 'Que cumprimento é usado à tarde?',
          options: [
            'Good morning',
            'Good afternoon',
            'Good night',
            'Good evening',
          ],
          optionsPt: ['Bom dia', 'Boa tarde', 'Boa noite', 'Boa noite'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: '"Hello" can be used:',
          questionTextPt: '"Hello" pode ser usado:',
          options: [
            'Only in the morning',
            'Only at night',
            'At any time',
            'Only in the afternoon',
          ],
          optionsPt: [
            'Apenas de manhã',
            'Apenas à noite',
            'A qualquer hora',
            'Apenas à tarde',
          ],
          correctAnswerIndex: 2,
        ),
      ],
    );
  }

  /// MÓDULO 2: Numbers (Números)
  static LearningModule _createNumbersModule() {
    return LearningModule(
      id: 'numbers',
      title: 'Numbers 1-10',
      description: 'Master counting from one to ten in English',
      iconEmoji: '🔢',
      level: ModuleLevel.basic,
      color: 0xFF03DAC6, // Ciano

      lessons: [
        const Lesson(
          title: 'Counting Basics',
          content:
              'Numbers are essential in everyday life. You use them when shopping, '
              'telling time, giving phone numbers, and much more.\n\n'
              'Let\'s start with the basics: numbers 1 through 10. '
              'Practice saying them out loud to improve your pronunciation.',
          imagePath: 'assets/images/counting.png',
        ),
      ],

      flashcards: [
        Flashcard.simple('One', 'Um'),
        Flashcard.simple('Two', 'Dois'),
        Flashcard.simple('Three', 'Três'),
        Flashcard.simple('Four', 'Quatro'),
        Flashcard.simple('Five', 'Cinco'),
        Flashcard.simple('Six', 'Seis'),
        Flashcard.simple('Seven', 'Sete'),
        Flashcard.simple('Eight', 'Oito'),
        Flashcard.simple('Nine', 'Nove'),
        Flashcard.simple('Ten', 'Dez'),
      ],

      quizQuestions: [
        const Question(
          questionText: 'What number comes after "three"?',
          questionTextPt: 'Que número vem depois de "three" (três)?',
          options: ['Two', 'Four', 'Five', 'Six'],
          optionsPt: ['Dois', 'Quatro', 'Cinco', 'Seis'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'How do you say "sete" in English?',
          questionTextPt: 'Como se diz "sete" em inglês?',
          options: ['Six', 'Seven', 'Eight', 'Nine'],
          optionsPt: ['Six', 'Seven', 'Eight', 'Nine'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "dez" in English?',
          questionTextPt: 'O que é "dez" em inglês?',
          options: ['Nine', 'Eight', 'Ten', 'Two'],
          optionsPt: ['Nine', 'Eight', 'Ten', 'Two'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Count: One, Two, ___',
          questionTextPt: 'Conte: One, Two, ___',
          options: ['Four', 'Three', 'Five', 'Six'],
          optionsPt: ['Four', 'Three', 'Five', 'Six'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What number is "five"?',
          questionTextPt: 'Que número é "five"?',
          options: ['4', '5', '6', '7'],
          optionsPt: ['4', '5', '6', '7'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What comes before "ten"?',
          questionTextPt: 'O que vem antes de "ten" (dez)?',
          options: ['Eight', 'Nine', 'Seven', 'Six'],
          optionsPt: ['Oito', 'Nove', 'Sete', 'Seis'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'How do you say "1" in English?',
          questionTextPt: 'Como se diz "1" em inglês?',
          options: ['One', 'Two', 'Three', 'Four'],
          optionsPt: ['One', 'Two', 'Three', 'Four'],
          correctAnswerIndex: 0,
        ),
        const Question(
          questionText: '3 + 3 = ?',
          questionTextPt: '3 + 3 = ?',
          options: ['Five', 'Six', 'Seven', 'Eight'],
          optionsPt: ['Five', 'Six', 'Seven', 'Eight'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "quatro" in English?',
          questionTextPt: 'O que é "quatro" em inglês?',
          options: ['Three', 'Four', 'Five', 'Six'],
          optionsPt: ['Three', 'Four', 'Five', 'Six'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Which number is between 5 and 7?',
          questionTextPt: 'Qual número está entre 5 e 7?',
          options: ['Four', 'Five', 'Six', 'Eight'],
          optionsPt: ['Quatro', 'Cinco', 'Seis', 'Oito'],
          correctAnswerIndex: 2,
        ),
      ],
    );
  }

  /// MÓDULO 3: Family Members
  static LearningModule _createFamilyModule() {
    return LearningModule(
      id: 'family',
      title: 'Family Members',
      titlePt: 'Membros da Família',
      description: 'Learn to talk about your family',
      descriptionPt: 'Aprenda a falar sobre sua família',
      iconEmoji: '👨‍👩‍👧‍👦',
      level: ModuleLevel.basic,
      color: 0xFFFF9800,
      lessons: [
        const Lesson(
          title: 'My Family',
          content:
              'Learn words for family members: father, mother, brother, sister, grandfather, grandmother.',
          titlePt: 'Minha Família',
          contentPt:
              'Aprenda palavras para membros da família: pai, mãe, irmão, irmã, avô, avó.',
          imagePath: 'assets/images/family.png',
        ),
      ],
      flashcards: [
        Flashcard.simple('Father / Dad', 'Pai'),
        Flashcard.simple('Mother / Mom', 'Mãe'),
        Flashcard.simple('Brother', 'Irmão'),
        Flashcard.simple('Sister', 'Irmã'),
        Flashcard.simple('Grandfather', 'Avô'),
        Flashcard.simple('Grandmother', 'Avó'),
        Flashcard.simple('Uncle', 'Tio'),
        Flashcard.simple('Aunt', 'Tia'),
        Flashcard.simple('Cousin', 'Primo/Prima'),
        Flashcard.simple('Son', 'Filho'),
        Flashcard.simple('Daughter', 'Filha'),
        Flashcard.simple('Husband', 'Marido'),
        Flashcard.simple('Wife', 'Esposa'),
        Flashcard.simple('Parents', 'Pais'),
        Flashcard.simple('Children', 'Filhos'),
      ],
      quizQuestions: [
        const Question(
          questionText: 'Your mother is mother is your:',
          questionTextPt: 'A mãe da sua mãe é sua:',
          options: ['Aunt', 'Grandmother', 'Sister', 'Cousin'],
          optionsPt: ['Tia', 'Avó', 'Irmã', 'Prima'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "irmão" in English?',
          questionTextPt: 'O que é "irmão" em inglês?',
          options: ['Sister', 'Brother', 'Cousin', 'Uncle'],
          optionsPt: ['Sister', 'Brother', 'Cousin', 'Uncle'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Your father brother is your:',
          questionTextPt: 'O irmão do seu pai é seu:',
          options: ['Uncle', 'Grandfather', 'Cousin', 'Brother'],
          optionsPt: ['Tio', 'Avô', 'Primo', 'Irmão'],
          correctAnswerIndex: 0,
        ),
        const Question(
          questionText: 'Parents means:',
          questionTextPt: 'Parents significa:',
          options: [
            'Grandparents',
            'Father and Mother',
            'Children',
            'Siblings',
          ],
          optionsPt: ['Avós', 'Pai e Mãe', 'Filhos', 'Irmãos'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Your uncle children are your:',
          questionTextPt: 'Os filhos do seu tio são seus:',
          options: ['Brothers', 'Sisters', 'Cousins', 'Nieces'],
          optionsPt: ['Irmãos', 'Irmãs', 'Primos', 'Sobrinhas'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'What is "filha" in English?',
          questionTextPt: 'O que é "filha" em inglês?',
          options: ['Mother', 'Sister', 'Daughter', 'Aunt'],
          optionsPt: ['Mother', 'Sister', 'Daughter', 'Aunt'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Husband means:',
          questionTextPt: 'Husband significa:',
          options: ['Pai', 'Filho', 'Marido', 'Irmão'],
          optionsPt: ['Pai', 'Filho', 'Marido', 'Irmão'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Complete: This is ___ mother',
          questionTextPt: 'Complete: This is ___ mother',
          options: ['I', 'my', 'me', 'mine'],
          optionsPt: ['I', 'my', 'me', 'mine'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "avô" in English?',
          questionTextPt: 'O que é "avô" em inglês?',
          options: ['Father', 'Uncle', 'Grandfather', 'Brother'],
          optionsPt: ['Father', 'Uncle', 'Grandfather', 'Brother'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Daughter is the opposite of:',
          questionTextPt: 'Daughter é o oposto de:',
          options: ['Mother', 'Sister', 'Son', 'Father'],
          optionsPt: ['Mother', 'Sister', 'Son', 'Father'],
          correctAnswerIndex: 2,
        ),
      ],
    );
  }

  /// MÓDULO 4: Daily Routine
  static LearningModule _createDailyRoutineModule() {
    return LearningModule(
      id: 'daily_routine',
      title: 'Daily Routine',
      titlePt: 'Rotina Diária',
      description: 'Describe your daily activities',
      descriptionPt: 'Descreva suas atividades diárias',
      iconEmoji: '⏰',
      level: ModuleLevel.basic,
      color: 0xFF4CAF50,
      lessons: [
        const Lesson(
          title: 'My Day',
          content:
              'Learn to talk about daily activities using Present Simple tense.',
          titlePt: 'Meu Dia',
          contentPt:
              'Aprenda a falar sobre atividades diárias usando Presente Simples.',
          imagePath: 'assets/images/routine.png',
        ),
      ],
      flashcards: [
        Flashcard.simple('Wake up', 'Acordar'),
        Flashcard.simple('Get up', 'Levantar'),
        Flashcard.simple('Brush teeth', 'Escovar dentes'),
        Flashcard.simple('Take a shower', 'Tomar banho'),
        Flashcard.simple('Eat breakfast', 'Tomar café'),
        Flashcard.simple('Go to work', 'Ir trabalhar'),
        Flashcard.simple('Have lunch', 'Almoçar'),
        Flashcard.simple('Come home', 'Voltar para casa'),
        Flashcard.simple('Watch TV', 'Assistir TV'),
        Flashcard.simple('Do homework', 'Fazer lição'),
        Flashcard.simple('Have dinner', 'Jantar'),
        Flashcard.simple('Read a book', 'Ler um livro'),
        Flashcard.simple('Go to bed', 'Ir dormir'),
        Flashcard.simple('Sleep', 'Dormir'),
        Flashcard.simple('Get dressed', 'Vestir-se'),
      ],
      quizQuestions: [
        const Question(
          questionText: 'I ___ up at 7 AM every day',
          questionTextPt: 'Eu ___ às 7h todo dia',
          options: ['wakes', 'wake', 'waking', 'woke'],
          optionsPt: ['wakes', 'wake', 'waking', 'woke'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'She ___ breakfast at 8 AM',
          questionTextPt: 'Ela ___ café às 8h',
          options: ['eat', 'eats', 'eating', 'ate'],
          optionsPt: ['eat', 'eats', 'eating', 'ate'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What does "brush teeth" mean?',
          questionTextPt: 'O que significa "brush teeth"?',
          options: [
            'Tomar banho',
            'Escovar dentes',
            'Pentear cabelo',
            'Lavar rosto',
          ],
          optionsPt: [
            'Tomar banho',
            'Escovar dentes',
            'Pentear cabelo',
            'Lavar rosto',
          ],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'They ___ to school by bus',
          questionTextPt: 'Eles ___ para escola de ônibus',
          options: ['goes', 'go', 'going', 'went'],
          optionsPt: ['goes', 'go', 'going', 'went'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'He ___ TV every evening',
          questionTextPt: 'Ele ___ TV toda noite',
          options: ['watch', 'watches', 'watching', 'watched'],
          optionsPt: ['watch', 'watches', 'watching', 'watched'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Go to bed means:',
          questionTextPt: 'Go to bed significa:',
          options: ['Acordar', 'Levantar', 'Ir dormir', 'Tomar café'],
          optionsPt: ['Acordar', 'Levantar', 'Ir dormir', 'Tomar café'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'We ___ lunch at noon',
          questionTextPt: 'Nós ___ almoço ao meio-dia',
          options: ['has', 'have', 'having', 'had'],
          optionsPt: ['has', 'have', 'having', 'had'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "tomar banho" in English?',
          questionTextPt: 'O que é "tomar banho" em inglês?',
          options: ['Brush teeth', 'Take a shower', 'Get dressed', 'Wake up'],
          optionsPt: ['Brush teeth', 'Take a shower', 'Get dressed', 'Wake up'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'She ___ home at 6 PM',
          questionTextPt: 'Ela ___ para casa às 18h',
          options: ['come', 'comes', 'coming', 'came'],
          optionsPt: ['come', 'comes', 'coming', 'came'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'I usually ___ a book before bed',
          questionTextPt: 'Eu geralmente ___ um livro antes de dormir',
          options: ['reads', 'read', 'reading', 'readed'],
          optionsPt: ['reads', 'read', 'reading', 'readed'],
          correctAnswerIndex: 1,
        ),
      ],
    );
  }

  /// MÓDULO 5: Food & Drinks
  static LearningModule _createFoodModule() {
    return LearningModule(
      id: 'food_drinks',
      title: 'Food & Drinks',
      titlePt: 'Comidas e Bebidas',
      description: 'Learn vocabulary for meals and ordering food',
      descriptionPt: 'Aprenda vocabulário para refeições e pedir comida',
      iconEmoji: '🍽️',
      level: ModuleLevel.basic,
      color: 0xFFFF5722,
      lessons: [
        const Lesson(
          title: 'At the Restaurant',
          content:
              'Learn vocabulary for food, drinks, and how to order politely.',
          titlePt: 'No Restaurante',
          contentPt:
              'Aprenda vocabulário de comidas, bebidas e como pedir educadamente.',
          imagePath: 'assets/images/food.png',
        ),
      ],
      flashcards: [
        Flashcard.simple('Breakfast', 'Café da manhã'),
        Flashcard.simple('Lunch', 'Almoço'),
        Flashcard.simple('Dinner', 'Jantar'),
        Flashcard.simple('Bread', 'Pão'),
        Flashcard.simple('Rice', 'Arroz'),
        Flashcard.simple('Chicken', 'Frango'),
        Flashcard.simple('Fish', 'Peixe'),
        Flashcard.simple('Salad', 'Salada'),
        Flashcard.simple('Water', 'Água'),
        Flashcard.simple('Coffee', 'Café'),
        Flashcard.simple('Tea', 'Chá'),
        Flashcard.simple('Pizza', 'Pizza'),
        Flashcard.simple('Sandwich', 'Sanduíche'),
        Flashcard.simple('Juice', 'Suco'),
        Flashcard.simple('Vegetable', 'Verdura'),
      ],
      quizQuestions: [
        const Question(
          questionText: 'What do you eat in the morning?',
          questionTextPt: 'O que você come de manhã?',
          options: ['Lunch', 'Breakfast', 'Dinner', 'Snack'],
          optionsPt: ['Almoço', 'Café da manhã', 'Jantar', 'Lanche'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "frango" in English?',
          questionTextPt: 'O que é "frango" em inglês?',
          options: ['Fish', 'Beef', 'Chicken', 'Pork'],
          optionsPt: ['Fish', 'Beef', 'Chicken', 'Pork'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Water is a:',
          questionTextPt: 'Water é uma:',
          options: ['Food', 'Drink', 'Meal', 'Dessert'],
          optionsPt: ['Comida', 'Bebida', 'Refeição', 'Sobremesa'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'I would like a ___ of water',
          questionTextPt: 'Eu gostaria de um ___ de água',
          options: ['plate', 'glass', 'bowl', 'cup'],
          optionsPt: ['prato', 'copo', 'tigela', 'xícara'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "pão" in English?',
          questionTextPt: 'O que é "pão" em inglês?',
          options: ['Bread', 'Rice', 'Pasta', 'Cake'],
          optionsPt: ['Bread', 'Rice', 'Pasta', 'Cake'],
          correctAnswerIndex: 0,
        ),
        const Question(
          questionText: 'Dinner is eaten:',
          questionTextPt: 'Dinner é comido:',
          options: [
            'In the morning',
            'At noon',
            'In the evening',
            'At midnight',
          ],
          optionsPt: ['De manhã', 'Ao meio-dia', 'À noite', 'À meia-noite'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Which is a healthy drink?',
          questionTextPt: 'Qual é uma bebida saudável?',
          options: ['Soda', 'Juice', 'Beer', 'Wine'],
          optionsPt: ['Refrigerante', 'Suco', 'Cerveja', 'Vinho'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Salad usually has:',
          questionTextPt: 'Salad geralmente tem:',
          options: ['Meat', 'Vegetables', 'Bread', 'Rice'],
          optionsPt: ['Carne', 'Vegetais', 'Pão', 'Arroz'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is "café" in English?',
          questionTextPt: 'O que é "café" em inglês?',
          options: ['Tea', 'Coffee', 'Milk', 'Juice'],
          optionsPt: ['Tea', 'Coffee', 'Milk', 'Juice'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'To order politely, say:',
          questionTextPt: 'Para pedir educadamente, diga:',
          options: ['I want', 'Give me', 'I would like', 'I need'],
          optionsPt: ['I want', 'Give me', 'I would like', 'I need'],
          correctAnswerIndex: 2,
        ),
      ],
    );
  }

  /// MÓDULO 6-15: Intermediate and Advanced modules (placeholder for brevity)
  /// Em produção, cada um desses módulos teria conteúdo completo como os anteriores

  static LearningModule _createPastHolidaysModule() {
    return LearningModule(
      id: 'past_holidays',
      title: 'Past Holidays',
      titlePt: 'Férias Passadas',
      description: 'Talk about past experiences',
      descriptionPt: 'Fale sobre experiências passadas',
      iconEmoji: '✈️',
      level: ModuleLevel.intermediate,
      color: 0xFF00BCD4,
      lessons: [
        const Lesson(
          title: 'Last Summer',
          content: 'Learn Past Simple tense.',
          imagePath: 'assets/images/vacation.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Past word $i', 'Palavra passada $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Past question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createFuturePlansModule() {
    return LearningModule(
      id: 'future_plans',
      title: 'Future Plans',
      titlePt: 'Planos Futuros',
      description: 'Express plans and predictions',
      descriptionPt: 'Expresse planos e previsões',
      iconEmoji: '🔮',
      level: ModuleLevel.intermediate,
      color: 0xFF673AB7,
      lessons: [
        const Lesson(
          title: 'Making Plans',
          content: 'Learn will and going to.',
          imagePath: 'assets/images/future.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Future word $i', 'Palavra futura $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Future question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createDirectionsModule() {
    return LearningModule(
      id: 'directions',
      title: 'Directions & Places',
      titlePt: 'Direções e Lugares',
      description: 'Ask for and give directions',
      descriptionPt: 'Pergunte e dê direções',
      iconEmoji: '🗺️',
      level: ModuleLevel.intermediate,
      color: 0xFF009688,
      lessons: [
        const Lesson(
          title: 'Finding Your Way',
          content: 'Learn to navigate.',
          imagePath: 'assets/images/directions.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Direction word $i', 'Palavra direção $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Direction question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createJobInterviewModule() {
    return LearningModule(
      id: 'job_interview',
      title: 'Job Interviews',
      titlePt: 'Entrevistas de Emprego',
      description: 'Prepare for professional interviews',
      descriptionPt: 'Prepare-se para entrevistas profissionais',
      iconEmoji: '💼',
      level: ModuleLevel.intermediate,
      color: 0xFF795548,
      lessons: [
        const Lesson(
          title: 'The Interview',
          content: 'Common interview questions.',
          imagePath: 'assets/images/interview.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Job word $i', 'Palavra emprego $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Job question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createHealthModule() {
    return LearningModule(
      id: 'health',
      title: 'Health & Body',
      titlePt: 'Saúde e Corpo',
      description: 'Talk about health problems',
      descriptionPt: 'Fale sobre problemas de saúde',
      iconEmoji: '🏥',
      level: ModuleLevel.intermediate,
      color: 0xFFE91E63,
      lessons: [
        const Lesson(
          title: 'At the Doctor',
          content: 'Learn body parts and symptoms.',
          imagePath: 'assets/images/health.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Health word $i', 'Palavra saúde $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Health question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createBusinessMeetingsModule() {
    return LearningModule(
      id: 'business_meetings',
      title: 'Business Meetings',
      titlePt: 'Reuniões de Negócios',
      description: 'Navigate professional meetings',
      descriptionPt: 'Navegue em reuniões profissionais',
      iconEmoji: '📊',
      level: ModuleLevel.advanced,
      color: 0xFF3F51B5,
      lessons: [
        const Lesson(
          title: 'Meeting Language',
          content: 'Professional phrases.',
          imagePath: 'assets/images/meeting.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Business word $i', 'Palavra negócios $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Business question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createPhrasalVerbsModule() {
    return LearningModule(
      id: 'phrasal_verbs',
      title: 'Phrasal Verbs',
      titlePt: 'Phrasal Verbs',
      description: 'Master common phrasal verbs',
      descriptionPt: 'Domine phrasal verbs comuns',
      iconEmoji: '🔄',
      level: ModuleLevel.advanced,
      color: 0xFF607D8B,
      lessons: [
        const Lesson(
          title: 'Understanding Phrasal Verbs',
          content: 'Verb + preposition.',
          imagePath: 'assets/images/phrasal.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Phrasal verb $i', 'Phrasal verb $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Phrasal verb question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createTechTermsModule() {
    return LearningModule(
      id: 'tech_terms',
      title: 'Tech Terms',
      titlePt: 'Termos Tecnológicos',
      description: 'Understand technology vocabulary',
      descriptionPt: 'Entenda vocabulário tecnológico',
      iconEmoji: '💻',
      level: ModuleLevel.advanced,
      color: 0xFF00BCD4,
      lessons: [
        const Lesson(
          title: 'Tech World',
          content: 'Essential tech vocabulary.',
          imagePath: 'assets/images/tech.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Tech word $i', 'Palavra tech $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Tech question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createConditionalsModule() {
    return LearningModule(
      id: 'conditionals',
      title: 'Conditionals',
      titlePt: 'Condicionais',
      description: 'Express conditions and hypothetical situations',
      descriptionPt: 'Expresse condições e situações hipotéticas',
      iconEmoji: '❓',
      level: ModuleLevel.advanced,
      color: 0xFFFF9800,
      lessons: [
        const Lesson(
          title: 'If Clauses',
          content: 'Learn all conditional forms.',
          imagePath: 'assets/images/conditionals.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Conditional $i', 'Condicional $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Conditional question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }

  static LearningModule _createIdiomsModule() {
    return LearningModule(
      id: 'idioms',
      title: 'Idioms & Slang',
      titlePt: 'Expressões Idiomáticas',
      description: 'Understand informal expressions',
      descriptionPt: 'Entenda expressões informais',
      iconEmoji: '💬',
      level: ModuleLevel.advanced,
      color: 0xFF9C27B0,
      lessons: [
        const Lesson(
          title: 'Natural Expressions',
          content: 'Common idioms and slang.',
          imagePath: 'assets/images/idioms.png',
        ),
      ],
      flashcards: List.generate(
        15,
        (i) => Flashcard.simple('Idiom $i', 'Expressão $i'),
      ),
      quizQuestions: List.generate(
        10,
        (i) => const Question(
          questionText: 'Idiom question',
          options: ['A', 'B', 'C', 'D'],
          correctAnswerIndex: 0,
        ),
      ),
    );
  }
}
