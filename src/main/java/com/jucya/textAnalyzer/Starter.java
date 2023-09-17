package com.jucya.textAnalyzer;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Запускает {@code TextAnalyzer} приложение.
 *
 * @since 0.1
 */
@SpringBootApplication
public class Starter {

    /**
     * Входная точка в сервисы анализа текста.
     *
     * @param args внешние параметры приложения.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(Starter.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
    }
}
