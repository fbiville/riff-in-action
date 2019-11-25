package io.projectriff.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Function;

@SpringBootApplication
public class App {

    @Bean
    public Function<Flux<Person>, Flux<String>> count() {
        return ps -> ps.take(Duration.ofSeconds(15))
                .groupBy(Person::getLastName)
                .flatMap(g -> g.count().map(c -> String.format("%s: %d", g.key(), c)));
    }

    public static void main(String[] args) throws InterruptedException {
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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}