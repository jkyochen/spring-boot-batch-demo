package com.example.demo.batch;

import com.example.demo.batch.listener.DemoGetJobExecutionListener;
import com.example.demo.batch.validator.DemoParameterValidator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

@Configuration
public class DemoBatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    DemoGetJobExecutionListener demoGetJobExecutionListener;

    @Autowired
    private Step step1;

    @Autowired
    private Step step2;

    @Autowired
    private Step step3;

    @Bean
    public Job demoJob() {
        return new JobBuilder("demoJob", jobRepository)
                .listener(demoGetJobExecutionListener)
                .validator(validator())
                .start(step1)
                .next(step2)
                .next(step3)
                .build();
    }

    public CompositeJobParametersValidator validator() {
        final CompositeJobParametersValidator validator = new CompositeJobParametersValidator();
        validator.setValidators(Arrays.asList(new DemoParameterValidator(), new DefaultJobParametersValidator()));
        return validator;
    }
}
