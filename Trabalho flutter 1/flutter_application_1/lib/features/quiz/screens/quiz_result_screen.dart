import 'package:flutter/material.dart';
import '../../../core/services/progress_service.dart';
import '../../../data/modules/sample_modules.dart';

/// Tela que exibe o resultado final do quiz.
///
/// RESPONSABILIDADE: Mostrar pontuação, feedback motivacional,
/// salvar progresso e opções para continuar navegando no app.
class QuizResultScreen extends StatefulWidget {
  /// ID do módulo concluído
  final String moduleId;

  /// Pontuação obtida pelo usuário
  final int score;

  /// Quantidade total de questões
  final int totalQuestions;

  const QuizResultScreen({
    super.key,
    required this.moduleId,
    required this.score,
    required this.totalQuestions,
  });

  @override
  State<QuizResultScreen> createState() => _QuizResultScreenState();
}

class _QuizResultScreenState extends State<QuizResultScreen> {
  bool _nextModuleUnlocked = false;
  String? _unlockedModuleName;

  @override
  void initState() {
    super.initState();
    _saveProgress();
  }

  /// Salva o progresso do módulo e verifica se desbloqueou o próximo
  Future<void> _saveProgress() async {
    // Salva a pontuação
    await ProgressService.saveModuleScore(
      widget.moduleId,
      widget.score,
      widget.totalQuestions,
    );

    // Verifica se desbloqueou o próximo módulo
    final percentage = (widget.score / widget.totalQuestions) * 100;
    if (percentage >= 70) {
      final allModules = SampleModules.getAllModules();
      final currentIndex = allModules.indexWhere(
        (m) => m.id == widget.moduleId,
      );

      if (currentIndex >= 0 && currentIndex < allModules.length - 1) {
        final nextModule = allModules[currentIndex + 1];
        final allModuleIds = allModules.map((m) => m.id).toList();

        final isUnlocked = await ProgressService.isModuleUnlocked(
          currentIndex + 1,
          allModuleIds,
        );

        if (isUnlocked) {
          setState(() {
            _nextModuleUnlocked = true;
            _unlockedModuleName = nextModule.title;
          });
        }
      }
    }
  }

  /// Calcula a porcentagem de acertos
  double get _percentage => (widget.score / widget.totalQuestions) * 100;

  /// Retorna mensagem motivacional baseada no desempenho
  String get _motivationalMessage {
    if (_percentage == 100) {
      return 'Perfect! You\'re a star!';
    } else if (_percentage >= 80) {
      return 'Excellent work!';
    } else if (_percentage >= 60) {
      return 'Good job! Keep practicing!';
    } else if (_percentage >= 40) {
      return 'Not bad! Review the content and try again.';
    } else {
      return 'Keep learning! Practice makes perfect.';
    }
  }

  /// Retorna cor baseada no desempenho
  Color get _performanceColor {
    if (_percentage >= 80) {
      return Colors.green;
    } else if (_percentage >= 60) {
      return Colors.orange;
    } else {
      return Colors.red;
    }
  }

  /// Retorna ícone baseado no desempenho
  IconData get _performanceIcon {
    if (_percentage >= 80) {
      return Icons.emoji_events;
    } else if (_percentage >= 60) {
      return Icons.thumb_up;
    } else {
      return Icons.school;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Quiz Results'),
        automaticallyImplyLeading: false, // Remove botão de voltar
      ),
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              // Banner de desbloqueio (se desbloqueou próximo módulo)
              if (_nextModuleUnlocked && _unlockedModuleName != null)
                Container(
                  margin: const EdgeInsets.only(bottom: 24),
                  padding: const EdgeInsets.all(16),
                  decoration: BoxDecoration(
                    color: Colors.green[50],
                    borderRadius: BorderRadius.circular(12),
                    border: Border.all(color: Colors.green, width: 2),
                  ),
                  child: Row(
                    children: [
                      Container(
                        padding: const EdgeInsets.all(8),
                        decoration: BoxDecoration(
                          color: Colors.green,
                          shape: BoxShape.circle,
                        ),
                        child: const Icon(
                          Icons.lock_open,
                          color: Colors.white,
                          size: 24,
                        ),
                      ),
                      const SizedBox(width: 12),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            const Text(
                              '🎉 Module Unlocked!',
                              style: TextStyle(
                                fontSize: 16,
                                fontWeight: FontWeight.bold,
                                color: Colors.green,
                              ),
                            ),
                            const SizedBox(height: 4),
                            Text(
                              _unlockedModuleName!,
                              style: TextStyle(
                                fontSize: 14,
                                color: Colors.grey[700],
                                fontWeight: FontWeight.w500,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),

              // Ícone de resultado
              Container(
                width: 120,
                height: 120,
                decoration: BoxDecoration(
                  color: _performanceColor.withOpacity(0.1),
                  shape: BoxShape.circle,
                ),
                child: Icon(
                  _performanceIcon,
                  size: 64,
                  color: _performanceColor,
                ),
              ),

              const SizedBox(height: 32),

              // Mensagem motivacional
              Text(
                _motivationalMessage,
                style: Theme.of(
                  context,
                ).textTheme.displaySmall?.copyWith(color: _performanceColor),
                textAlign: TextAlign.center,
              ),

              const SizedBox(height: 40),

              // Card com pontuação
              Card(
                elevation: 4,
                child: Padding(
                  padding: const EdgeInsets.all(32.0),
                  child: Column(
                    children: [
                      Text(
                        'Your Score',
                        style: Theme.of(context).textTheme.titleLarge?.copyWith(
                          color: Colors.grey[600],
                        ),
                      ),

                      const SizedBox(height: 16),

                      // Pontuação grande
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.baseline,
                        textBaseline: TextBaseline.alphabetic,
                        children: [
                          Text(
                            '${widget.score}',
                            style: TextStyle(
                              fontSize: 72,
                              fontWeight: FontWeight.bold,
                              color: _performanceColor,
                            ),
                          ),
                          Text(
                            ' / ${widget.totalQuestions}',
                            style: TextStyle(
                              fontSize: 36,
                              fontWeight: FontWeight.bold,
                              color: Colors.grey[600],
                            ),
                          ),
                        ],
                      ),

                      const SizedBox(height: 16),

                      // Porcentagem
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 16,
                          vertical: 8,
                        ),
                        decoration: BoxDecoration(
                          color: _performanceColor.withOpacity(0.1),
                          borderRadius: BorderRadius.circular(20),
                        ),
                        child: Text(
                          '${_percentage.toStringAsFixed(0)}%',
                          style: TextStyle(
                            fontSize: 24,
                            fontWeight: FontWeight.bold,
                            color: _performanceColor,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),

              const SizedBox(height: 40),

              // Estatísticas adicionais
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  _buildStatCard(
                    context,
                    icon: Icons.check_circle,
                    label: 'Correct',
                    value: widget.score.toString(),
                    color: Colors.green,
                  ),
                  _buildStatCard(
                    context,
                    icon: Icons.cancel,
                    label: 'Incorrect',
                    value: (widget.totalQuestions - widget.score).toString(),
                    color: Colors.red,
                  ),
                ],
              ),

              const SizedBox(height: 40),

              // Botões de ação
              SizedBox(
                width: double.infinity,
                child: ElevatedButton.icon(
                  onPressed: () {
                    // Volta para a lista de módulos (remove todas as rotas)
                    Navigator.popUntil(context, (route) => route.isFirst);
                  },
                  icon: const Icon(Icons.home),
                  label: const Text('Back to Home'),
                  style: ElevatedButton.styleFrom(
                    padding: const EdgeInsets.symmetric(vertical: 16),
                  ),
                ),
              ),

              const SizedBox(height: 12),

              SizedBox(
                width: double.infinity,
                child: OutlinedButton.icon(
                  onPressed: () {
                    // Volta para a lista de módulos (uma tela atrás)
                    Navigator.pop(context);
                  },
                  icon: const Icon(Icons.list),
                  label: const Text('View All Modules'),
                  style: OutlinedButton.styleFrom(
                    padding: const EdgeInsets.symmetric(vertical: 16),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  /// Constrói um card de estatística
  Widget _buildStatCard(
    BuildContext context, {
    required IconData icon,
    required String label,
    required String value,
    required Color color,
  }) {
    return Container(
      width: 140,
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: color.withOpacity(0.1),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: color.withOpacity(0.3)),
      ),
      child: Column(
        children: [
          Icon(icon, color: color, size: 32),
          const SizedBox(height: 8),
          Text(
            value,
            style: TextStyle(
              fontSize: 32,
              fontWeight: FontWeight.bold,
              color: color,
            ),
          ),
          Text(
            label,
            style: TextStyle(
              fontSize: 14,
              color: Colors.grey[600],
              fontWeight: FontWeight.w600,
            ),
          ),
        ],
      ),
    );
  }
}
