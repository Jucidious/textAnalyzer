package com.jucya.textAnalyzer.core.component.analyzer.bracketAnalyzer;

import com.jucya.textAnalyzer.core.usecase.TextAnalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Набор тестов для {@link com.jucya.textAnalyzer.core.component.analyzer.bracketAnalyzer.BracketAnalyzer}.
 *
 * @since 0.1
 */
@DisplayName("BracketAnalyzer")
class BracketAnalyzerTest {

    private TextAnalyzer bracketAnalyzer;

    @BeforeEach
    void setUp() {
        bracketAnalyzer = new BracketAnalyzer();
    }

    @Test
    @DisplayName("When text with correct brackets.")
    void testWhenTextIsCorrect() {
        //given
        var correctText = "Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями."
                          + " Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия)."
                          + " В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели."
                          + " Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками,"
                          + " (как будто природа готовила нам небольшой сюрприз). Несмотря на это,"
                          + " виды были захватывающими, особенно когда мы достигли высшей точки и увидели прекрасный"
                          + " вид на долину (я почувствовал, что все усилия стоили того).";

        //when
        var result = bracketAnalyzer.executeAnalyzeBrackets(correctText);

        //then
        Assertions.assertTrue(result.isCorrectBracket());
    }

    @Test
    @DisplayName("When text with invalid brackets (without bracket a pair).")
    void testWhenInvalidTextWithoutBracketPair() {
        //given
        var correctText = "Тут находится текст с неправильными скобками :(";

        //when
        var result = bracketAnalyzer.executeAnalyzeBrackets(correctText);

        //then
        Assertions.assertFalse(result.isCorrectBracket());
    }

    @Test
    @DisplayName("When text with invalid brackets (no text between the brackets).")
    void testWhenInvalidTextBracketsEmpty() {
        //given
        var correctText = "Тут находится текст () с пустыми скобками.";

        //when
        var result = bracketAnalyzer.executeAnalyzeBrackets(correctText);

        //then
        Assertions.assertFalse(result.isCorrectBracket());
    }

    @Test
    @DisplayName("When text with invalid brackets (many whitespaces between the brackets).")
    void testWhenInvalidTextBracketsContainsWhitespace() {
        //given
        var correctText = "Тут находится текст (       ) с кучей пробелов в скобках.";

        //when
        var result = bracketAnalyzer.executeAnalyzeBrackets(correctText);

        //then
        Assertions.assertFalse(result.isCorrectBracket());
    }
}
