package com.nmccray.issuetracker.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT i from Project i WHERE i.ownerId = ?1")
    Optional<Project> findProjectByAssignee(Long ownerId);

    @Query("SELECT i from Project i WHERE i.name = ?1")
    Optional<Project> findProjectByTitle(String title);

}
