import 'package:flutter/material.dart';
import 'dart:math' as math;
import '../models/flashcard.dart';

/// Widget reutilizável que implementa um flashcard animado com efeito de flip.
///
/// FUNCIONALIDADE ESTRELA: Este é o componente mais importante do aplicativo.
/// Permite ao usuário interagir com cartões que giram 180° para revelar tradução.
///
/// TÉCNICA: Usa AnimationController e Transform para criar rotação 3D suave.
/// O estado (frente/verso) é gerenciado internamente (StatefulWidget).
///
/// USO:
/// ```dart
/// FlashcardWidget(
///   flashcard: Flashcard(
///     frontText: 'Hello',
///     backText: 'Olá',
///   ),
/// )
/// ```
class FlashcardWidget extends StatefulWidget {
  /// Dados do flashcard (frente e verso)
  final Flashcard flashcard;

  /// Largura do cartão (responsivo)
  final double? width;

  /// Altura do cartão (responsivo)
  final double? height;

  /// Callback opcional quando o cartão é clicado
  final VoidCallback? onTap;

  const FlashcardWidget({
    super.key,
    required this.flashcard,
    this.width,
    this.height,
    this.onTap,
  });

  @override
  State<FlashcardWidget> createState() => _FlashcardWidgetState();
}

class _FlashcardWidgetState extends State<FlashcardWidget>
    with SingleTickerProviderStateMixin {
  /// Controller responsável pela animação de rotação
  late AnimationController _animationController;

  /// Animação que vai de 0.0 a 1.0 representando a rotação
  late Animation<double> _animation;

  /// Estado atual: true = frente, false = verso
  bool _showFront = true;

  @override
  void initState() {
    super.initState();

    // Inicializa o controller com duração de 600ms para rotação suave
    _animationController = AnimationController(
      duration: const Duration(milliseconds: 600),
      vsync: this, // 'this' fornece o TickerProvider
    );

    // Cria uma animação com curva ease-in-out para movimento natural
    _animation = CurvedAnimation(
      parent: _animationController,
      curve: Curves.easeInOut,
    );
  }

  @override
  void dispose() {
    // IMPORTANTE: Sempre dispose dos controllers para evitar memory leaks
    _animationController.dispose();
    super.dispose();
  }

  /// Método que executa o flip do cartão
  void _flipCard() {
    if (_showFront) {
      // Animar de frente para verso
      _animationController.forward();
    } else {
      // Animar de verso para frente
      _animationController.reverse();
    }

    // Atualiza o estado
    setState(() {
      _showFront = !_showFront;
    });

    // Executa callback se fornecido
    widget.onTap?.call();
  }

  @override
  Widget build(BuildContext context) {
    // Obtém dimensões responsivas
    final screenWidth = MediaQuery.of(context).size.width;
    final cardWidth = widget.width ?? screenWidth * 0.85;
    final cardHeight = widget.height ?? 200.0;

    return GestureDetector(
      onTap: _flipCard,
      child: AnimatedBuilder(
        animation: _animation,
        builder: (context, child) {
          // Calcula o ângulo de rotação (0 a π radianos = 0 a 180 graus)
          final angle = _animation.value * math.pi;

          // Determina se devemos mostrar a frente ou o verso
          // Após 90° (π/2), começamos a mostrar o verso
          final showFront = angle < math.pi / 2;

          return Transform(
            // Define o ponto de pivô no centro do cartão
            alignment: Alignment.center,

            // TÉCNICA CHAVE: Matrix4 para criar rotação 3D no eixo Y
            transform: Matrix4.identity()
              ..setEntry(3, 2, 0.001) // Adiciona perspectiva 3D
              ..rotateY(angle), // Rotação no eixo Y

            child: showFront
                ? _buildCardFace(
                    text: widget.flashcard.frontText,
                    backgroundColor: Theme.of(context).colorScheme.primary,
                    width: cardWidth,
                    height: cardHeight,
                    isFront: true,
                  )
                : Transform(
                    // Espelha o verso horizontalmente para corrigir a inversão
                    alignment: Alignment.center,
                    transform: Matrix4.identity()..rotateY(math.pi),
                    child: _buildCardFace(
                      text: widget.flashcard.backText,
                      backgroundColor: Theme.of(context).colorScheme.secondary,
                      width: cardWidth,
                      height: cardHeight,
                      isFront: false,
                    ),
                  ),
          );
        },
      ),
    );
  }

  /// Constrói uma face do cartão (frente ou verso)
  Widget _buildCardFace({
    required String text,
    required Color backgroundColor,
    required double width,
    required double height,
    required bool isFront,
  }) {
    return Container(
      width: width,
      height: height,
      decoration: BoxDecoration(
        color: backgroundColor,
        borderRadius: BorderRadius.circular(16),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.2),
            blurRadius: 10,
            offset: const Offset(0, 4),
          ),
        ],
      ),
      child: Stack(
        children: [
          // Conteúdo principal (texto)
          Center(
            child: Padding(
              padding: const EdgeInsets.all(24.0),
              child: Text(
                text,
                style: const TextStyle(
                  fontSize: 28,
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                ),
                textAlign: TextAlign.center,
              ),
            ),
          ),

          // Indicador visual de qual lado está sendo mostrado
          Positioned(
            top: 12,
            right: 12,
            child: Container(
              padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
              decoration: BoxDecoration(
                color: Colors.white.withOpacity(0.3),
                borderRadius: BorderRadius.circular(12),
              ),
              child: Text(
                isFront ? 'EN' : 'PT',
                style: const TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                  fontSize: 12,
                ),
              ),
            ),
          ),

          // Ícone de instrução (apenas na frente)
          if (isFront)
            Positioned(
              bottom: 12,
              right: 12,
              child: Icon(
                Icons.touch_app,
                color: Colors.white.withOpacity(0.6),
                size: 24,
              ),
            ),
        ],
      ),
    );
  }
}
