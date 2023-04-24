package com.warmmingup.buildup.sprint.dto;

import java.util.List;

public class IssueBoardDTO {

    private String boardName;
    private List<SprintIssueDTO> sprintIssue;

    public IssueBoardDTO() {
    }

    public IssueBoardDTO(String boardName, List<SprintIssueDTO> sprintIssue) {
        this.boardName = boardName;
        this.sprintIssue = sprintIssue;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<SprintIssueDTO> getSprintIssue() {
        return sprintIssue;
    }

    public void setSprintIssue(List<SprintIssueDTO> sprintIssue) {
        this.sprintIssue = sprintIssue;
    }

    @Override
    public String toString() {
        return "IssueBoardDTO{" +
                "boardName='" + boardName + '\'' +
                ", sprintIssue=" + sprintIssue +
                '}';
    }
}
