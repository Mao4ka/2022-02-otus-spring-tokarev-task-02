package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.entity.Quest;
import ru.otus.dao.repository.QuestRepository;
import ru.otus.enterprise.InputQuestionnaire;
import ru.otus.enterprise.OutputQuestionnaire;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestRepository questRepository;

    private final OutputQuestionnaire outputQuestionnaire;
    private final InputQuestionnaire inputQuestionnaire;

    @Override
    public int processQuestionnaire() {
        List<Quest> questionnaire = questRepository.getQuestionnaire();

        return questionnaire.stream().mapToInt(this::processQuest).sum();
    }

    private int processQuest(Quest quest) {
        outputQuestionnaire.printQuestionnaire(quest);

        System.out.print("Your choice:");

        String userData = inputQuestionnaire.getUserInput();

        if (checkCorrect(userData)) {
            boolean userAnswerIsRight = checkUserAnswer(userData, quest);
            return userAnswerIsRight ? 1 : 0;
        } else {
            outputQuestionnaire.outputString("Reed manual! And input CORRECT OPTION NUMBER!!!\n" +
                    "This answer is not accepted!" +
                    " (aside) Stupid student...\n");
            return 0;
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
