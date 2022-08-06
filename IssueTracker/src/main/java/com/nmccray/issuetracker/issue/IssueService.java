package com.nmccray.issuetracker.issue;

import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.appuser.AppUserRepository;
import com.nmccray.issuetracker.project.Project;
import com.nmccray.issuetracker.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private final AppUserRepository appUserRepository;



    @Autowired
    public IssueService(IssueRepository issueRepository,AppUserRepository appUserRepository){
        this.issueRepository = issueRepository;
        this.appUserRepository = appUserRepository;
    }
    public List<Issue> getIssues(){
        return issueRepository.findAll();
    }

    public void addIssue(Issue issue){
        issueRepository.save(issue);
        System.out.println(issue);
    }

    public void deleteIssue(Long issueId){
        boolean exists = issueRepository.existsById(issueId);
        if (!exists) {
            throw new IllegalStateException("Issue with id " +issueId + " does not exist");
        }
        issueRepository.deleteById(issueId);
    }

    @Transactional
    public void updateIssue(Long issueId, String description, String status){
        Issue issue = issueRepository.findById(issueId).orElseThrow(()->
                new IllegalStateException(
                        "Issue doesnt exist!"
                )
        );
        if (description != null){ issue.setDescription(description);}
        if (status != null){ issue.setStatus(status);}
    }

    @Transactional
    public void assignIssueToUser(Long issueId, Long assigneeId){
        Issue issue = issueRepository.findById(issueId).orElseThrow(()->
                new IllegalStateException(
                        "Project doesnt exist!"
                )
        );

        AppUser assignee = appUserRepository.findById(assigneeId).orElseThrow(()->
                new IllegalStateException(
                        "Issue doesnt exist!"
                )
        );

        issue.setAssignee(assignee);
        assignee.addAssignedIssues(issue);
    }

}
