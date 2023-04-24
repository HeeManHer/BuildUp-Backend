package com.warmmingup.buildup.backlog.dto;

public class BacklogEmployeeDTO {

    private int employeeNo;

    private int rollNo;

    public BacklogEmployeeDTO(){}

    public BacklogEmployeeDTO(int employeeNo, int rollNo) {
        this.employeeNo = employeeNo;
        this.rollNo = rollNo;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

}
