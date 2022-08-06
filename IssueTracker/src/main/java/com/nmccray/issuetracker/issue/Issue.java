package com.nmccray.issuetracker.issue;

import com.nmccray.issuetracker.appuser.AppUser;

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
    private Long reporterId;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private String status;
    private LocalDate deadlineDate;
    private Long assigneeId;

    public Issue(){
    }

    public Issue (String type, Long reporterId, String title, String description,
                  LocalDateTime creationDate, String status, LocalDate deadlineDate, Long assigneeId, Long issueId){
        this.id = issueId;
        this.type = type;
        this.reporterId = reporterId;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.deadlineDate = deadlineDate;
        this.assigneeId = assigneeId;
    }

    public Issue (String type, Long reporterId, String title, String description,
                  LocalDateTime creationDate, String status, LocalDate deadlineDate, Long assigneeId){
        this.type = type;
        this.reporterId = reporterId;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.deadlineDate = deadlineDate;
        this.assigneeId = assigneeId;
    }

    public void setIssueId(Long issueId) {
        this.id = issueId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
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

    public Long getAssignee() {
        return assigneeId;
    }

    public void setAssignee(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + id +
                ", type='" + type + '\'' +
                ", reporterId=" + reporterId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", deadlineDate=" + deadlineDate +
                '}';
    }
}
