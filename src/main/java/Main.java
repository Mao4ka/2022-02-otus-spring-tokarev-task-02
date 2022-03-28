import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.application.Application;

import java.io.File;
import java.net.URL;

@ComponentScan(basePackages = "ru.otus")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Application application = context.getBean(Application.class);
        application.studentSurvey();
    }

}

