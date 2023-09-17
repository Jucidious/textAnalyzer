package com.jucya.textAnalyzer.core.component.analyzer.bracketAnalyzer;

import com.jucya.textAnalyzer.core.usecase.TextAnalyzer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация компонентов для анализа корректности скобок.
 *
 * @since 0.1
 */
@Configuration
public class BracketAnalyzerConfig {

    @Bean
    public TextAnalyzer textAnalyzer() {
        return new BracketAnalyzer();
    }
}
