import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../../core/localization/locale_provider.dart';

/// Tela de créditos do aplicativo.
///
/// RESPONSABILIDADE: Exibir informações sobre desenvolvedores,
/// referências, licenças e agradecimentos.
class CreditsScreen extends StatelessWidget {
  const CreditsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final localeProvider = Provider.of<LocaleProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text(localeProvider.translate('Credits', 'Créditos')),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Logo ou ícone
              Center(
                child: Icon(
                  Icons.info_outline,
                  size: 80,
                  color: Theme.of(context).colorScheme.primary,
                ),
              ),

              const SizedBox(height: 24),

              // Título
              Text(
                localeProvider.translate(
                  'About This App',
                  'Sobre Este Aplicativo',
                ),
                style: Theme.of(context).textTheme.displaySmall,
              ),

              const SizedBox(height: 16),

              // Descrição
              Text(
                localeProvider.translate(
                  'English for Beginners is an interactive educational application '
                      'designed to help students learn English vocabulary and basic phrases '
                      'through engaging flashcards and quizzes.',
                  'English for Beginners é um aplicativo educacional interativo '
                      'desenvolvido para ajudar estudantes a aprender vocabulário e frases básicas '
                      'em inglês através de flashcards envolventes e quizzes.',
                ),
                style: Theme.of(context).textTheme.bodyLarge,
              ),

              const SizedBox(height: 32),

              // Seção: Desenvolvido por
              _buildSection(
                context,
                localeProvider: localeProvider,
                title: localeProvider.translate(
                  'Developed By',
                  'Desenvolvido Por',
                ),
                items: [
                  'Instituto Federal do Sul de Minas',
                  localeProvider.translate(
                    'João Luis Cardoso',
                    'João Luis Cardoso',
                  ),
                  localeProvider.translate(
                    'Project I: Interactive Educational App',
                    'Projeto I: Aplicativo Educacional Interativo',
                  ),
                ],
              ),

              const SizedBox(height: 24),

              // Seção: Tecnologias
              _buildSection(
                context,
                localeProvider: localeProvider,
                title: localeProvider.translate('Built With', 'Construído Com'),
                items: [
                  'Flutter SDK',
                  localeProvider.translate(
                    'Dart Programming Language',
                    'Linguagem de Programação Dart',
                  ),
                  'Material Design 3',
                ],
              ),

              const SizedBox(height: 24),

              // Seção: Funcionalidades
              _buildSection(
                context,
                localeProvider: localeProvider,
                title: localeProvider.translate(
                  'Key Features',
                  'Recursos Principais',
                ),
                items: [
                  localeProvider.translate(
                    '✨ Interactive Flashcards with flip animation',
                    '✨ Flashcards interativos com animação de virar',
                  ),
                  localeProvider.translate(
                    '📚 Multiple learning modules',
                    '📚 Múltiplos módulos de aprendizagem',
                  ),
                  localeProvider.translate(
                    '❓ Quizzes with immediate feedback',
                    '❓ Quizzes com feedback imediato',
                  ),
                  localeProvider.translate(
                    '📱 Responsive design for all devices',
                    '📱 Design responsivo para todos os dispositivos',
                  ),
                ],
              ),

              const SizedBox(height: 32),

              // Versão
              Center(
                child: Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 16,
                    vertical: 8,
                  ),
                  decoration: BoxDecoration(
                    color: Theme.of(
                      context,
                    ).colorScheme.primary.withOpacity(0.1),
                    borderRadius: BorderRadius.circular(20),
                  ),
                  child: Text(
                    localeProvider.translate('Version 1.0.0', 'Versão 1.0.0'),
                    style: TextStyle(
                      color: Theme.of(context).colorScheme.primary,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ),

              const SizedBox(height: 16),

              // Copyright
              Center(
                child: Text(
                  localeProvider.translate(
                    '© 2025 All rights reserved',
                    '© 2025 Todos os direitos reservados',
                  ),
                  style: Theme.of(context).textTheme.bodySmall,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  /// Método auxiliar para construir seções de créditos
  Widget _buildSection(
    BuildContext context, {
    required LocaleProvider localeProvider,
    required String title,
    required List<String> items,
  }) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          title,
          style: Theme.of(context).textTheme.headlineMedium?.copyWith(
            color: Theme.of(context).colorScheme.primary,
          ),
        ),
        const SizedBox(height: 12),
        ...items.map(
          (item) => Padding(
            padding: const EdgeInsets.only(bottom: 8.0),
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const Text('• ', style: TextStyle(fontSize: 16)),
                Expanded(
                  child: Text(
                    item,
                    style: Theme.of(context).textTheme.bodyLarge,
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}
