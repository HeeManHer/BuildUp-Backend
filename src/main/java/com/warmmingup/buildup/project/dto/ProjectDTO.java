package com.warmmingup.buildup.project.dto;

import org.springframework.http.HttpStatus;

public class ProjectDTO {

    private int projectNo;
    private String projectTitle;
    private int roleNo;
    private String roleName;
    private int employeeNo;
    private String employeeName;
    private String employeeEmail;

    public ProjectDTO() {

    }

    public ProjectDTO(int projectNo, String projectTitle, int roleNo, String roleName, int employeeNo, String employeeName, String employeeEmail) {
        this.projectNo = projectNo;
        this.projectTitle = projectTitle;
        this.roleNo = roleNo;
        this.roleName = roleName;
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
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

    public int getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(int roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectTitle='" + projectTitle + '\'' +
                ", roleNo=" + roleNo +
                ", roleName='" + roleName + '\'' +
                ", employeeNo=" + employeeNo +
                ", employeeName='" + employeeName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }
}
