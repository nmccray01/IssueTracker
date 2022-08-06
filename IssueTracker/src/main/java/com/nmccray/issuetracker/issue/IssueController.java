package com.nmccray.issuetracker.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/issue")
public class IssueController {
    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public List<Issue> getIssues(){
        return issueService.getIssues();
    }

    @PostMapping
    public void createIssue(@RequestBody Issue issue){
        issueService.addIssue(issue);
    }

    @DeleteMapping(path="{issueId}")
    public void deleteIssue(@PathVariable("issueId") Long issueId){
        issueService.deleteIssue(issueId);
    }

    @PutMapping(path="{issueId}")
    public void updateIssue(
            @PathVariable("issueId") Long issueId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Long assigneeId,
            @RequestParam(required = false) String status) {
        issueService.updateIssue(issueId, description, assigneeId, status);
    }

}