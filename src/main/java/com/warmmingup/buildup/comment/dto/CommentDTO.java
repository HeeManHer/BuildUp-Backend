package com.warmmingup.buildup.comment.dto;

import org.apache.ibatis.type.Alias;
import java.util.Date;

/* 댓글 DTO  */
@Alias("CommentDTO")
public class CommentDTO {

    private int issueNo;

    private int employeeNo;

    private int replyNo;

    private String replyContent;

    private Date replyDate;

    public CommentDTO() {}

    /* Comment 생성자*/
    public CommentDTO(int issueNo, int employeeNo, int replyNo, String replyContent, Date replyDate) {
        this.issueNo = issueNo;
        this.employeeNo = employeeNo;
        this.replyNo = replyNo;
        this.replyContent = replyContent;
        this.replyDate = replyDate;
    }

    /* Comment getter와 setter */
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

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
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

    /* Comment toString */
    @Override
    public String toString() {
        return "CommentDTO{" +
                "issueNo=" + issueNo +
                ", employeeNo=" + employeeNo +
                ", replyNo=" + replyNo +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                '}';
    }
}
