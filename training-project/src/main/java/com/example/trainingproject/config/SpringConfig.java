package com.example.trainingproject.config;

import com.example.trainingproject.geometry.Circle;
import com.example.trainingproject.geometry.Rectangle;
import com.example.trainingproject.geometry.Square;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Configuration
public class SpringConfig {

    @Bean
    @Profile("test")
    public Circle getCircle() {
        return new Circle();
    }

    @Bean
    @ConditionalOnBean(Circle.class)
    public Rectangle getRectangle() {
        return new Rectangle();
    }

    @Bean
    @ConditionalOnExpression("'${some.test.environment-variable}' != 'default'")
    public Square getSquare() {
        return new Square();
    }

}
