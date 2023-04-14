package com.warmmingup.buildup.admin.dto;

public class NewUserDTO {

    private int no;
    private String name;
    private String email;
    private String pwd;
    private boolean authority;

    public NewUserDTO () {
    }

    public NewUserDTO (int no, String name, String email, String pwd, boolean authority) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.authority = authority;
    }

    public int getNo () {
        return no;
    }

    public void setNo (int no) {
        this.no = no;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPwd () {
        return pwd;
    }

    public void setPwd (String pwd) {
        this.pwd = pwd;
    }

    public boolean isAuthority () {
        return authority;
    }

    public void setAuthority (boolean authority) {
        this.authority = authority;
    }

    @Override
    public String toString () {
        return "NewUserDTO{" + "no='" + no + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", pwd='" + pwd + '\'' + ", authority=" + authority + '}';
    }
}
