package com.nmccray.issuetracker.project;

import com.nmccray.issuetracker.appuser.AppUser;
import com.nmccray.issuetracker.appuser.AppUserRepository;
import com.nmccray.issuetracker.issue.Issue;
import com.nmccray.issuetracker.issue.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, AppUserRepository appUserRepository) {
        this.projectRepository = projectRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project getProject(Long projectId){
        return projectRepository.findById(projectId).get();
    }

    public void addProject(Project project){
        projectRepository.save(project);
        System.out.println(project);
    }

    public void deleteProject(Long projectId){
        boolean exists = projectRepository.existsById(projectId);
        if (!exists) {
            throw new IllegalStateException("Issue with id " +projectId + " does not exist");
        }
        projectRepository.deleteById(projectId);
    }

    @Transactional
    public void updateProject(Long projectId, String description, Long ownerId){
        Project project = projectRepository.findById(projectId).orElseThrow(()->
                new IllegalStateException(
                        "Project doesnt exist!"
                )
        );
        if (description != null){ project.setDescription(description);}
        if (ownerId != null){ project.setOwnerId(ownerId);}

    }

    @Transactional
    public void addUserToProject(Long projectId, Long userId){
        Project project = projectRepository.findById(projectId).orElseThrow(()->
                new IllegalStateException(
                        "Project doesnt exist!"
                )
        );

        AppUser user = appUserRepository.findById(userId).orElseThrow(()->
                new IllegalStateException(
                        "User doesnt exist!"
                )
        );

        project.addMember(user);
    }

}
