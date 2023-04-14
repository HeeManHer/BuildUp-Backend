package com.warmmingup.buildup.sprint.dto;

import org.apache.ibatis.type.Alias;

import java.sql.Date;


@Alias("SprintDTO")
public class SprintDTO {

    private int sprintNo;
    private String sprintName;
    private Date sprintStartday;
    private Date sprintEndday;
    private String sprintState;
    private int projectNo;

    public SprintDTO() {}

    public SprintDTO(int sprintNo, String sprintName, Date sprintStartday, Date sprintEndday, String sprintState, int projectNo) {
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
        this.sprintStartday = sprintStartday;
        this.sprintEndday = sprintEndday;
        this.sprintState = sprintState;
        this.projectNo = projectNo;
    }

    public int getSprintNo() {
        return sprintNo;
    }

    public void setSprintNo(int sprintNo) {
        this.sprintNo = sprintNo;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Date getSprintStartday() {
        return sprintStartday;
    }

    public void setSprintStartday(Date sprintStartday) {
        this.sprintStartday = sprintStartday;
    }

    public Date getSprintEndday() {
        return sprintEndday;
    }

    public void setSprintEndday(Date sprintEndday) {
        this.sprintEndday = sprintEndday;
    }

    public String getSprintState() {
        return sprintState;
    }

    public void setSprintState(String sprintState) {
        this.sprintState = sprintState;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "SprintDTO{" +
                "sprintNo=" + sprintNo +
                ", sprintName='" + sprintName + '\'' +
                ", sprintStartday=" + sprintStartday +
                ", sprintEndday=" + sprintEndday +
                ", sprintState='" + sprintState + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}