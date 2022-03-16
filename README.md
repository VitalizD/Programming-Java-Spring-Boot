# Задание:
Изучить параметры которые предоставляет аннотация @SpringBootApplication

# @SpringBootApplication
Автоматическая конфигурация существенно облегчает жизнь разработчика. Для запуска и конфигурирования приложения на Spring Boot используется аннотация @SpringBootApplication.
Составляющие аннотации @SpringBootApplication:
* @Configuration - помечает класс как конфигурационный;
* @ComponentScan - включает сканирование компонентов, то есть классы-контроллеры и другие компоненты, которые мы создаём, будут автоматически зарегистрированы как бины;
* @EnableAutoConfiguration - запускает механизм автоматической конфигурации Spring Boot.

Использование аннотации @SpringBootApplication эквивалентно использованию трёх аннотаций @Configuration @ComponentScan @EnableAutoConfiguration.

Использование каждой из составляющей необязательно, но также можно заменить аннотацию @SpringBootApplication на любые из трёх составляющих, которые она в себя включает. Например, если мы не хотим использовать автоматическое сканирование компонентов, то мы можем явно импортировать бины, а @Component-аннотированные классы и @ConfigurationProperties-аннотированные классы сканироваться не будут:
```jar
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Import({ MyConfig.class, MyAnotherConfig.class })
public class Application {
    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }
}
```

# Параметры @SpringBootApplication
* exclude (Class<...>[]) - исключает заданный список классов из автоматической конфигурации;
* excludeNames (String[]) - исключает список классов, заданных именами, из автоматической конфигурации;
* scanBasePackageClasses(Class<...>[]) - список классов, которые должны сканироваться @ComponentScan (типобезопасная альтернатива scanBasePackages);
* scanBasePackages(String[]) - список имён пакетов, которые должны сканироваться @ComponentScan;
* nameGenerator(Class<... extends BeanNameGenerator>) - класс, наследуемый от BeanNameGenerator, который будет использоваться для именования обнаруженных компонентов в Spring Container;
* proxyBeanMethods(bool) - указывает, следует ли проксировать @Bean-методы, чтобы обеспечить поведение жизненного цикла компонента, например, чтобы вернуть общие экземпляры singleton-компонента даже в случае прямого вызова метода в пользовательском коде.
