package ru.otus.enterprise;

import ru.otus.dao.entity.Quest;

public interface OutputQuestionnaire {

    String greeting();

    void printQuestionnaire(Quest quest);

    void outputString(String s);

    void printOutputMessage(String studentName, int rightAnswersCount);
}
