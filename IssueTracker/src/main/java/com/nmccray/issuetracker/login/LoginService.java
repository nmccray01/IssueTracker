package com.nmccray.issuetracker.login;

import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.appuser.AppUserRole;
import com.nmccray.issuetracker.appuser.AppUserService;
import com.nmccray.issuetracker.registration.RegistrationRequest;
import com.nmccray.issuetracker.security.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class LoginService {
    private final AppUserService appUserService;
    DaoAuthenticationProvider securityProvider;

    public LoginService(AppUserService appUserService, DaoAuthenticationProvider securityProvider) {
        this.appUserService = appUserService;
        this.securityProvider = securityProvider;
    }

    public void login(LoginRequest request){
        AppUser user = appUserService.loginUser(request.getEmail(), request.getPassword());
        //TODO
    }
}
