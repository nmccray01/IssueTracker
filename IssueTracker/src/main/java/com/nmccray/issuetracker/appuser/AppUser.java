package com.nmccray.issuetracker.appuser;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nmccray.issuetracker.issue.Issue;
import com.nmccray.issuetracker.project.Project;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table
public class AppUser implements UserDetails{
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
    private String username;
    private String email;
    private String password;
    private LocalDate registered;
    private AppUserRole role;
    private Boolean locked;
    private Boolean enabled;

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

    public AppUser(String username, String email, String password, AppUserRole role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.registered = LocalDate.now();
        this.role = role;
        this.locked = false;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
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
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registered=" + registered +
                '}';
    }
}
