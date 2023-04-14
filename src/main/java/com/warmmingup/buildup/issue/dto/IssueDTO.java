package com.warmmingup.buildup.issue.dto;

import org.springframework.http.HttpStatus;

public class IssueDTO {

    private int issueNo;
    private String issueName;
    private String issueContent;
    private String issuePriority;
    private String issueStatus;
    private int backlogNo;
    private int projectNo;

    public IssueDTO() {}

    public IssueDTO(int issueNo, String issueName, String issueContent, String issuePriority, String issueStatus, int backlogNo, int projectNo) {
        this.issueNo = issueNo;
        this.issueName = issueName;
        this.issueContent = issueContent;
        this.issuePriority = issuePriority;
        this.issueStatus = issueStatus;
        this.backlogNo = backlogNo;
        this.projectNo = projectNo;
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

    public String getIssueContent() {
        return issueContent;
    }

    public void setIssueContent(String issueContent) {
        this.issueContent = issueContent;
    }

    public String getIssuePriority() {
        return issuePriority;
    }

    public void setIssuePriority(String issuePriority) {
        this.issuePriority = issuePriority;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public int getBacklogNo() {
        return backlogNo;
    }

    public void setBacklogNo(int backlogNo) {
        this.backlogNo = backlogNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "IssueDTO{" +
                "issueNo=" + issueNo +
                ", issueName='" + issueName + '\'' +
                ", issueContent='" + issueContent + '\'' +
                ", issuePriority='" + issuePriority + '\'' +
                ", issueStatus='" + issueStatus + '\'' +
                ", backlogNo=" + backlogNo +
                ", projectNo=" + projectNo +
                '}';
    }
}
