package com.cyang.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.model.StateMachineModelFactory;
import org.springframework.statemachine.uml.UmlStateMachineModelFactory;

@Configuration
@EnableStateMachine(name = "uml-state-machine")
public class UmlStateMachine extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineModelConfigurer<String, String> model) throws Exception {
        model
                .withModel()
                .factory(modelFactoryWithEffect());
    }

    @Bean
    public StateMachineModelFactory<String, String> modelFactoryWithEffect() {
        // return new UmlStateMachineModelFactory("classpath:with-effect.uml");
        return new UmlStateMachineModelFactory("classpath:without-effect.uml");
        // return new UmlStateMachineModelFactory("classpath:with-effect-bean.uml");
    }

    @Bean(name="effectaction")
    public Action<String, String> effectAction() {
        return context -> {
            System.out.println("Spring bean works in effect in UML");
        };
    }
}
