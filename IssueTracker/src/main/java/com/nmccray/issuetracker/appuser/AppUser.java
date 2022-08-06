package com.nmccray.issuetracker.appuser;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nmccray.issuetracker.issue.Issue;
import com.nmccray.issuetracker.project.Project;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class AppUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    private LocalDate registered;

    @ManyToMany(mappedBy = "members")
    @JsonManagedReference
    private Set<Project> projects = new LinkedHashSet<>();


    @JsonBackReference
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Issue> createdIssues = new LinkedHashSet<>();


    @JsonBackReference
    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Issue> assignedIssues = new LinkedHashSet<>();


    public AppUser(){}

    public AppUser(String name, String password){
        this.name = name;
        this.password = password;
        this.registered = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Issue> getCreatedIssues() {
        return createdIssues;
    }

    public void setCreatedIssues(Set<Issue> createdIssues) {
        this.createdIssues = createdIssues;
    }

    public Set<Issue> getAssignedIssues() {
        return assignedIssues;
    }

    public void setAssignedIssues(Set<Issue> assignedIssues) {
        this.assignedIssues = assignedIssues;
    }

    public void addCreatedIssues(Issue issue){
        this.createdIssues.add(issue);
    }

    public void addAssignedIssues(Issue issue){
        this.assignedIssues.add(issue);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registered=" + registered +
                '}';
    }
}
