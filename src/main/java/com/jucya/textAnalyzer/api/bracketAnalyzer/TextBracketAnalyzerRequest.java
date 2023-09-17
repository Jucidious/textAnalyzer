package com.jucya.textAnalyzer.api.bracketAnalyzer;


import jakarta.validation.constraints.NotBlank;

/**
 * Описывает объект с текстом, который необходимо проверить на скобки.
 *
 * @since 0.1
 */
class TextBracketAnalyzerRequest {

    @NotBlank(message = "Значение не должно быть пустым")
    private String text;

    private TextBracketAnalyzerRequest() {
    }

    TextBracketAnalyzerRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
