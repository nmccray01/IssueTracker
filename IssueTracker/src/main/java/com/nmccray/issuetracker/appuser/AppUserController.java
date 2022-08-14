package com.nmccray.issuetracker.appuser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }


    @GetMapping
    public List<AppUser> getUsers(){
        return appUserService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody AppUser appUser){
        appUserService.addUser(appUser);
    }

    @DeleteMapping(path="{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        appUserService.deleteUser(userId);
    }

    @PutMapping(path="{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) AppUserRole role) {
        appUserService.updateUser(userId, name, email, password, role);
    }
}
