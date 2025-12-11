import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';

class ProgressService {
  static const String _progressKey = 'module_progress';
  static const String _completedModulesKey = 'completed_modules';

  // Save module score
  static Future<void> saveModuleScore(
    String moduleId,
    int score,
    int totalQuestions,
  ) async {
    final prefs = await SharedPreferences.getInstance();

    // Calculate percentage
    final percentage = (score / totalQuestions * 100).round();

    // Get existing progress
    final progressJson = prefs.getString(_progressKey) ?? '{}';
    final Map<String, dynamic> progress = json.decode(progressJson);

    // Update or add module progress
    progress[moduleId] = {
      'score': score,
      'totalQuestions': totalQuestions,
      'percentage': percentage,
      'lastAttempt': DateTime.now().toIso8601String(),
      'attempts': (progress[moduleId]?['attempts'] ?? 0) + 1,
      'bestScore': progress[moduleId]?['bestScore'] != null
          ? (percentage > progress[moduleId]!['bestScore']
                ? percentage
                : progress[moduleId]!['bestScore'])
          : percentage,
    };

    // Save updated progress
    await prefs.setString(_progressKey, json.encode(progress));

    // If score >= 70%, mark as completed
    if (percentage >= 70) {
      await _markModuleCompleted(moduleId);
    }
  }

  // Mark module as completed
  static Future<void> _markModuleCompleted(String moduleId) async {
    final prefs = await SharedPreferences.getInstance();
    final completedList = prefs.getStringList(_completedModulesKey) ?? [];

    if (!completedList.contains(moduleId)) {
      completedList.add(moduleId);
      await prefs.setStringList(_completedModulesKey, completedList);
    }
  }

  // Get module progress
  static Future<ModuleProgress?> getModuleProgress(String moduleId) async {
    final prefs = await SharedPreferences.getInstance();
    final progressJson = prefs.getString(_progressKey) ?? '{}';
    final Map<String, dynamic> progress = json.decode(progressJson);

    if (progress.containsKey(moduleId)) {
      return ModuleProgress.fromJson(progress[moduleId]);
    }
    return null;
  }

  // Check if module is unlocked
  static Future<bool> isModuleUnlocked(
    int moduleIndex,
    List<String> allModuleIds,
  ) async {
    // First module is always unlocked
    if (moduleIndex == 0) return true;

    // Check if previous module has >= 70%
    final previousModuleId = allModuleIds[moduleIndex - 1];
    final progress = await getModuleProgress(previousModuleId);

    if (progress == null) return false;
    return progress.percentage >= 70;
  }

  // Get all completed modules
  static Future<List<String>> getCompletedModules() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getStringList(_completedModulesKey) ?? [];
  }

  // Get all progress
  static Future<Map<String, ModuleProgress>> getAllProgress() async {
    final prefs = await SharedPreferences.getInstance();
    final progressJson = prefs.getString(_progressKey) ?? '{}';
    final Map<String, dynamic> progressMap = json.decode(progressJson);

    final Map<String, ModuleProgress> result = {};
    progressMap.forEach((key, value) {
      result[key] = ModuleProgress.fromJson(value);
    });

    return result;
  }

  // Reset all progress (for testing or reset feature)
  static Future<void> resetAllProgress() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove(_progressKey);
    await prefs.remove(_completedModulesKey);
  }

  // Reset specific module progress
  static Future<void> resetModuleProgress(String moduleId) async {
    final prefs = await SharedPreferences.getInstance();
    final progressJson = prefs.getString(_progressKey) ?? '{}';
    final Map<String, dynamic> progress = json.decode(progressJson);

    progress.remove(moduleId);
    await prefs.setString(_progressKey, json.encode(progress));

    final completedList = prefs.getStringList(_completedModulesKey) ?? [];
    completedList.remove(moduleId);
    await prefs.setStringList(_completedModulesKey, completedList);
  }
}

// Model for module progress
class ModuleProgress {
  final int score;
  final int totalQuestions;
  final int percentage;
  final DateTime lastAttempt;
  final int attempts;
  final int bestScore;

  ModuleProgress({
    required this.score,
    required this.totalQuestions,
    required this.percentage,
    required this.lastAttempt,
    required this.attempts,
    required this.bestScore,
  });

  factory ModuleProgress.fromJson(Map<String, dynamic> json) {
    return ModuleProgress(
      score: json['score'] as int,
      totalQuestions: json['totalQuestions'] as int,
      percentage: json['percentage'] as int,
      lastAttempt: DateTime.parse(json['lastAttempt'] as String),
      attempts: json['attempts'] as int,
      bestScore: json['bestScore'] as int,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'score': score,
      'totalQuestions': totalQuestions,
      'percentage': percentage,
      'lastAttempt': lastAttempt.toIso8601String(),
      'attempts': attempts,
      'bestScore': bestScore,
    };
  }

  bool get isPassed => percentage >= 70;
}
