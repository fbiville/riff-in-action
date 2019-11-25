package io.projectriff.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class App {

    @Bean
    public Function<Person, String> greet() {
        return p -> String.format("Hello %s", p.getFirstName());
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

class Person {
    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}