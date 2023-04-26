package com.warmmingup.buildup.member.dto;

public class EmployeeDTO {

    private String employeeNo;
    private String employeePassword;
    private String newPassword;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeNo, String employeePassword, String newPassword) {
        this.employeeNo = employeeNo;
        this.employeePassword = employeePassword;
        this.newPassword = newPassword;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeNo='" + employeeNo + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
