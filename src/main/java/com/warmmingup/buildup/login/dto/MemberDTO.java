package com.warmmingup.buildup.login.dto;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MemberDTO implements UserDetails {

    private String employeeNo;
    private String employeePassword;
    private String employeeEmail;
    private String employeeName;
    private String employeeRole;

    public MemberDTO() {}

    @Override
    public String toString() {
        return "MemberDTO{" +
                "employeeNo='" + employeeNo + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public MemberDTO(String employeeNo, String employeePassword, String employeeEmail, String employeeName, String employeeRole, Collection<? extends GrantedAuthority> authorities) {
        this.employeeNo = employeeNo;
        this.employeePassword = employeePassword;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.authorities = authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.employeePassword;
    }

    @Override
    public String getUsername() {
        return this.employeeNo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
