package com.example.ms17task.config;

import com.example.ms17task.model.Student;
import com.example.ms17task.dp.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class Config {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public RestTemplate getBean() {
        return new RestTemplate();
    }
    @Bean
    // @Scope("prototype")
    public Singleton newSingleton1() {
        Singleton s = new Singleton();
        System.out.println("hashCode: " + s.hashCode());
      //  log.error(" Error log");
        return s;
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

}
