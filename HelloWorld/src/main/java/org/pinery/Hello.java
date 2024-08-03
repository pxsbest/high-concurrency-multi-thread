package org.pinery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ${USER}
 * @DateTime ${DATE} ${TIME}
 * @Description
 **/
@SpringBootApplication
public class Hello {
    public static void main(String[] args) {
        SpringApplication.run(Hello.class, args);
    }

    public static String say() {
        return "hello ";
    }
}