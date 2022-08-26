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
    CommandLineRunner UserCommandLineRunner(AppUserRepository repository, AppUserService service){
        return args -> {
            AppUser DummyUser1 = new AppUser(
                    "Tom",
                    "Tom@email.de",
                    "12345",
                    USER
            );
            AppUser DummyUser2 = new AppUser(
                    "Andrea",
                    "andrea@email.de",
                    "12345",
                    USER
            );
            System.out.println(DummyUser1);
            System.out.println(DummyUser2);
           repository.saveAll(
                    List.of(DummyUser1, DummyUser2)
           );

           service.signUpUser(new AppUser("Admin", "admin@admin.de", "admin123", ADMIN));
        };
    }
}
