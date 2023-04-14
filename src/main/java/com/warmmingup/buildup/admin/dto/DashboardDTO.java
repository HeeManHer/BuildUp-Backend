package com.warmmingup.buildup.admin.dto;

public class DashboardDTO {

    private String name;
    private String state;
    private int count;

    public DashboardDTO () {}

    public DashboardDTO (String name, String state, int count) {
        this.name = name;
        this.state = state;
        this.count = count;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    public int getCount () {
        return count;
    }

    public void setCount (int count) {
        this.count = count;
    }

    @Override
    public String toString () {
        return "DashBoardDTO{" + "name='" + name + '\'' + ", state='" + state + '\'' + ", count=" + count + '}';
    }
}
