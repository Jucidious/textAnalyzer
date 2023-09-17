package com.jucya.textAnalyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.info.GitProperties;

/**
 * Запускает {@code TextAnalyzer} приложение.
 *
 * @since 0.1
 */
@SpringBootApplication
public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);
    private static final String BUILD_VERSION_KEY = "build.version";

    public Starter(GitProperties gitProperties) {
        printBuildInfo(gitProperties);
    }

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

    private void printBuildInfo(GitProperties gitProperties) {
        LOGGER.info(
            "Running TextAnalyzer App version {} commit {} build on {} at {}",
            gitProperties.get(BUILD_VERSION_KEY),
            gitProperties.getShortCommitId(),
            gitProperties.getBranch(),
            gitProperties.getCommitTime()
        );
    }
}
