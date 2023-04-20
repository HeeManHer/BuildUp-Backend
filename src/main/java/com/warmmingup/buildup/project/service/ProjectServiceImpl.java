package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dao.ProjectMapper;
import com.warmmingup.buildup.project.dto.AuthorityDTO;
import com.warmmingup.buildup.project.dto.BringProjectDTO;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import com.warmmingup.buildup.project.dto.projectEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> findAllProjects(Map<String, Integer> projectCnt) {

        return projectMapper.findAllProjects(projectCnt);
    }

    @Override
    @Transactional
    public int registProject(BringProjectDTO newProject) {

        projectMapper.insertProject(newProject);
        for(projectEmployeeDTO employee : newProject.getEmployeeName()) {
            if(employee == null) {
                continue;

            }
            projectMapper.insertProjectEmployee(employee);
        }
        return projectMapper.findProjectsByNo(newProject);
    }

//    @Override
//    public void modifyProjectTitle(ProjectDTO updateTitle) {
//
//        projectMapper.modifyProjectTitle(updateTitle);
//    }

    @Override
    public List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt) {

        return projectMapper.findAllProjectMembers(projectMemberCnt);
    }

    @Override
    public Object selectProjectTitle(int projectNo) {

        return projectMapper.selectProjectTitle(projectNo);
    }

    @Override
    public void modifyProjectManagerTitle(ProjectDTO modifyTitle) {

        projectMapper.modifyProjectManagerTitle(modifyTitle);
    }

    @Override
    public void removeProject(int projectNo) {

        projectMapper.removeProject(projectNo);
    }

    @Override
    @Transactional
    public void inviteTeamMember(BringProjectDTO inviteMember) {

        projectMapper.inviteTeamMember(inviteMember);

    }

    @Override
    public void removeTeamMember(Map<String, Object> removeMember) {

        projectMapper.removeTeamMember(removeMember);
    }

    @Override
    public void modifyMemberAuthority(Map<String, Object> map) {

        projectMapper.modifyMemberAuthority(map);
    }

    @Override
    public List<AuthorityDTO> findAuthority() {

        return projectMapper.findAuthority();
    }


//    @Override
//    public List<projectEmployeeDTO> searchMembers(Map<String, Object> searchMembers) {
//
//        return projectMapper.searchMembers(searchMembers);
//    }


}

