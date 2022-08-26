package com.nmccray.issuetracker.appuser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT i from AppUser i WHERE i.username = ?1")
    Optional<AppUser> findUserByName(String username);

    @Query("SELECT i from AppUser i WHERE i.email = ?1")
    Optional<AppUser> findUserByEmail(String email);

    @Query("SELECT i from AppUser i WHERE i.email = ?1 AND i.password = ?2")
    Optional<AppUser> findUserByCredentials(String email, String password);

}
