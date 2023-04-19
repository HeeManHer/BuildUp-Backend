package com.warmmingup.buildup.admin.dto;

import java.util.List;

public class AuthTypeDTO {

    private int typeNo;
    private String typeName;
    private List<String> state;

    public AuthTypeDTO() {
    }

    public AuthTypeDTO(int typeNo, String typeName, List<String> state) {
        this.typeNo = typeNo;
        this.typeName = typeName;
        this.state = state;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AuthTypeDTO{" +
                "typeNo=" + typeNo +
                ", typeName='" + typeName + '\'' +
                ", state=" + state +
                '}';
    }
}
