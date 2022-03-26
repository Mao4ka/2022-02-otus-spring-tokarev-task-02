package ru.otus.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.enterprise.IOQuestionnaireImpl;
import ru.otus.service.QuestionnaireService;


@Service
@RequiredArgsConstructor
public class Application {


    private final QuestionnaireService questionnaireService;
    private final IOQuestionnaireImpl ioQuestionnaireImpl;

    public void studentSurvey() {

        String studentName = ioQuestionnaireImpl.greeting();

        int rightAnswersCount = questionnaireService.processQuestionnaire();

        ioQuestionnaireImpl.printOutputMessage(studentName, rightAnswersCount);

    }

}
