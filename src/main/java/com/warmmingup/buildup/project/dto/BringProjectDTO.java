package com.warmmingup.buildup.project.dto;

import java.util.List;

public class BringProjectDTO {

    private int projectNo;
    private String projectTitle;
    private List<projectEmployeeDTO> employeeName;

    public BringProjectDTO() {

    }
    public BringProjectDTO(int projectNo, String projectTitle, List<projectEmployeeDTO> employeeName) {
        this.projectNo = projectNo;
        this.projectTitle = projectTitle;
        this.employeeName = employeeName;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public List<projectEmployeeDTO> getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(List<projectEmployeeDTO> employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "BringProjectDTO{" +
                "projectNo=" + projectNo +
                ", projectTitle='" + projectTitle + '\'' +
                ", employeeName=" + employeeName +
                '}';
    }
}
