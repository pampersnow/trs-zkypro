package com.trs.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
    private Long id;

    private String account;

    private String password;

    private String passwordsalt;

    private Boolean isdisabled;

    private Boolean isdeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt == null ? null : passwordsalt.trim();
    }

    public Boolean getIsdisabled() {
        return isdisabled;
    }

    public void setIsdisabled(Boolean isdisabled) {
        this.isdisabled = isdisabled;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}