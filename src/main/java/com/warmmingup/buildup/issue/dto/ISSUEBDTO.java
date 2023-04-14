package com.warmmingup.buildup.issue.dto;

public class ISSUEBDTO {

    private int backlogNo;
    private String backlogName;

    public ISSUEBDTO () {}

    public ISSUEBDTO(int backlogNo, String backlogName) {
        this.backlogNo = backlogNo;
        this.backlogName = backlogName;
    }

    public int getBacklogNo() {
        return backlogNo;
    }

    public void setBacklogNo(int backlogNo) {
        this.backlogNo = backlogNo;
    }

    public String getBacklogName() {
        return backlogName;
    }

    public void setBacklogName(String backlogName) {
        this.backlogName = backlogName;
    }

    @Override
    public String toString() {
        return "ISSUEBDTO{" +
                "backlogNo=" + backlogNo +
                ", backlogName='" + backlogName + '\'' +
                '}';
    }
}
