package com.warmmingup.buildup.admin.dto;

public class AuthRoleDTO {

    private int roleNo;
    private String roleName;

    public AuthRoleDTO (int roleNo, String roleName) {
        this.roleNo = roleNo;
        this.roleName = roleName;
    }

    public int getRoleNo () {
        return roleNo;
    }

    public void setRoleNo (int roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName () {
        return roleName;
    }

    public void setRoleName (String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString () {
        return "AuthRoleDTO{" + "roleNo=" + roleNo + ", roleName='" + roleName + '\'' + '}';
    }
}
