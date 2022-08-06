package com.nmccray.issuetracker.issue;

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

    @Autowired
    public IssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
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
    public void updateIssue(Long issueId, String description, Long assigneeId, String status){
        Issue issue = issueRepository.findById(issueId).orElseThrow(()->
                new IllegalStateException(
                        "Issue doesnt exist!"
                )
        );
        if (description != null){ issue.setDescription(description);}
        if (assigneeId != null){ issue.setAssignee(assigneeId);}
        if (status != null){ issue.setStatus(status);}
    }

}
