package com.nmccray.issuetracker.appuser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner UserCommandLineRunner(AppUserRepository repository){
        return args -> {
            AppUser appUser1 = new AppUser(
                    "Tom",
                    "12345"
            );
            AppUser appUser2 = new AppUser(
                    "Andrea",
                    "12345"
            );
            System.out.println(appUser1);
            System.out.println(appUser2);
           repository.saveAll(
                    List.of(appUser1, appUser2)
           );
        };
    }
}
