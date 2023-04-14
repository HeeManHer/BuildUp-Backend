package com.warmmingup.buildup.admin.dto;

public class AuthorityDTO {

    private int roleNo;
    private String roleName;
    private int typeNo;
    private String typeName;
    private String state;

    public AuthorityDTO () {
    }

    public AuthorityDTO (int roleNo, String roleName, int typeNo, String typeName, String state) {
        this.roleNo = roleNo;
        this.roleName = roleName;
        this.typeNo = typeNo;
        this.typeName = typeName;
        this.state = state;
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

    public int getTypeNo () {
        return typeNo;
    }

    public void setTypeNo (int typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName () {
        return typeName;
    }

    public void setTypeName (String typeName) {
        this.typeName = typeName;
    }

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    @Override
    public String toString () {
        return "AuthorityDTO{" + "roleNo=" + roleNo + ", roleName='" + roleName + '\'' + ", typeNo=" + typeNo + ", typeName='" + typeName + '\'' + ", state='" + state + '\'' + '}';
    }
}
