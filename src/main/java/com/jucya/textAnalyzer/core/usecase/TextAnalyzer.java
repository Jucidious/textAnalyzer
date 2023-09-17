package com.jucya.textAnalyzer.core.usecase;

import com.jucya.textAnalyzer.core.shared.data.BracketAnalyzerData;

/**
 * Интерфейс описывающий варианты анализа текста.
 *
 * @since 0.1
 */
public interface TextAnalyzer {

    /**
     * Анализирует текст на корректность расстоновки скобок.
     *
     * @param analyzerText текст для анализа
     *
     * @return результат анализа текста
     */
    BracketAnalyzerData executeAnalyzeBrackets(String analyzerText);
}
