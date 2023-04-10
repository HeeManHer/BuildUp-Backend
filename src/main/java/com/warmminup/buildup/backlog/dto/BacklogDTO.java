package com.warmminup.buildup.backlog.dto;

import org.springframework.http.HttpStatus;

public class BacklogDTO {

    private int backlog_No;
    private String backlog_Name;
    private String backlog_Content;
    private String backlog_Status;
    private String getBacklog_Priority;
    private int project_No;
 public BacklogDTO(HttpStatus ok, String 조회_성공){}

    public BacklogDTO(int backlog_No, String backlog_Name, String backlog_Content, String backlog_Status, String getBacklog_Priority, int project_No) {
        this.backlog_No = backlog_No;
        this.backlog_Name = backlog_Name;
        this.backlog_Content = backlog_Content;
        this.backlog_Status = backlog_Status;
        this.getBacklog_Priority = getBacklog_Priority;
        this.project_No = project_No;
    }

    public int getBacklog_No() {
        return backlog_No;
    }

    public void setBacklog_No(int backlog_No) {
        this.backlog_No = backlog_No;
    }

    public String getBacklog_Name() {
        return backlog_Name;
    }

    public void setBacklog_Name(String backlog_Name) {
        this.backlog_Name = backlog_Name;
    }

    public String getBacklog_Content() {
        return backlog_Content;
    }

    public void setBacklog_Content(String backlog_Content) {
        this.backlog_Content = backlog_Content;
    }

    public String getBacklog_Status() {
        return backlog_Status;
    }

    public void setBacklog_Status(String backlog_Status) {
        this.backlog_Status = backlog_Status;
    }

    public String getGetBacklog_Priority() {
        return getBacklog_Priority;
    }

    public void setGetBacklog_Priority(String getBacklog_Priority) {
        this.getBacklog_Priority = getBacklog_Priority;
    }

    public int getProject_No() {
        return project_No;
    }

    public void setProject_No(int project_No) {
        this.project_No = project_No;
    }

    @Override
    public String toString() {
        return "BacklogDTO{" +
                "backlog_No=" + backlog_No +
                ", backlog_Name='" + backlog_Name + '\'' +
                ", backlog_Content='" + backlog_Content + '\'' +
                ", backlog_Status='" + backlog_Status + '\'' +
                ", getBacklog_Priority='" + getBacklog_Priority + '\'' +
                ", project_No=" + project_No +
                '}';
    }
}