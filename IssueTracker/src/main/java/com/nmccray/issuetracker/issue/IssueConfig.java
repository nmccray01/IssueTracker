package com.nmccray.issuetracker.issue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class IssueConfig {

    @Bean
    CommandLineRunner IssueCommandLineRunner(IssueRepository repository){
        return args -> {
            Issue issue1 = new Issue(
                    "Story",
                    999L,
                    "First Issue",
                    "This is our first Issue",
                    LocalDateTime.now(),
                    "Backlog",
                    null,
                    null
            );
            Issue issue2 = new Issue(
                    "Task",
                    999L,
                    "Closure required",
                    "Close this issue",
                    LocalDateTime.now(),
                    "Backlog",
                    LocalDate.of(2023, Month.JANUARY, 5),
                    null
            );
            repository.saveAll(
                    List.of(issue1, issue2)
            );
        };
    }
}
