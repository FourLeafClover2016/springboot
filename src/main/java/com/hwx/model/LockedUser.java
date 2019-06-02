package com.hwx.model;

import java.util.Date;

public class LockedUser {
    private Long id;

    private String userName;

    private Date lockedTime;

    public LockedUser() {
    }

    public LockedUser(String userName, Date lockedTime) {
        this.userName = userName;
        this.lockedTime = lockedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }
}