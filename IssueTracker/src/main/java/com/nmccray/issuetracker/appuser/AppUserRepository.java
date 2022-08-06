package com.nmccray.issuetracker.appuser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT i from AppUser i WHERE i.name = ?1")
    Optional<AppUser> findUserByName(String name);

}
