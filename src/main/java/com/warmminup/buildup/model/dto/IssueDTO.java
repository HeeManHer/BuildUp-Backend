package com.warmminup.buildup.model.dto;

import org.springframework.http.HttpStatus;

public class IssueDTO {

    private int issue_No;
    private String issue_Name;
    private String issue_Content;
    private String issue_Priority;
    private String issue_Status;
    private int backlog_No;
    private int project_No;

    public IssueDTO(HttpStatus ok, String 조회_성공) {}

    public IssueDTO(int issue_No, String issue_Name, String issue_Content, String issue_Priority, String issue_Status, int backlog_No, int project_No) {
        this.issue_No = issue_No;
        this.issue_Name = issue_Name;
        this.issue_Content = issue_Content;
        this.issue_Priority = issue_Priority;
        this.issue_Status = issue_Status;
        this.backlog_No = backlog_No;
        this.project_No = project_No;
    }

    public int getIssue_No() {
        return issue_No;
    }

    public void setIssue_No(int issue_No) {
        this.issue_No = issue_No;
    }

    public String getIssue_Name() {
        return issue_Name;
    }

    public void setIssue_Name(String issue_Name) {
        this.issue_Name = issue_Name;
    }

    public String getIssue_Content() {
        return issue_Content;
    }

    public void setIssue_Content(String issue_Content) {
        this.issue_Content = issue_Content;
    }

    public String getIssue_Priority() {
        return issue_Priority;
    }

    public void setIssue_Priority(String issue_Priority) {
        this.issue_Priority = issue_Priority;
    }

    public String getIssue_Status() {
        return issue_Status;
    }

    public void setIssue_Status(String issue_Status) {
        this.issue_Status = issue_Status;
    }

    public int getBacklog_No() {
        return backlog_No;
    }

    public void setBacklog_No(int backlog_No) {
        this.backlog_No = backlog_No;
    }

    public int getProject_No() {
        return project_No;
    }

    public void setProject_No(int project_No) {
        this.project_No = project_No;
    }

    @Override
    public String toString() {
        return "IssueDTO{" +
                "issue_No=" + issue_No +
                ", issue_Name='" + issue_Name + '\'' +
                ", issue_Content='" + issue_Content + '\'' +
                ", issue_Priority='" + issue_Priority + '\'' +
                ", issue_Status='" + issue_Status + '\'' +
                ", backlog_No=" + backlog_No +
                ", project_No=" + project_No +
                '}';
    }
}
