package ru.otus.repository;


import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.dao.entity.Quest;
import ru.otus.dao.repository.QuestRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * я завтра тесты добавлю сейчас просто нет времени
 */
@DisplayName("Ыть!")
class QuestRepositoryTest {

    //@Autowired
    private final QuestRepository questRepository = new QuestRepository();

    @IgnoreForBinding
    @DisplayName("и еще раз Ыть!")
    @Test
    public void testGetQuestionnaire() {

        List<Quest> quest = questRepository.getQuestionnaire();

        assertThat(5).isEqualTo(quest.size());
    }

}