package com.warmmingup.buildup.admin.dto;

import java.util.List;

public class AuthorityDTO {

    private int roleNo;
    private String roleName;
    private List<AuthTypeDTO> type;

    public AuthorityDTO() {
    }

    public AuthorityDTO(int roleNo, String roleName, List<AuthTypeDTO> type) {
        this.roleNo = roleNo;
        this.roleName = roleName;
        this.type = type;
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

    public List<AuthTypeDTO> getType() {
        return type;
    }

    public void setType(List<AuthTypeDTO> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "roleNo=" + roleNo +
                ", roleName='" + roleName + '\'' +
                ", type=" + type +
                '}';
    }
}
