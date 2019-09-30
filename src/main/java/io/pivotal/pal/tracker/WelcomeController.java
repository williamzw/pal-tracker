package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String a_welcome_message;

    public WelcomeController(
            @Value("${WELCOME_MESSAGE}") String a_welcome_message) {
        this.a_welcome_message = a_welcome_message;
    }

//    public WelcomeController(){
//        message = welcome.message;
//    }

    @GetMapping("/")
    public String sayHello() {
        return a_welcome_message;
    }
}