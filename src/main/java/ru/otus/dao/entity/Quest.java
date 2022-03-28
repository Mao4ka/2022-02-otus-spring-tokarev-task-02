package ru.otus.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Quest {
    private final String question;
    private final List<String> answers;
    private final String rightAnswer;
}
