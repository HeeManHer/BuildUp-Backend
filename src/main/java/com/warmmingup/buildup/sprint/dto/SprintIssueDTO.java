package com.warmmingup.buildup.sprint.dto;

public class SprintIssueDTO {

    private int issueNo;
    private String issueName;
    private int employeeNo;
    private String employeeName;

    public SprintIssueDTO() {
    }

    public SprintIssueDTO(int issueNo, String issueName, int employeeNo, String employeeName) {
        this.issueNo = issueNo;
        this.issueName = issueName;
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
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

    @Override
    public String toString() {
        return "SprintIssueDTO{" +
                "issueNo=" + issueNo +
                ", issueName='" + issueName + '\'' +
                ", employeeNo=" + employeeNo +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}

