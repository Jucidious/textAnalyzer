package com.jucya.textAnalyzer.api.bracketAnalyzer;

import com.jucya.textAnalyzer.core.shared.data.BracketAnalyzerData;
import com.jucya.textAnalyzer.core.usecase.TextAnalyzer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Набор тестов для {@link com.jucya.textAnalyzer.api.bracketAnalyzer.BracketAnalyzerEndpoint}.
 *
 * @since 0.1
 */
@DisplayName("BracketAnalyzerEndpoint")
@WebMvcTest(controllers = BracketAnalyzerEndpoint.class)
@ImportAutoConfiguration(ProjectInfoAutoConfiguration.class)
class BracketAnalyzerEndpointTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TextAnalyzer textAnalyzer;

    @Test
    @DisplayName("violates a blank request")
    void testValidationWhenRequestIsEmpty() throws Exception {
        //given
        var result = new BracketAnalyzerData(true);

        //when
        Mockito.when(textAnalyzer.executeAnalyzeBrackets(Mockito.any())).thenReturn(result);
        var response = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/checkBrackets").contentType(MediaType.APPLICATION_JSON)
                                  .content("{\n }"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("{\"errorMessage\":"
                                                                  + "\"Ошибка. Значение не должно быть пустым.\"}"));
    }

    @Test
    @DisplayName("Test when correct request and result execute \"true\"")
    void testValidationWhenRequestCorrectAndResultTrue() throws Exception {
        //given
        var result = new BracketAnalyzerData(true);

        //when
        Mockito.when(textAnalyzer.executeAnalyzeBrackets(Mockito.any())).thenReturn(result);
        var response = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/checkBrackets").contentType(MediaType.APPLICATION_JSON)
                                  .content("{\n \"text\": \"Тут скобки стоят правильно(наверное).\"\n }"));

        //then
        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string("{\"isCorrect\":true}"));
    }

    @Test
    @DisplayName("Test when correct request and result execute \"false\"")
    void testValidationWhenRequestCorrectAndResultFalse() throws Exception {
        //given
        var result = new BracketAnalyzerData(false);

        //when
        Mockito.when(textAnalyzer.executeAnalyzeBrackets(Mockito.any())).thenReturn(result);
        var response = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/checkBrackets").contentType(MediaType.APPLICATION_JSON)
                                  .content("{\n \"text\": \"Тут скобки стоят неверно(((.\"\n }"));

        //then
        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string("{\"isCorrect\":false}"));
    }
}
