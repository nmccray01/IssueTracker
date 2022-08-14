package com.nmccray.issuetracker.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

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

    public void signUpUser(AppUser appUser){
        boolean userExists = appUserRepository.findUserByEmail(appUser.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("Email already taken!");
        }

        //Else encode password and save user
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findUserByEmail(email).orElseThrow(()-> new UsernameNotFoundException(" User with email %s not found!"));
    }

    @Transactional
    public void updateUser(Long userId, String name, String email, String password, AppUserRole role){
        AppUser appUser = appUserRepository.findById(userId).orElseThrow(()->
                new IllegalStateException(
                        "Issue doesnt exist!"
                )
        );
        if (name != null){ appUser.setUsername(name);}
        if (email != null){ appUser.setEmail(email);}
        if (password != null){ appUser.setPassword(password);}
        if (role != null){ appUser.setRole(role);}
    }


}
