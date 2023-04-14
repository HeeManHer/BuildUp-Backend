package com.warmmingup.buildup.comment.dto;


import org.apache.ibatis.type.Alias;
import org.springframework.http.HttpStatus;


import java.util.Date;


@Alias("CommentDTO")
public class CommentDTO {

    private int issueNo;

    private int employeeNo;

    private String replyContent;

    private Date replyDate;

    public CommentDTO() {}

    public CommentDTO(int issueNo, int employeeNo, String replyContent, Date replyDate) {
        this.issueNo = issueNo;
        this.employeeNo = employeeNo;
        this.replyContent = replyContent;
        this.replyDate = replyDate;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "issueNo=" + issueNo +
                ", employeeNo=" + employeeNo +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                '}';
    }
}

