package com.warmmingup.buildup.admin.dto;

public class AuthTypeDTO {

    private int typeNo;
    private String typeName;

    public AuthTypeDTO (int typeNo, String typeName) {
        this.typeNo = typeNo;
        this.typeName = typeName;
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

    @Override
    public String toString () {
        return "AuthTypeDTO{" + "typeNo=" + typeNo + ", typeName='" + typeName + '\'' + '}';
    }
}
