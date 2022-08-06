package com.nmccray.issuetracker.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getUsers(){
        return appUserRepository.findAll();
    }

    public void addUser(AppUser appUser){
        appUserRepository.save(appUser);
        System.out.println(appUser);
    }

    public void deleteUser(Long userId){
        boolean exists = appUserRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " +userId + " does not exist");
        }
        appUserRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String password){
        AppUser appUser = appUserRepository.findById(userId).orElseThrow(()->
                new IllegalStateException(
                        "Issue doesnt exist!"
                )
        );
        if (name != null){ appUser.setName(name);}
        if (password != null){ appUser.setPassword(password);}
    }


}
