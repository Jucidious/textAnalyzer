package com.jucya.textAnalyzer.core.component.analyzer.bracketAnalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jucya.textAnalyzer.core.shared.data.BracketAnalyzerData;
import com.jucya.textAnalyzer.core.usecase.TextAnalyzer;

/**
 * Предоставляет реализацию проверки корректности расстановки скобок в тексте.
 *
 * @since 0.1
 */
class BracketAnalyzer implements TextAnalyzer {

    @Override
    public BracketAnalyzerData executeAnalyzeBrackets(String analyzerText) {
        boolean correctBracket = checkBrackets(analyzerText);
        return new BracketAnalyzerData(correctBracket);
    }

    /**
     * Проверка скобок.
     *
     * @param text текст для проверки
     *
     * @return результат проверки
     */
    private boolean checkBrackets(String text) {
        return searchEmptyBrackets(text) && searchSingleBracket(text);
    }

    /**
     * Поиск скобок, не имеющих пару.
     *
     * <p>Например, одна открывающая или одна закрывающая.
     *
     * @param text текст для поиска
     *
     * @return результат поиска, если найдено отклонение, то false
     */
    private boolean searchSingleBracket(String text) {
        int bracketCount = 0;

        for (char c : text.toCharArray()) {
            if (c == '(') {
                bracketCount++;
            } else if (c == ')') {
                if (bracketCount == 0) {
                    return false;
                }
                bracketCount--;
            }
        }

        return bracketCount == 0;
    }

    /**
     * Поиск пустых скобок, не содержащих в себе текста.
     *
     * @param text текст для поиска
     *
     * @return результат поиска, если найдено отклонение, то false
     */
    private boolean searchEmptyBrackets(String text) {
        Pattern pattern = Pattern.compile("\\([^()]*\\)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group();
            String content = match.substring(1, match.length() - 1).trim();
            if (content.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
