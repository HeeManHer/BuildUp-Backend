package com.warmmingup.buildup.sprint.dto;


import java.util.List;

public class BoardDTO {

    private int sprintNo;
    private String sprintName;
    List<IssueBoardDTO> boardIssue;

    public BoardDTO() {
    }

    public BoardDTO(int sprintNo, String sprintName, List<IssueBoardDTO> boardIssue) {
        this.sprintNo = sprintNo;
        this.sprintName = sprintName;
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
                ", boardIssue=" + boardIssue +
                '}';
    }
}
