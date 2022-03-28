package ru.otus.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.entity.Quest;
import ru.otus.enterprise.IOQuestionnaireImpl;
import ru.otus.enterprise.InputQuestionnaire;
import ru.otus.enterprise.OutputQuestionnaire;
import ru.otus.service.QuestionnaireService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class Application {


    private final QuestionnaireService questionnaireService;
    private final OutputQuestionnaire outputQuestionnaire;

    public void studentSurvey() {

        String studentName = outputQuestionnaire.greeting();

        int rightAnswersCount = questionnaireService.processQuestionnaire();

        outputQuestionnaire.printOutputMessage(studentName, rightAnswersCount);

    }

}
