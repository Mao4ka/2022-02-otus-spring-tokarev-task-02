package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.AnswerType;
import ru.otus.dao.entity.Quest;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Override
    public AnswerType getAnswerType(Quest quest, String userData) {
        if (checkCorrectInputData(userData)) {
            boolean userAnswerIsRight = checkUserAnswer(userData, quest);
            return userAnswerIsRight ? AnswerType.correctAnswer : AnswerType.incorrectAnswer;
        } else {
            return AnswerType.incorrectInputData;
        }
    }

    private boolean checkUserAnswer(String userData, Quest quest) {
        return userData.equals(quest.getRightAnswer());
    }

    private boolean checkCorrectInputData(String userData) {
        try {
            int intValue = Integer.parseInt(userData);
            return intValue >= 1 && intValue <= 4;
        } catch (Exception e) {
            return false;
        }
    }
}
