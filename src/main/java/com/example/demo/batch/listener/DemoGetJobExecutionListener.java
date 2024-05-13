package com.example.demo.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoGetJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("I am before Job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("I am after Job");
    }

}
