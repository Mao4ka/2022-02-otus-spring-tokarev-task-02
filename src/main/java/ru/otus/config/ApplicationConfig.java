package ru.otus.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Configuration
@Getter
public class ApplicationConfig {

    @Value("${resource.file-name}")
    private String fileName;

    @Value("${resource.line-separator}")
    private String lineSeparator;

    @Value("${check.minimum-acceptable-correct-answers-count}")
    private int minimumAcceptableCorrectCount;
}
