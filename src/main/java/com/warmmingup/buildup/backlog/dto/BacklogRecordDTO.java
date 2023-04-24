package com.warmmingup.buildup.backlog.dto;

import java.util.Date;

public class BacklogRecordDTO {
    private String editor;
    private String state;

    private Date date;

    private int backlogNo;

    private int recordNo;



    public BacklogRecordDTO() {}

    public BacklogRecordDTO(String editor, String state, Date date, int backlogNo, int recordNo) {
        this.editor = editor;
        this.state = state;
        this.date = date;
        this.backlogNo = backlogNo;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBacklogNo() {
        return backlogNo;
    }

    public void setBacklogNo(int backlogNo) {
        this.backlogNo = backlogNo;
    }

    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    @Override
    public String toString() {
        return "BacklogRecordDTO{" +
                "editor='" + editor + '\'' +
                ", state='" + state + '\'' +
                ", date=" + date +
                ", backlogNo=" + backlogNo +
                ", recordNo=" + recordNo +
                '}';
    }
}


