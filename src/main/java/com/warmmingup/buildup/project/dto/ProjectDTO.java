package com.warmmingup.buildup.project.dto;

import org.springframework.http.HttpStatus;

public class ProjectDTO {

    private int projectNo;
    private String projectTitle;
    private String employeeName;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectNo, String projectTitle, String employeeName) {
        this.projectNo = projectNo;
        this.projectTitle = projectTitle;
        this.employeeName = employeeName;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectTitle='" + projectTitle + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}


