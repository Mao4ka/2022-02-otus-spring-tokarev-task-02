package ru.otus.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void parseLineTestByCommaSeparator() {
        String parsedLine = "12,123,qwerty,qqq";
        List<String> parsedValues = StringUtils.parseLine(parsedLine, ",");

        assertThat(4).isEqualTo(parsedValues.size());
    }

    @Test
    void parseLineTestBySemicolonSeparator() {
        String parsedLine = "13;qwerty,qqq;123; 4, ;,,";
        List<String> parsedValues = StringUtils.parseLine(parsedLine, ";");

        assertThat(5).isEqualTo(parsedValues.size());
        assertThat(" 4, ").isEqualTo(parsedValues.get(3));
    }
}