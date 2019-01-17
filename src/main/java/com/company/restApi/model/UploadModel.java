package com.company.restApi.model;

import com.company.restApi.domain.User;

public class UploadModel {
    private String ref_key;
    private long size;
    private User user;

    public UploadModel() {
    }

    public String getRef_key() {
        return ref_key;
    }

    public void setRef_key(String ref_key) {
        this.ref_key = ref_key;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
