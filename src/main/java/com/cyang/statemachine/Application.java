package com.cyang.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        final SpringApplication application = new SpringApplication(Application.class);
        ConfigurableApplicationContext context = application.run(args);
        StateMachine<String, String> stateMachine = context.getBean("uml-state-machine", StateMachine.class);
        stateMachine.start();
        stateMachine.sendEvent(buildEventMessage());
        assert stateMachine.getState().getId().equals("S2");
    }

    private static Message<String> buildEventMessage() {
        return MessageBuilder.withPayload("E1").build();
    }
}
