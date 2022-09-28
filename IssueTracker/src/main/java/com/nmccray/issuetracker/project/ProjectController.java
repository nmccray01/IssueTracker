package com.nmccray.issuetracker.project;


import com.nmccray.issuetracker.issue.Issue;
import com.nmccray.issuetracker.issue.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping(path="{projectId}")
    public Project getProject(@PathVariable("projectId") Long projectId){
        return projectService.getProject(projectId);
    }

    @PostMapping
    public void createProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    @DeleteMapping(path="{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId){
        projectService.deleteProject(projectId);
    }

    @PutMapping(path="{projectId}")
    public void updateProject(
            @PathVariable("projectId") Long projectId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Long ownerId
            ) {
        projectService.updateProject(projectId, description, ownerId);
    }

    @PutMapping("{projectId}/users/{userId}")
    public void addUserToProject(
            @PathVariable("projectId") Long projectId,
            @PathVariable("userId") Long userId
    ){
        projectService.addUserToProject(projectId, userId);
    }

    @PutMapping("{projectId}/issues/{issueId}")
    public void addIssueToProject(
            @PathVariable("projectId") Long projectId,
            @PathVariable("issueId") Long issueId
    ){
        projectService.addIssueToProject(projectId, issueId);
    }

}
