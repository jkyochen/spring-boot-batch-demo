package com.example.demo.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class Step1Config {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private Step1Tasklet step1Tasklet;

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .tasklet(step1Tasklet, transactionManager)
                .build();
    }

}
