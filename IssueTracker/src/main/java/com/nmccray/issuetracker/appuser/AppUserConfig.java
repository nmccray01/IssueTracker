package com.nmccray.issuetracker.appuser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.nmccray.issuetracker.appuser.AppUserRole.ADMIN;
import static com.nmccray.issuetracker.appuser.AppUserRole.USER;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner UserCommandLineRunner(AppUserRepository repository){
        return args -> {
            AppUser appUser1 = new AppUser(
                    "Admin",
                    "admin@admin.de",
                    "12345",
                    ADMIN
            );
            AppUser appUser2 = new AppUser(
                    "Andrea",
                    "andrea@email.de",
                    "12345",
                    USER
            );
            System.out.println(appUser1);
            System.out.println(appUser2);
           repository.saveAll(
                    List.of(appUser1, appUser2)
           );
        };
    }
}
