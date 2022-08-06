package com.nmccray.issuetracker.issue;

import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.appuser.AppUserRepository;
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
    CommandLineRunner IssueCommandLineRunner(IssueRepository repository, AppUserRepository userRepository){
        return args -> {
            Issue issue1 = new Issue(
                    userRepository.findById(1L).get(),
                    "Story",
                    "First Issue",
                    "This is our first Issue",
                    LocalDateTime.now(),
                    "Backlog",
                    null
            );
            Issue issue2 = new Issue(
                    userRepository.findById(2L).get(),
                    "Task",
                    "Closure required",
                    "Close this issue",
                    LocalDateTime.now(),
                    "Backlog",
                    LocalDate.of(2023, Month.JANUARY, 5)
            );
            repository.saveAll(
                    List.of(issue1, issue2)
            );
        };
    }
}
