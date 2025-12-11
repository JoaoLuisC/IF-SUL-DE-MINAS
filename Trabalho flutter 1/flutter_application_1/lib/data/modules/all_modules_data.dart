import '../../shared/models/learning_module.dart';
import '../../shared/models/lesson.dart';
import '../../shared/models/flashcard.dart';
import '../../shared/models/question.dart';

class AllModulesData {
  // IDs for progress tracking
  static const String basicGreetingsId = 'basic_greetings';
  static const String numbersId = 'numbers_1_10';
  static const String colorsId = 'basic_colors';
  static const String familyId = 'family_members';
  static const String daysWeekId = 'days_week';

  static const String dailyRoutinesId = 'daily_routines';
  static const String foodDrinksId = 'food_drinks';
  static const String weatherId = 'weather_seasons';
  static const String directionsId = 'directions';
  static const String shoppingId = 'shopping';

  static const String jobInterviewId = 'job_interview';
  static const String travelAbroadId = 'travel_abroad';
  static const String businessEnglishId = 'business_english';
  static const String idiomsPhraseId = 'idioms_phrases';
  static const String academicEnglishId = 'academic_english';

  static List<LearningModule> getAllModules() {
    return [
      // ===== BASIC MODULES (3 por enquanto) =====
      _createBasicGreetingsModule(),
      _createNumbersModule(),
    ];
  }

  // ========== BASIC MODULE 1: GREETINGS ==========
  static LearningModule _createBasicGreetingsModule() {
    return LearningModule(
      id: basicGreetingsId,
      title: 'Basic Greetings',
      titlePt: 'Cumprimentos Básicos',
      description: 'Learn essential greetings and polite expressions',
      descriptionPt: 'Aprenda cumprimentos essenciais e expressões educadas',
      level: ModuleLevel.basic,
      iconEmoji: '👋',
      color: 0xFF9C27B0,
      lessons: [
        Lesson(
          title: 'Common Greetings',
          titlePt: 'Cumprimentos Comuns',
          content:
              'Greetings are the first step in any conversation. In English, we use different greetings depending on the time of day and how formal the situation is.\n\nThe most common greeting is "Hello", which works in any situation. "Hi" is more casual and friendly.',
          contentPt:
              'Cumprimentos são o primeiro passo em qualquer conversa. Em inglês, usamos diferentes cumprimentos dependendo da hora do dia e do quão formal é a situação.\n\nO cumprimento mais comum é "Hello", que funciona em qualquer situação. "Hi" é mais casual e amigável.',
          imagePath: 'assets/images/greetings.png',
        ),
        Lesson(
          title: 'Formal vs Informal',
          titlePt: 'Formal vs Informal',
          content:
              'Use "Good morning", "Good afternoon", and "Good evening" in formal situations. With friends and family, "Hi" and "Hey" are perfect!\n\nRemember: "Good night" is only used when saying goodbye at night.',
          contentPt:
              'Use "Good morning", "Good afternoon" e "Good evening" em situações formais. Com amigos e família, "Hi" e "Hey" são perfeitos!\n\nLembre-se: "Good night" é usado apenas ao despedir-se à noite.',
          imagePath: 'assets/images/formal.png',
        ),
      ],
      flashcards: [
        const Flashcard(frontText: 'Hello', backText: 'Olá'),
        const Flashcard(frontText: 'Hi', backText: 'Oi'),
        const Flashcard(frontText: 'Good morning', backText: 'Bom dia'),
        const Flashcard(frontText: 'Good afternoon', backText: 'Boa tarde'),
        const Flashcard(
          frontText: 'Good evening',
          backText: 'Boa noite (chegada)',
        ),
        const Flashcard(
          frontText: 'Good night',
          backText: 'Boa noite (despedida)',
        ),
        const Flashcard(frontText: 'Goodbye', backText: 'Adeus'),
        const Flashcard(frontText: 'See you later', backText: 'Até mais tarde'),
        const Flashcard(
          frontText: 'Nice to meet you',
          backText: 'Prazer em conhecê-lo',
        ),
        const Flashcard(frontText: 'How are you?', backText: 'Como você está?'),
        const Flashcard(
          frontText: "I'm fine, thanks",
          backText: 'Estou bem, obrigado',
        ),
        const Flashcard(
          frontText: 'What\'s your name?',
          backText: 'Qual é o seu nome?',
        ),
        const Flashcard(frontText: 'My name is...', backText: 'Meu nome é...'),
        const Flashcard(
          frontText: 'Pleased to meet you',
          backText: 'Satisfeito em conhecê-lo',
        ),
        const Flashcard(
          frontText: 'Have a nice day',
          backText: 'Tenha um bom dia',
        ),
      ],
      quizQuestions: [
        const Question(
          questionText: 'What is the most common greeting in English?',
          questionTextPt: 'Qual é o cumprimento mais comum em inglês?',
          options: ['Hello', 'Goodbye', 'Thanks', 'Please'],
          optionsPt: ['Hello', 'Goodbye', 'Thanks', 'Please'],
          correctAnswerIndex: 0,
        ),
        const Question(
          questionText: 'Which greeting is used in the morning?',
          questionTextPt: 'Qual cumprimento é usado pela manhã?',
          options: ['Good night', 'Good morning', 'Good evening', 'Goodbye'],
          optionsPt: ['Good night', 'Good morning', 'Good evening', 'Goodbye'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'How do you say "Prazer em conhecê-lo" in English?',
          questionTextPt: 'Como se diz "Prazer em conhecê-lo" em inglês?',
          options: [
            'See you later',
            'Nice to meet you',
            'Good morning',
            'Thank you',
          ],
          optionsPt: [
            'See you later',
            'Nice to meet you',
            'Good morning',
            'Thank you',
          ],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Which one is informal?',
          questionTextPt: 'Qual é informal?',
          options: ['Good evening', 'Hi', 'Good afternoon', 'Good morning'],
          optionsPt: ['Good evening', 'Hi', 'Good afternoon', 'Good morning'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What does "How are you?" mean?',
          questionTextPt: 'O que significa "How are you?"',
          options: [
            'Qual seu nome?',
            'Como você está?',
            'Onde você mora?',
            'Quantos anos você tem?',
          ],
          optionsPt: [
            'Qual seu nome?',
            'Como você está?',
            'Onde você mora?',
            'Quantos anos você tem?',
          ],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'When do you use "Good night"?',
          questionTextPt: 'Quando você usa "Good night"?',
          options: [
            'In the morning',
            'When meeting someone',
            'When saying goodbye at night',
            'At noon',
          ],
          optionsPt: [
            'De manhã',
            'Ao encontrar alguém',
            'Ao despedir-se à noite',
            'Ao meio-dia',
          ],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'Complete: "_____ to meet you"',
          questionTextPt: 'Complete: "_____ to meet you"',
          options: ['Bad', 'Nice', 'Sad', 'Angry'],
          optionsPt: ['Bad', 'Nice', 'Sad', 'Angry'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'How do you ask someone\'s name?',
          questionTextPt: 'Como você pergunta o nome de alguém?',
          options: [
            'How are you?',
            'What\'s your name?',
            'Where are you?',
            'How old are you?',
          ],
          optionsPt: [
            'How are you?',
            'What\'s your name?',
            'Where are you?',
            'How old are you?',
          ],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: '"See you later" means:',
          questionTextPt: '"See you later" significa:',
          options: ['Bom dia', 'Até mais tarde', 'Como vai?', 'Meu nome é'],
          optionsPt: ['Bom dia', 'Até mais tarde', 'Como vai?', 'Meu nome é'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'The response to "How are you?" is:',
          questionTextPt: 'A resposta para "How are you?" é:',
          options: ['My name is John', 'I\'m fine, thanks', 'Goodbye', 'Hello'],
          optionsPt: [
            'My name is John',
            'I\'m fine, thanks',
            'Goodbye',
            'Hello',
          ],
          correctAnswerIndex: 1,
        ),
      ],
    );
  }

  // ========== BASIC MODULE 2: NUMBERS ==========
  static LearningModule _createNumbersModule() {
    return LearningModule(
      id: numbersId,
      title: 'Numbers 1-10',
      titlePt: 'Números 1-10',
      description: 'Master counting from one to ten in English',
      descriptionPt: 'Domine a contagem de um a dez em inglês',
      level: ModuleLevel.basic,
      iconEmoji: '🔢',
      color: 0xFF2196F3,
      lessons: [
        Lesson(
          title: 'Counting Basics',
          titlePt: 'Contagem Básica',
          content:
              'Numbers are essential in daily life. Let\'s start with 1-10:\n1=One, 2=Two, 3=Three, 4=Four, 5=Five, 6=Six, 7=Seven, 8=Eight, 9=Nine, 10=Ten.\n\nPractice saying them out loud!',
          contentPt:
              'Números são essenciais no dia a dia. Vamos começar com 1-10:\n1=One, 2=Two, 3=Three, 4=Four, 5=Five, 6=Six, 7=Seven, 8=Eight, 9=Nine, 10=Ten.\n\nPratique dizê-los em voz alta!',
          imagePath: 'assets/images/numbers.png',
        ),
      ],
      flashcards: [
        const Flashcard(frontText: 'One', backText: 'Um (1)'),
        const Flashcard(frontText: 'Two', backText: 'Dois (2)'),
        const Flashcard(frontText: 'Three', backText: 'Três (3)'),
        const Flashcard(frontText: 'Four', backText: 'Quatro (4)'),
        const Flashcard(frontText: 'Five', backText: 'Cinco (5)'),
        const Flashcard(frontText: 'Six', backText: 'Seis (6)'),
        const Flashcard(frontText: 'Seven', backText: 'Sete (7)'),
        const Flashcard(frontText: 'Eight', backText: 'Oito (8)'),
        const Flashcard(frontText: 'Nine', backText: 'Nove (9)'),
        const Flashcard(frontText: 'Ten', backText: 'Dez (10)'),
        const Flashcard(frontText: 'Zero', backText: 'Zero (0)'),
        const Flashcard(frontText: 'How many?', backText: 'Quantos?'),
        const Flashcard(frontText: 'Count', backText: 'Contar'),
        const Flashcard(frontText: 'Number', backText: 'Número'),
        const Flashcard(frontText: 'First', backText: 'Primeiro'),
      ],
      quizQuestions: [
        const Question(
          questionText: 'What is "três" in English?',
          questionTextPt: 'O que é "três" em inglês?',
          options: ['Two', 'Three', 'Four', 'Five'],
          optionsPt: ['Two', 'Three', 'Four', 'Five'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'How do you write 7 in words?',
          questionTextPt: 'Como você escreve 7 por extenso?',
          options: ['Six', 'Seven', 'Eight', 'Nine'],
          optionsPt: ['Six', 'Seven', 'Eight', 'Nine'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What number is "Five"?',
          questionTextPt: 'Que número é "Five"?',
          options: ['4', '5', '6', '7'],
          optionsPt: ['4', '5', '6', '7'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Which is the smallest?',
          questionTextPt: 'Qual é o menor?',
          options: ['Ten', 'Five', 'One', 'Eight'],
          optionsPt: ['Ten', 'Five', 'One', 'Eight'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'What comes after Six?',
          questionTextPt: 'O que vem depois de Six?',
          options: ['Five', 'Seven', 'Eight', 'Nine'],
          optionsPt: ['Five', 'Seven', 'Eight', 'Nine'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'What is 2 + 3?',
          questionTextPt: 'Quanto é 2 + 3?',
          options: ['Four', 'Five', 'Six', 'Seven'],
          optionsPt: ['Four', 'Five', 'Six', 'Seven'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: '"Ten" means:',
          questionTextPt: '"Ten" significa:',
          options: ['8', '9', '10', '11'],
          optionsPt: ['8', '9', '10', '11'],
          correctAnswerIndex: 2,
        ),
        const Question(
          questionText: 'What is "um" in English?',
          questionTextPt: 'O que é "um" em inglês?',
          options: ['Zero', 'One', 'Two', 'Ten'],
          optionsPt: ['Zero', 'One', 'Two', 'Ten'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Count: One, Two, ___',
          questionTextPt: 'Conte: One, Two, ___',
          options: ['Four', 'Three', 'Five', 'Six'],
          optionsPt: ['Four', 'Three', 'Five', 'Six'],
          correctAnswerIndex: 1,
        ),
        const Question(
          questionText: 'Which number comes before Nine?',
          questionTextPt: 'Qual número vem antes de Nine?',
          options: ['Seven', 'Eight', 'Ten', 'Six'],
          optionsPt: ['Seven', 'Eight', 'Ten', 'Six'],
          correctAnswerIndex: 1,
        ),
      ],
    );
  }

  // Continua no próximo arquivo...
  static List<String> getAllModuleIds() {
    return [
      basicGreetingsId,
      numbersId,
      colorsId,
      familyId,
      daysWeekId,
      dailyRoutinesId,
      foodDrinksId,
      weatherId,
      directionsId,
      shoppingId,
      jobInterviewId,
      travelAbroadId,
      businessEnglishId,
      idiomsPhraseId,
      academicEnglishId,
    ];
  }
}
