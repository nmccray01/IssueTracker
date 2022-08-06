package com.nmccray.issuetracker.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.project.Project;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table
public class Issue {
    @Id
    @SequenceGenerator(
            name = "issue_sequence",
            sequenceName = "issue_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "issue_sequence"
    )
    private Long id;
    private String type;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private String status;
    private LocalDate deadlineDate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private AppUser creator;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private AppUser assignee;

    public Issue(){
    }

    public Issue (AppUser creator, String type, String title, String description,
                  LocalDateTime creationDate, String status, LocalDate deadlineDate){
        this.creator = creator;
        this.type = type;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.deadlineDate = deadlineDate;
    }

    public void setId(Long issueId) {
        this.id = issueId;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public AppUser getCreator() {
        return creator;
    }

    public void setCreator(AppUser creator) {
        this.creator = creator;
    }

    public AppUser getAssignee() {
        return assignee;
    }

    public void setAssignee(AppUser assignee) {
        this.assignee = assignee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue )) return false;
        return id != null && id.equals(((Issue) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", deadlineDate=" + deadlineDate +
                '}';
    }
}
