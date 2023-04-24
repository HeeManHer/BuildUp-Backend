package com.warmmingup.buildup.backlog.dto;

public class BacklogAuthorityDTO {

    private int projectNo;

    private  String employeeName;

    private int roleNo;

    private String authorityState;

    private int employeeNo;


  public  BacklogAuthorityDTO() {}

    public BacklogAuthorityDTO(int projectNo, String employeeName, int rollNo, String authorityState, int employeeNo) {
        this.projectNo = projectNo;
        this.employeeName = employeeName;
        this.roleNo = rollNo;
        this.authorityState = authorityState;
        this.employeeNo = employeeNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(int roleNo) {
        this.roleNo = roleNo;
    }

    public String getAuthorityState() {
        return authorityState;
    }

    public void setAuthorityState(String authorityState) {
        this.authorityState = authorityState;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    @Override
    public String toString() {
        return "BacklogAuthorityDTO{" +
                "projectNo=" + projectNo +
                ", employeeName='" + employeeName + '\'' +
                ", rollNo=" + roleNo +
                ", authorityState='" + authorityState + '\'' +
                ", employeeNo=" + employeeNo +
                '}';
    }
}
