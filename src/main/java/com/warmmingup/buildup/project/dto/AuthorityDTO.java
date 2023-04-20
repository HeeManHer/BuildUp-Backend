package com.warmmingup.buildup.project.dto;

public class AuthorityDTO {

    private int roleNo;

    private String roleName;

    public AuthorityDTO() {

    }

    public AuthorityDTO(int roleNo, String roleName) {
        this.roleNo = roleNo;
        this.roleName = roleName;
    }

    public int getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(int roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "roleNo=" + roleNo +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
