package ru.otus.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> parseLine(String stringLine, String lineSeparator) {
        return new ArrayList<>(Arrays.asList(stringLine.split(lineSeparator)));
    }

}
