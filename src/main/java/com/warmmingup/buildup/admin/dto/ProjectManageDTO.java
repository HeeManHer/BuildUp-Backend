package com.warmmingup.buildup.admin.dto;

public class ProjectManageDTO {

    private int no;
    private String title;
    private String manager;
    private String startDate;

    public ProjectManageDTO(int no, String title, String manager, String startDate) {
        this.no = no;
        this.title = title;
        this.manager = manager;
        this.startDate = startDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "ProjectManageDTO{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", manager='" + manager + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
