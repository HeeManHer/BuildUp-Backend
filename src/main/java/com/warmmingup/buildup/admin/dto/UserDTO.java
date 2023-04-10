package com.warmmingup.buildup.admin.dto;

import org.apache.ibatis.type.Alias;

@Alias("UserDTO")
public class UserDTO {

    private int no;
    private String name;
    private String email;
    private String authority;

    public UserDTO() {
    }

    public UserDTO(int no, String name, String email, String authority) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.authority = authority;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
