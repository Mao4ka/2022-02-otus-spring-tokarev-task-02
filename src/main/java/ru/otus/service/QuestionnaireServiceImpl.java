package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.AnswerType;
import ru.otus.dao.entity.Quest;
import ru.otus.dao.repository.QuestRepository;
import ru.otus.enterprise.InputQuestionnaire;
import ru.otus.enterprise.OutputQuestionnaire;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestRepository questRepository;
    private final OutputQuestionnaire outputQuestionnaire;
    private final InputQuestionnaire inputQuestionnaire;
    private final IntermediateMessageService intermediateMessageService;

    @Override
    public int processQuestionnaire() {
        List<Quest> questionnaire = questRepository.getQuestionnaire();

        AtomicInteger rightAnswerCount = new AtomicInteger();

        questionnaire.forEach(quest -> {
            outputQuestionnaire.printQuestionnaire(quest);
            outputQuestionnaire.outputString("Your choice:");

            String userData = inputQuestionnaire.getUserInput();

            AnswerType answerType = processQuestAnswer(quest, userData);
            intermediateMessageService.commentUserAnswer(answerType);
            rightAnswerCount.addAndGet(answerType.equals(AnswerType.correctAnswer) ? 1 : 0);
        });

        return rightAnswerCount.get();
    }

    private AnswerType processQuestAnswer(Quest quest, String userData) {
        if (checkCorrect(userData)) {
            boolean userAnswerIsRight = checkUserAnswer(userData, quest);
            return userAnswerIsRight ? AnswerType.correctAnswer : AnswerType.incorrectAnswer;
        } else {
            return AnswerType.incorrectInputData;
        }
    }

    private boolean checkUserAnswer(String userData, Quest quest) {
        return userData.equals(quest.getRightAnswer());
    }

    private boolean checkCorrect(String userData) {
        try {
            int intValue = Integer.parseInt(userData);
            return intValue >= 1 && intValue <= 4;
        } catch (Exception e) {
            return false;
        }
    }
}
