package com.warmmingup.buildup.backlog.dto;

import org.springframework.http.HttpStatus;

public class BacklogDTO {
    private int backlogNo;
    private String backlogName;
    private String backlogContent;
    private String backlogStatus;
    private String backlogPriority;
    private int projectNo;
 public BacklogDTO(){}

    public BacklogDTO(int backlogNo, String backlogName, String backlogContent, String backlogStatus, String backlogPriority, int projectNo) {
        this.backlogNo = backlogNo;
        this.backlogName = backlogName;
        this.backlogContent = backlogContent;
        this.backlogStatus = backlogStatus;
        this.backlogPriority = backlogPriority;
        this.projectNo = projectNo;
    }

    public int getBacklogNo() {
        return backlogNo;
    }

    public void setBacklogNo(int backlogNo) {
        this.backlogNo = backlogNo;
    }

    public String getBacklogName() {
        return backlogName;
    }

    public void setBacklogName(String backlogName) {
        this.backlogName = backlogName;
    }

    public String getBacklogContent() {
        return backlogContent;
    }

    public void setBacklogContent(String backlogContent) {
        this.backlogContent = backlogContent;
    }

    public String getBacklogStatus() {
        return backlogStatus;
    }

    public void setBacklogStatus(String backlogStatus) {
        this.backlogStatus = backlogStatus;
    }

    public String getBacklogPriority() {
        return backlogPriority;
    }

    public void setBacklogPriority(String backlogPriority) {
        this.backlogPriority = backlogPriority;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "BacklogDTO{" +
                "backlogNo=" + backlogNo +
                ", backlogName='" + backlogName + '\'' +
                ", backlogContent='" + backlogContent + '\'' +
                ", backlogStatus='" + backlogStatus + '\'' +
                ", backlogPriority='" + backlogPriority + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}