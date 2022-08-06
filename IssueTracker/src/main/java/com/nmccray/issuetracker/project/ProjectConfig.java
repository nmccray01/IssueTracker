package com.nmccray.issuetracker.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    CommandLineRunner ProjectCommandLineRunner(ProjectRepository repository){
        return args -> {
            Project project1 = new Project(
                    1L,
                    "First Project",
                    "This is our first Project"
            );
            Project project2 = new Project(
                    2L,
                    "Second Project",
                    "Delete me pweaseee"
            );
            repository.saveAll(
                    List.of(project1, project2)
            );
        };
    }
}
