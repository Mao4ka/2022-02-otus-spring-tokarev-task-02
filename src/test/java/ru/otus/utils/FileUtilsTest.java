package ru.otus.utils;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    private static final String RESOURCE_FILE_NAME = "testQuestionnaire.csv";
    private static final String LINE_SEPARATOR = ",";

    @SneakyThrows
    @Test
    void getCsvTest() {
        Map<Integer, List<String>> fileMap = FileUtils.getCsv(RESOURCE_FILE_NAME, LINE_SEPARATOR);

        assertThat(4).isEqualTo(fileMap.size());
    }

    @SneakyThrows
    @Test
    void getCsvWithTitleTest() {
        Map<Integer, List<String>> fileMap = FileUtils.getCsvWithTitle(RESOURCE_FILE_NAME, LINE_SEPARATOR);

        assertThat(3).isEqualTo(fileMap.size());
    }
}