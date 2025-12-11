import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../../core/routes/app_routes.dart';
import '../../../core/localization/locale_provider.dart';
import '../../../core/services/progress_service.dart';
import '../../../data/modules/sample_modules.dart';

/// Tela que lista todos os módulos de aprendizagem disponíveis.
///
/// RESPONSABILIDADE: Apresentar os módulos de forma visual e organizada,
/// permitindo navegação para o conteúdo de cada módulo.
class ModulesListScreen extends StatefulWidget {
  const ModulesListScreen({super.key});

  @override
  State<ModulesListScreen> createState() => _ModulesListScreenState();
}

class _ModulesListScreenState extends State<ModulesListScreen> {
  Map<String, bool> _unlockedModules = {};
  Map<String, ModuleProgress?> _moduleProgress = {};
  bool _isLoading = true;

  @override
  void initState() {
    super.initState();
    _loadProgress();
  }

  Future<void> _loadProgress() async {
    final modules = SampleModules.getAllModules();
    final allModuleIds = modules.map((m) => m.id).toList();

    final unlockedMap = <String, bool>{};
    final progressMap = <String, ModuleProgress?>{};

    for (int i = 0; i < modules.length; i++) {
      final moduleId = modules[i].id;
      final isUnlocked = await ProgressService.isModuleUnlocked(
        i,
        allModuleIds,
      );
      final progress = await ProgressService.getModuleProgress(moduleId);

      unlockedMap[moduleId] = isUnlocked;
      progressMap[moduleId] = progress;
    }

    setState(() {
      _unlockedModules = unlockedMap;
      _moduleProgress = progressMap;
      _isLoading = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    final modules = SampleModules.getAllModules();
    final localeProvider = Provider.of<LocaleProvider>(context);

    if (_isLoading) {
      return Scaffold(
        appBar: AppBar(
          title: Text(
            localeProvider.translate(
              'Learning Modules',
              'Módulos de Aprendizado',
            ),
          ),
        ),
        body: const Center(child: CircularProgressIndicator()),
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(
          localeProvider.translate(
            'Learning Modules',
            'Módulos de Aprendizado',
          ),
        ),
      ),
      body: modules.isEmpty
          ? _buildEmptyState(context)
          : ListView.builder(
              padding: const EdgeInsets.all(16),
              itemCount: modules.length,
              itemBuilder: (context, index) {
                final module = modules[index];
                final isUnlocked = _unlockedModules[module.id] ?? false;
                final progress = _moduleProgress[module.id];
                final isCompleted =
                    progress != null && progress.percentage >= 70;

                return Card(
                  elevation: 4,
                  margin: const EdgeInsets.only(bottom: 16),
                  child: Opacity(
                    opacity: isUnlocked ? 1.0 : 0.5,
                    child: InkWell(
                      onTap: isUnlocked
                          ? () {
                              Navigator.pushNamed(
                                context,
                                AppRoutes.learningModule,
                                arguments: module.id,
                              );
                            }
                          : () {
                              ScaffoldMessenger.of(context).showSnackBar(
                                SnackBar(
                                  content: Text(
                                    localeProvider.translate(
                                      'Complete the previous module with 70% to unlock',
                                      'Complete o módulo anterior com 70% para desbloquear',
                                    ),
                                  ),
                                ),
                              );
                            },
                      borderRadius: BorderRadius.circular(12),
                      child: Padding(
                        padding: const EdgeInsets.all(16.0),
                        child: Row(
                          children: [
                            // Ícone do módulo
                            Container(
                              width: 60,
                              height: 60,
                              decoration: BoxDecoration(
                                color: Color(module.color).withOpacity(0.2),
                                borderRadius: BorderRadius.circular(16),
                              ),
                              child: Text(
                                module.iconEmoji,
                                style: const TextStyle(fontSize: 32),
                              ),
                            ),

                            const SizedBox(width: 16),

                            // Informações do módulo
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    module.title,
                                    style: Theme.of(
                                      context,
                                    ).textTheme.headlineMedium,
                                  ),
                                  const SizedBox(height: 4),
                                  Text(
                                    module.description,
                                    style: Theme.of(
                                      context,
                                    ).textTheme.bodyMedium,
                                    maxLines: 2,
                                    overflow: TextOverflow.ellipsis,
                                  ),
                                  const SizedBox(height: 8),
                                  // Badge com quantidade de conteúdo
                                  Wrap(
                                    spacing: 8,
                                    children: [
                                      _buildBadge(
                                        context,
                                        Icons.book,
                                        '${module.lessons.length} Lessons',
                                      ),
                                      _buildBadge(
                                        context,
                                        Icons.style,
                                        '${module.flashcards.length} Cards',
                                      ),
                                      _buildBadge(
                                        context,
                                        Icons.quiz,
                                        '${module.quizQuestions.length} Questions',
                                      ),
                                    ],
                                  ),
                                ],
                              ),
                            ),

                            // Ícone de navegação
                            // Status icon
                            if (!isUnlocked)
                              const Icon(Icons.lock, color: Colors.grey)
                            else if (isCompleted)
                              const Icon(
                                Icons.check_circle,
                                color: Colors.green,
                              )
                            else
                              Icon(
                                Icons.arrow_forward_ios,
                                color: Colors.grey[400],
                              ),
                          ],
                        ),
                      ),
                    ),
                  ),
                );
              },
            ),
    );
  }

  /// Widget para estado vazio
  Widget _buildEmptyState(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(Icons.folder_open, size: 80, color: Colors.grey[400]),
          const SizedBox(height: 16),
          Text(
            'No modules available',
            style: Theme.of(
              context,
            ).textTheme.headlineMedium?.copyWith(color: Colors.grey[600]),
          ),
          const SizedBox(height: 8),
          Text(
            'Check back later for new content!',
            style: Theme.of(
              context,
            ).textTheme.bodyMedium?.copyWith(color: Colors.grey[500]),
          ),
        ],
      ),
    );
  }

  /// Constrói um badge de informação
  Widget _buildBadge(BuildContext context, IconData icon, String label) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
      decoration: BoxDecoration(
        color: Theme.of(context).colorScheme.primary.withOpacity(0.1),
        borderRadius: BorderRadius.circular(12),
      ),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Icon(icon, size: 14, color: Theme.of(context).colorScheme.primary),
          const SizedBox(width: 4),
          Text(
            label,
            style: TextStyle(
              fontSize: 12,
              color: Theme.of(context).colorScheme.primary,
              fontWeight: FontWeight.w600,
            ),
          ),
        ],
      ),
    );
  }
}
