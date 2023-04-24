package com.warmmingup.buildup.sprint.dto;

import java.util.List;

public class IssueBoardDTO {

    private String issueState;
    private List<SprintIssueDTO> sprintIssue;

    public IssueBoardDTO() {
    }

    public IssueBoardDTO(String issueState, List<SprintIssueDTO> sprintIssue) {
        this.issueState = issueState;
        this.sprintIssue = sprintIssue;
    }

    public String getIssueState() {
        return issueState;
    }

    public void setIssueState(String issueState) {
        this.issueState = issueState;
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
                "boardName='" + issueState + '\'' +
                ", sprintIssue=" + sprintIssue +
                '}';
    }
}
