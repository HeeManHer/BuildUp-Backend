package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dao.ProjectMapper;
import com.warmmingup.buildup.project.dto.AuthorityDTO;
import com.warmmingup.buildup.project.dto.BringProjectDTO;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import com.warmmingup.buildup.project.dto.projectEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<ProjectDTO> findAllProjects(int projectCnt) {

        return projectMapper.selectAllProjects(projectCnt);
    }

    @Override
    @Transactional
    public int registProject(BringProjectDTO newProject) {

        projectMapper.insertProject(newProject);
        for (projectEmployeeDTO employee : newProject.getEmployeeName()) {
            if (employee == null) {
                continue;

            }
            projectMapper.insertProjectEmployee(employee);
        }
        return projectMapper.findProjectsByNo(newProject);
    }

    @Override
    public List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt) {

        return projectMapper.findAllProjectMembers(projectMemberCnt);
    }

    @Override
    public Object findProjectTitle(int projectNo) {

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
    public void inviteProjectMember(BringProjectDTO inviteMember) {

        projectMapper.inviteTeamMember(inviteMember);

    }

    @Override
    public void removeProjectMember(Map<String, Object> removeMember) {

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


}

