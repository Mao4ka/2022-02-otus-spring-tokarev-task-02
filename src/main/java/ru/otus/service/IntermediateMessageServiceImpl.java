package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.AnswerType;
import ru.otus.enterprise.OutputQuestionnaire;

@Service
@RequiredArgsConstructor
public class IntermediateMessageServiceImpl implements IntermediateMessageService {

    private final OutputQuestionnaire outputQuestionnaire;

    @Override
    public void commentUserAnswer(AnswerType answerType) {
        if (answerType.equals(AnswerType.correctAnswer)) {
            outputQuestionnaire.outputString("To my great surprise, you were not mistaken. Strange...\n");
        }

        if (answerType.equals(AnswerType.incorrectAnswer)) {
            outputQuestionnaire.outputString("You're wrong! And I knew it!\n");
        }

        if (answerType.equals(AnswerType.incorrectInputData)) {
            outputQuestionnaire.outputString("Reed manual! And input CORRECT OPTION NUMBER!!!\n" +
                    "This answer is not accepted!\n" +
                    "(aside) Oh, these stupid students...\n");
        }
    }

}
