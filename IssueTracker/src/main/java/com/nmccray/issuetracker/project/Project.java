package com.nmccray.issuetracker.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.issue.Issue;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private Long id;
    private Long ownerId;
    private String name;
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Issue> issues = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name="project_members",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonBackReference
    private Set<AppUser> members = new LinkedHashSet<>();

    public Project(){}

    public Project(Long ownerId, String name, String description){
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AppUser> getMembers() {
        return members;
    }

    public void setMembers(Set<AppUser> members) {
        this.members = members;
    }

    public void addMember(AppUser member) {
        this.members.add(member);
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public void addIssue(Issue issue) {
        this.issues.add(issue);
    }

    public void removeIssue(Issue issue) {
        this.issues.remove(issue);
    }


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
