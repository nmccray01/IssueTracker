package com.nmccray.issuetracker.issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

        @Query("SELECT i from Issue i WHERE i.assigneeId = ?1")
        Optional<Issue> findIssueByAssignee(Long assigneeId);

        @Query("SELECT i from Issue i WHERE i.title = ?1")
        Optional<Issue> findIssueByTitle(String title);

        @Query("SELECT i from Issue i WHERE i.status = ?1")
        Optional<Issue> findIssueByStatus(String status);
}
