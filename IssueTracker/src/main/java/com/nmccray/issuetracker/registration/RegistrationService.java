package com.nmccray.issuetracker.registration;

import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.appuser.AppUserRole;
import com.nmccray.issuetracker.appuser.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final AppUserService appUserService;

    public RegistrationService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public void register(RegistrationRequest request){
        appUserService.signUpUser(
                new AppUser(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                ));
    }
}
