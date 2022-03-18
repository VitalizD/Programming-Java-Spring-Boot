package com.example.trainingproject;

import com.example.trainingproject.config.SpringConfig;
import com.example.trainingproject.config.TestConfig;
import com.example.trainingproject.geometry.Circle;
import com.example.trainingproject.geometry.Rectangle;
import com.example.trainingproject.geometry.Square;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(TestConfig.class)
public class TrainingProjectApplication {

    private static TestConfig testConfig;

    public TrainingProjectApplication(TestConfig testConfig) {
        TrainingProjectApplication.testConfig = testConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrainingProjectApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println("Application name: " + testConfig.getApplicationName());
        System.out.println("Environment variable (profile): " + testConfig.getEnvironmentVariable());

        System.out.print("List: ");
        for (var el: testConfig.getLi()) {
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.println();

        try { System.out.println(context.getBean(Circle.class).info() + "This bin exists because the current profile is a test."); }
        catch (Exception e) { System.out.println("The circle doesn't exist, because the current profile isn't a test."); }

        try { System.out.println(context.getBean(Rectangle.class).info() + "This bin exists because the circle exists."); }
        catch (Exception e) { System.out.println("The rectangle doesn't exist because the circle doesn't exist."); }

         try { System.out.println(context.getBean(Square.class).info() + "This bin exists because the value of the \"environment-variable\" config isn't default."); }
         catch (Exception e) { System.out.println("The square doesn't exist because the value of the \"environment-variable\" config is default."); }
    }

}
