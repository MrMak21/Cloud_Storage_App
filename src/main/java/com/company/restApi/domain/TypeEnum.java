package com.company.restApi.domain;



public enum TypeEnum {
    Admin("Admin"),
    User("User");


    private String userType;

    TypeEnum(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}

