package com.dinosaws.application;

import com.dinosaws.application.data.repository.DinoRepo;
import com.dinosaws.application.data.repository.DinosawRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DinosawRepository dinosawRepository() {
        return new DinoRepo();
    }
}
