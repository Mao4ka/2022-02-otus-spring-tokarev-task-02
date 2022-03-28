package ru.otus.service;

import ru.otus.AnswerType;
import ru.otus.dao.entity.Quest;

public interface QuestionnaireService {
    AnswerType getAnswerType(Quest quest, String userData);
}
