import 'package:flutter/material.dart';
import '../../../shared/models/question.dart';
import '../../../data/modules/sample_modules.dart';
import '../../../core/routes/app_routes.dart';

/// Tela de Quiz com gerenciamento de estado usando StatefulWidget.
///
/// ARQUITETURA: Demonstra gerenciamento de estado local para:
/// - Índice da questão atual
/// - Pontuação do usuário
/// - Feedback de respostas
///
/// FLUXO: Exibe uma questão por vez, valida resposta, atualiza pontuação,
/// e navega para tela de resultado ao finalizar.
class QuizScreen extends StatefulWidget {
  /// ID do módulo cujo quiz será exibido
  final String moduleId;

  const QuizScreen({super.key, required this.moduleId});

  @override
  State<QuizScreen> createState() => _QuizScreenState();
}

class _QuizScreenState extends State<QuizScreen> {
  /// Lista de questões do quiz
  List<Question> _questions = [];

  /// Índice da questão atual (0-based)
  int _currentQuestionIndex = 0;

  /// Pontuação atual do usuário
  int _score = 0;

  /// Índice da resposta selecionada pelo usuário (null = não respondeu ainda)
  int? _selectedAnswerIndex;

  /// Se true, mostra o feedback da resposta
  bool _showFeedback = false;

  /// Se true, a resposta selecionada está correta
  bool _isCorrect = false;

  @override
  void initState() {
    super.initState();
    _loadQuestions();
  }

  /// Carrega as questões do módulo
  void _loadQuestions() {
    final module = SampleModules.getModuleById(widget.moduleId);

    if (module != null) {
      setState(() {
        _questions = module.quizQuestions;
      });
    }
  }

  /// Processa a resposta selecionada pelo usuário
  void _selectAnswer(int index) {
    // Não permite mudar resposta após já ter respondido
    if (_showFeedback) return;

    final currentQuestion = _questions[_currentQuestionIndex];
    final isCorrect = currentQuestion.isCorrect(index);

    setState(() {
      _selectedAnswerIndex = index;
      _showFeedback = true;
      _isCorrect = isCorrect;

      // Incrementa pontuação se correto
      if (isCorrect) {
        _score++;
      }
    });
  }

  /// Avança para a próxima questão ou finaliza o quiz
  void _nextQuestion() {
    if (_currentQuestionIndex < _questions.length - 1) {
      // Próxima questão
      setState(() {
        _currentQuestionIndex++;
        _selectedAnswerIndex = null;
        _showFeedback = false;
        _isCorrect = false;
      });
    } else {
      // Quiz finalizado - navega para tela de resultado
      Navigator.pushReplacementNamed(
        context,
        AppRoutes.quizResult,
        arguments: {
          'moduleId': widget.moduleId,
          'score': _score,
          'total': _questions.length,
        },
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    // Se não há questões, mostra mensagem
    if (_questions.isEmpty) {
      return Scaffold(
        appBar: AppBar(title: const Text('Quiz')),
        body: const Center(
          child: Text('No questions available for this module.'),
        ),
      );
    }

    final currentQuestion = _questions[_currentQuestionIndex];
    final progress = (_currentQuestionIndex + 1) / _questions.length;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Quiz'),
        actions: [
          // Indicador de progresso textual
          Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16.0),
              child: Text(
                'Question ${_currentQuestionIndex + 1}/${_questions.length}',
                style: const TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
          ),
        ],
      ),
      body: Column(
        children: [
          // Barra de progresso
          LinearProgressIndicator(
            value: progress,
            backgroundColor: Colors.grey[200],
            minHeight: 8,
          ),

          // Conteúdo da questão
          Expanded(
            child: SingleChildScrollView(
              padding: const EdgeInsets.all(24.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  // Card da questão
                  Card(
                    elevation: 2,
                    child: Padding(
                      padding: const EdgeInsets.all(20.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          // Ícone de questão
                          Row(
                            children: [
                              Icon(
                                Icons.help_outline,
                                color: Theme.of(context).colorScheme.primary,
                                size: 32,
                              ),
                              const SizedBox(width: 12),
                              Expanded(
                                child: Text(
                                  'Question ${_currentQuestionIndex + 1}',
                                  style: TextStyle(
                                    fontSize: 18,
                                    fontWeight: FontWeight.bold,
                                    color: Theme.of(
                                      context,
                                    ).colorScheme.primary,
                                  ),
                                ),
                              ),
                            ],
                          ),

                          const SizedBox(height: 16),

                          // Texto da questão
                          Text(
                            currentQuestion.questionText,
                            style: const TextStyle(
                              fontSize: 20,
                              fontWeight: FontWeight.w600,
                              height: 1.4,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),

                  const SizedBox(height: 24),

                  // Opções de resposta
                  Text(
                    'Select your answer:',
                    style: Theme.of(
                      context,
                    ).textTheme.titleMedium?.copyWith(color: Colors.grey[700]),
                  ),

                  const SizedBox(height: 12),

                  ...List.generate(
                    currentQuestion.options.length,
                    (index) => _buildAnswerOption(
                      index: index,
                      text: currentQuestion.options[index],
                      isSelected: _selectedAnswerIndex == index,
                      isCorrect: currentQuestion.isCorrect(index),
                    ),
                  ),

                  // Feedback da resposta
                  if (_showFeedback) ...[
                    const SizedBox(height: 24),
                    _buildFeedback(currentQuestion),
                  ],
                ],
              ),
            ),
          ),

          // Botão de ação
          if (_showFeedback) _buildNextButton(),
        ],
      ),
    );
  }

  /// Constrói uma opção de resposta
  Widget _buildAnswerOption({
    required int index,
    required String text,
    required bool isSelected,
    required bool isCorrect,
  }) {
    // Determina a cor baseado no estado
    Color? backgroundColor;
    Color? borderColor;
    IconData? icon;

    if (_showFeedback) {
      if (isCorrect) {
        // Resposta correta sempre em verde
        backgroundColor = Colors.green.withOpacity(0.1);
        borderColor = Colors.green;
        icon = Icons.check_circle;
      } else if (isSelected && !isCorrect) {
        // Resposta incorreta selecionada em vermelho
        backgroundColor = Colors.red.withOpacity(0.1);
        borderColor = Colors.red;
        icon = Icons.cancel;
      }
    } else if (isSelected) {
      // Selecionada mas ainda não validada
      backgroundColor = Theme.of(context).colorScheme.primary.withOpacity(0.1);
      borderColor = Theme.of(context).colorScheme.primary;
    }

    return Padding(
      padding: const EdgeInsets.only(bottom: 12.0),
      child: InkWell(
        onTap: () => _selectAnswer(index),
        borderRadius: BorderRadius.circular(12),
        child: Container(
          padding: const EdgeInsets.all(16),
          decoration: BoxDecoration(
            color: backgroundColor ?? Colors.grey[50],
            border: Border.all(
              color: borderColor ?? Colors.grey[300]!,
              width: 2,
            ),
            borderRadius: BorderRadius.circular(12),
          ),
          child: Row(
            children: [
              // Círculo com letra da opção
              Container(
                width: 32,
                height: 32,
                decoration: BoxDecoration(
                  color: borderColor?.withOpacity(0.2) ?? Colors.grey[200],
                  shape: BoxShape.circle,
                ),
                child: Center(
                  child: Text(
                    String.fromCharCode(65 + index), // A, B, C, D
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: borderColor ?? Colors.grey[600],
                    ),
                  ),
                ),
              ),

              const SizedBox(width: 12),

              // Texto da opção
              Expanded(
                child: Text(
                  text,
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: isSelected
                        ? FontWeight.w600
                        : FontWeight.normal,
                    color: borderColor ?? Colors.black87,
                  ),
                ),
              ),

              // Ícone de feedback
              if (icon != null) Icon(icon, color: borderColor),
            ],
          ),
        ),
      ),
    );
  }

  /// Constrói o widget de feedback após responder
  Widget _buildFeedback(Question question) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: _isCorrect
            ? Colors.green.withOpacity(0.1)
            : Colors.orange.withOpacity(0.1),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(
          color: _isCorrect ? Colors.green : Colors.orange,
          width: 2,
        ),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Icon(
                _isCorrect ? Icons.celebration : Icons.info_outline,
                color: _isCorrect ? Colors.green : Colors.orange,
                size: 28,
              ),
              const SizedBox(width: 12),
              Expanded(
                child: Text(
                  _isCorrect ? 'Correct!' : 'Not quite!',
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: _isCorrect ? Colors.green : Colors.orange,
                  ),
                ),
              ),
            ],
          ),

          const SizedBox(height: 24),

          const SizedBox(height: 8),
          Text(
            'The correct answer is: ${question.correctAnswer}',
            style: const TextStyle(fontSize: 14, fontWeight: FontWeight.w600),
          ),
        ],
      ),
    );
  }

  /// Constrói o botão de próxima questão
  Widget _buildNextButton() {
    return Container(
      padding: const EdgeInsets.all(16.0),
      decoration: BoxDecoration(
        color: Colors.white,
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 10,
            offset: const Offset(0, -2),
          ),
        ],
      ),
      child: SizedBox(
        width: double.infinity,
        child: ElevatedButton(
          onPressed: _nextQuestion,
          style: ElevatedButton.styleFrom(
            padding: const EdgeInsets.symmetric(vertical: 16),
          ),
          child: Text(
            _currentQuestionIndex < _questions.length - 1
                ? 'Next Question'
                : 'Finish Quiz',
            style: const TextStyle(fontSize: 18),
          ),
        ),
      ),
    );
  }
}
