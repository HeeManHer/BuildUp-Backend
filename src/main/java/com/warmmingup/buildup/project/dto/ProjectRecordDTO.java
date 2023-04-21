package com.warmmingup.buildup.project.dto;

import java.util.Date;

public class ProjectRecordDTO {

    private int recordNo;
    private String editor;
    private String state;
    private Date changeTime;
    private int projectNo;

    public ProjectRecordDTO() {

    }
    public ProjectRecordDTO(int recordNo, String editor, String state, Date changeTime, int projectNo) {
        this.recordNo = recordNo;
        this.editor = editor;
        this.state = state;
        this.changeTime = changeTime;
        this.projectNo = projectNo;
    }

    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "ProjectRecordDTO{" +
                "recordNo=" + recordNo +
                ", editor='" + editor + '\'' +
                ", state='" + state + '\'' +
                ", changeTime=" + changeTime +
                ", projectNo=" + projectNo +
                '}';
    }
}
