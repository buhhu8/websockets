package ru.buhhu8.sockets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
@Slf4j
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
        try {
            throw new RuntimeException("Ошибка всего");
        }
        catch (RuntimeException exc){
            var er = Error.mapTo(exc.getMessage());
            if(!Objects.equals(er,null)) {
                System.out.println(er);
                System.out.println(er.getValue());
            }
            else {
                System.out.println("else");
            }
        }
    }

}
