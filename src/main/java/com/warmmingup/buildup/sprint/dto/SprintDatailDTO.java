package com.warmmingup.buildup.sprint.dto;


import java.util.List;

public class SprintDatailDTO {

    private int sprintNo;
    private String sprintName;
    private String state;
    List<IssueBoardDTO> boardIssue;

    public SprintDatailDTO() {
    }

    public SprintDatailDTO(int sprintNo, String sprintName, String state, List<IssueBoardDTO> boardIssue) {
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
        this.state = state;
        this.boardIssue = boardIssue;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<IssueBoardDTO> getBoardIssue() {
        return boardIssue;
    }

    public void setBoardIssue(List<IssueBoardDTO> boardIssue) {
        this.boardIssue = boardIssue;
    }


    @Override
    public String toString() {
        return "BoardDTO{" +
                "sprintNo=" + sprintNo +
                ", sprintName='" + sprintName + '\'' +
                ", state='" + state + '\'' +
                ", boardIssue=" + boardIssue +
                '}';
    }
}
