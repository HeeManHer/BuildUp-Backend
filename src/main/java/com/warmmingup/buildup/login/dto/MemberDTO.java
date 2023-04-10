package com.warmmingup.buildup.login.dto;

public class MemberDTO {

    private String employeeNo;
    private String employeePassword;
    private String employeeEmail;
    private String employeeName;

    public MemberDTO() {}

    public MemberDTO(String employeeNo, String employeePassword, String employeeEmail, String employeeName) {
        this.employeeNo = employeeNo;
        this.employeePassword = employeePassword;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "employeeNo='" + employeeNo + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
