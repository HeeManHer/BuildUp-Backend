package com.warmmingup.buildup.admin.dto;

import java.sql.Date;

public class DashProjectDTO {

    private String name;
    private Date startDate;

    public DashProjectDTO () {
    }

    public DashProjectDTO (String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString () {
        return "DashProjectDTO{" + "name='" + name + '\'' + ", startDate=" + startDate + '}';
    }
}
