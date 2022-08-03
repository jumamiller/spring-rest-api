package com.bikebuka.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Miller","Juma","miller.juma@kinetics.co.ke","E008","+254748730956")));
            log.info("Preloading " + repository.save(new Employee("Wendy", "Atieno","wendyatieno@gmail.com","90OOP","+254115104377")));
        };
    }
}
