package ru.otus.repository;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.dao.entity.Quest;
import ru.otus.dao.repository.QuestRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В репозитории")
class QuestRepositoryTest {

    private static final String RESOURCE_FILE_NAME = "testQuestionnaire.csv";
    private static final String LINE_SEPARATOR = ",";

    private final QuestRepository questRepository = new QuestRepository();

    @DisplayName("данный метод должен корректно считывать данные из файла")
    @Test
    public void testGetQuestionnaire() {
        List<Quest> quests = questRepository.getQuestionnaire(RESOURCE_FILE_NAME, LINE_SEPARATOR);

        assertThat(3).isEqualTo(quests.size());
        assertThat("quest01").isEqualTo(quests.get(0).getQuestion());
        assertThat("answer02_04").isEqualTo(quests.get(1).getAnswers().get(3));
        assertThat("4").isEqualTo(quests.get(2).getRightAnswer());
    }

}