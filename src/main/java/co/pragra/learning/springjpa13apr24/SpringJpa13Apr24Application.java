package co.pragra.learning.springjpa13apr24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringJpa13Apr24Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpa13Apr24Application.class, args);
    }

}
