import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../../core/localization/locale_provider.dart';
import '../../../shared/models/learning_module.dart';
import '../../../shared/widgets/flashcard_widget.dart';
import '../../../data/modules/sample_modules.dart';
import '../../../core/routes/app_routes.dart';

/// Tela genérica que exibe o conteúdo de um módulo de aprendizagem.
///
/// ARQUITETURA: Esta tela é reutilizável para qualquer módulo.
/// Recebe o ID do módulo e carrega seus dados dinamicamente.
///
/// COMPONENTES: Alterna entre lições (teoria) e flashcards (prática)
/// usando um PageView para navegação fluida.
class LearningModuleScreen extends StatefulWidget {
  /// ID do módulo a ser carregado
  final String moduleId;

  const LearningModuleScreen({super.key, required this.moduleId});

  @override
  State<LearningModuleScreen> createState() => _LearningModuleScreenState();
}

class _LearningModuleScreenState extends State<LearningModuleScreen> {
  /// Controlador do PageView para gerenciar navegação entre páginas
  late PageController _pageController;

  /// Índice da página atual
  int _currentPage = 0;

  /// Módulo carregado (pode ser null se ID inválido)
  LearningModule? _module;

  /// Quantidade total de páginas (lições + seção de flashcards + botão quiz)
  int _totalPages = 0;

  @override
  void initState() {
    super.initState();
    _pageController = PageController();
    _loadModule();
  }

  @override
  void dispose() {
    _pageController.dispose();
    super.dispose();
  }

  /// Carrega o módulo baseado no ID
  void _loadModule() {
    final module = SampleModules.getModuleById(widget.moduleId);

    if (module != null) {
      setState(() {
        _module = module;
        // Total = lições + 1 página de flashcards + 1 página de conclusão
        _totalPages = module.lessons.length + 2;
      });
    }
  }

  /// Navega para a próxima página
  void _nextPage() {
    if (_currentPage < _totalPages - 1) {
      _pageController.nextPage(
        duration: const Duration(milliseconds: 300),
        curve: Curves.easeInOut,
      );
    }
  }

  /// Navega para a página anterior
  void _previousPage() {
    if (_currentPage > 0) {
      _pageController.previousPage(
        duration: const Duration(milliseconds: 300),
        curve: Curves.easeInOut,
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    // Se módulo não foi encontrado, mostra erro
    if (_module == null) {
      return Scaffold(
        appBar: AppBar(title: const Text('Module Not Found')),
        body: const Center(child: Text('This module does not exist.')),
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(_module!.title),
        actions: [
          // Indicador de progresso
          Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16.0),
              child: Text(
                '${_currentPage + 1}/$_totalPages',
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
          // Barra de progresso visual
          LinearProgressIndicator(
            value: (_currentPage + 1) / _totalPages,
            backgroundColor: Colors.grey[200],
            valueColor: AlwaysStoppedAnimation<Color>(Color(_module!.color)),
          ),

          // Conteúdo principal (PageView)
          Expanded(
            child: PageView.builder(
              controller: _pageController,
              onPageChanged: (index) {
                setState(() {
                  _currentPage = index;
                });
              },
              itemCount: _totalPages,
              itemBuilder: (context, index) {
                return _buildPage(index);
              },
            ),
          ),

          // Botões de navegação
          _buildNavigationButtons(),
        ],
      ),
    );
  }

  /// Constrói o conteúdo de cada página baseado no índice
  Widget _buildPage(int index) {
    final lessonsCount = _module!.lessons.length;

    // Páginas de lições
    if (index < lessonsCount) {
      return _buildLessonPage(_module!.lessons[index]);
    }

    // Página de flashcards (penúltima)
    if (index == lessonsCount) {
      return _buildFlashcardsPage();
    }

    // Página de conclusão (última)
    return _buildCompletionPage();
  }

  /// Constrói uma página de lição
  Widget _buildLessonPage(lesson) {
    final localeProvider = Provider.of<LocaleProvider>(context);

    return SingleChildScrollView(
      padding: const EdgeInsets.all(24.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Ícone decorativo
          Center(
            child: Icon(
              Icons.book_outlined,
              size: 80,
              color: Color(_module!.color),
            ),
          ),

          const SizedBox(height: 24),

          // Título da lição
          Text(
            localeProvider.translate(lesson.title, lesson.titlePt),
            style: Theme.of(
              context,
            ).textTheme.displaySmall?.copyWith(color: Color(_module!.color)),
          ),

          const SizedBox(height: 16),

          // Conteúdo da lição
          Text(
            localeProvider.translate(lesson.content, lesson.contentPt),
            style: Theme.of(context).textTheme.bodyLarge?.copyWith(height: 1.6),
          ),

          const SizedBox(height: 24),

          // Dica de navegação
          Container(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Color(_module!.color).withOpacity(0.1),
              borderRadius: BorderRadius.circular(12),
              border: Border.all(color: Color(_module!.color).withOpacity(0.3)),
            ),
            child: Row(
              children: [
                Icon(Icons.lightbulb_outline, color: Color(_module!.color)),
                const SizedBox(width: 12),
                Expanded(
                  child: Text(
                    localeProvider.translate(
                      'Swipe or tap the button below to continue',
                      'Deslize ou toque no botão abaixo para continuar',
                    ),
                    style: TextStyle(
                      color: Color(_module!.color),
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  /// Constrói a página de prática com flashcards
  Widget _buildFlashcardsPage() {
    final localeProvider = Provider.of<LocaleProvider>(context);

    return SingleChildScrollView(
      padding: const EdgeInsets.all(24.0),
      child: Column(
        children: [
          // Título da seção
          Text(
            localeProvider.translate(
              'Practice with Flashcards',
              'Pratique com Flashcards',
            ),
            style: Theme.of(
              context,
            ).textTheme.displaySmall?.copyWith(color: Color(_module!.color)),
          ),

          const SizedBox(height: 8),

          Text(
            localeProvider.translate(
              'Tap each card to see the translation',
              'Toque em cada cartão para ver a tradução',
            ),
            style: Theme.of(
              context,
            ).textTheme.bodyMedium?.copyWith(color: Colors.grey[600]),
          ),

          const SizedBox(height: 24),

          // Grid de flashcards
          // IMPORTANTE: Aqui usamos nosso FlashcardWidget reutilizável!
          ...(_module!.flashcards.map((flashcard) {
            return Padding(
              padding: const EdgeInsets.only(bottom: 16.0),
              child: FlashcardWidget(flashcard: flashcard),
            );
          })),

          const SizedBox(height: 24),

          // Mensagem motivacional
          Container(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Colors.green.withOpacity(0.1),
              borderRadius: BorderRadius.circular(12),
            ),
            child: Row(
              children: [
                Icon(Icons.emoji_events, color: Colors.green, size: 32),
                SizedBox(width: 12),
                Expanded(
                  child: Text(
                    localeProvider.translate(
                      'Great job! Continue to test your knowledge with a quiz.',
                      'Ótimo trabalho! Continue para testar seus conhecimentos com um quiz.',
                    ),
                    style: TextStyle(
                      color: Colors.green,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  /// Constrói a página de conclusão com botão para o quiz
  Widget _buildCompletionPage() {
    final localeProvider = Provider.of<LocaleProvider>(context);

    return Padding(
      padding: const EdgeInsets.all(24.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(Icons.celebration, size: 100, color: Color(_module!.color)),

          const SizedBox(height: 24),

          Text(
            localeProvider.translate('Module Complete!', 'Módulo Completo!'),
            style: Theme.of(
              context,
            ).textTheme.displayMedium?.copyWith(color: Color(_module!.color)),
            textAlign: TextAlign.center,
          ),

          const SizedBox(height: 16),

          Text(
            localeProvider.translate(
              'You\'ve completed all lessons and practiced with flashcards. '
                  'Now it\'s time to test your knowledge!',
              'Você completou todas as lições e praticou com flashcards. '
                  'Agora é hora de testar seus conhecimentos!',
            ),
            style: Theme.of(context).textTheme.bodyLarge,
            textAlign: TextAlign.center,
          ),

          const SizedBox(height: 40),

          // Botão para iniciar o quiz
          SizedBox(
            width: double.infinity,
            child: ElevatedButton.icon(
              onPressed: () {
                Navigator.pushNamed(
                  context,
                  AppRoutes.quiz,
                  arguments: widget.moduleId,
                );
              },
              icon: const Icon(Icons.quiz, size: 28),
              label: Text(
                localeProvider.translate('Start Quiz', 'Iniciar Quiz'),
                style: TextStyle(fontSize: 18),
              ),
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.symmetric(vertical: 16),
                backgroundColor: Color(_module!.color),
              ),
            ),
          ),

          const SizedBox(height: 16),

          // Botão para voltar aos módulos
          SizedBox(
            width: double.infinity,
            child: OutlinedButton.icon(
              onPressed: () {
                Navigator.pop(context);
              },
              icon: const Icon(Icons.arrow_back),
              label: Text(
                localeProvider.translate(
                  'Back to Modules',
                  'Voltar aos Módulos',
                ),
              ),
              style: OutlinedButton.styleFrom(
                padding: const EdgeInsets.symmetric(vertical: 16),
              ),
            ),
          ),
        ],
      ),
    );
  }

  /// Constrói os botões de navegação na parte inferior
  Widget _buildNavigationButtons() {
    final localeProvider = Provider.of<LocaleProvider>(context);

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
      child: Row(
        children: [
          // Botão Anterior
          if (_currentPage > 0)
            Expanded(
              child: OutlinedButton.icon(
                onPressed: _previousPage,
                icon: const Icon(Icons.arrow_back),
                label: Text(localeProvider.translate('Previous', 'Anterior')),
                style: OutlinedButton.styleFrom(
                  padding: const EdgeInsets.symmetric(vertical: 12),
                ),
              ),
            ),

          if (_currentPage > 0) const SizedBox(width: 16),

          // Botão Próximo
          if (_currentPage < _totalPages - 1)
            Expanded(
              flex: _currentPage == 0 ? 1 : 1,
              child: ElevatedButton.icon(
                onPressed: _nextPage,
                icon: const Icon(Icons.arrow_forward),
                label: Text(localeProvider.translate('Next', 'Próximo')),
                style: ElevatedButton.styleFrom(
                  padding: const EdgeInsets.symmetric(vertical: 12),
                ),
              ),
            ),
        ],
      ),
    );
  }
}
