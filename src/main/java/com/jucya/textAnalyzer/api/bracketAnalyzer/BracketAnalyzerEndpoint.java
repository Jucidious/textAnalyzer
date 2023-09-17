package com.jucya.textAnalyzer.api.bracketAnalyzer;

import com.jucya.textAnalyzer.core.shared.data.BracketAnalyzerData;
import com.jucya.textAnalyzer.core.usecase.TextAnalyzer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для проверки скобок в тексте.
 *
 * @since 0.1
 */
@RestController
@RequestMapping("/api")
public class BracketAnalyzerEndpoint {

    private final TextAnalyzer textAnalyzer;

    BracketAnalyzerEndpoint(TextAnalyzer textAnalyzer) {
        this.textAnalyzer = textAnalyzer;
    }

    /**
     * Проверка корректной расстановки скобок в тексте.
     *
     * @param request текст для проверки
     *
     * @return результат проверки корректности использования скобок
     */
    @Operation(summary = "Проверка расстановки скобок в тексте.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Результат проверки расстановки скобок",
                     content = {@Content(mediaType = "application/json",
                                         schema = @Schema(implementation = BracketAnalyzerResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Ошибка. Значение не должно быть пустым.",
                     content = @Content(mediaType = "application/json"))})
    @PostMapping(
        value = "/checkBrackets",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BracketAnalyzerResponse checkBracketsAnalyzer(@RequestBody @Validated TextBracketAnalyzerRequest request) {
        String analyzedText = request.getText();
        BracketAnalyzerData result = textAnalyzer.executeAnalyzeBrackets(analyzedText);
        return new BracketAnalyzerResponse(result.isCorrectBracket());
    }
}
