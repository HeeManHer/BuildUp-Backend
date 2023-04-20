package com.warmmingup.buildup.admin.dto;

public class AdminLoginDTO {

    private String adminId;
    private String adminPwd;

    public AdminLoginDTO () {
    }

    public AdminLoginDTO (String adminId, String adminPwd) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
    }

    public String getAdminId () {
        return adminId;
    }

    public void setAdminId (String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd () {
        return adminPwd;
    }

    public void setAdminPwd (String adminPwd) {
        this.adminPwd = adminPwd;
    }

    @Override
    public String toString () {
        return "AdminLoginDTO{" + "adminId='" + adminId + '\'' + ", adminPwd='" + adminPwd + '\'' + '}';
    }
}
