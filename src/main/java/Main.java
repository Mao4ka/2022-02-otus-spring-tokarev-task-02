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

        URL resource = getRes("questionnaire.csv");

        assert resource != null;
        File file = new File(resource.getFile());
        System.out.println("qq");
    }

    private static URL getRes(String fileName) {
        return Main.class.getClassLoader().getResource(fileName);
    }

}

