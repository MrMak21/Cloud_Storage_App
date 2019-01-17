package com.company.restApi.form;

import com.company.restApi.domain.TypeEnum;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignUpForm {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final int PASSWORD_MINSIZE = 4;

    @Pattern(regexp = USERNAME_PATTERN, message = "firstname.empty")
    private String firstname;

    @Pattern(regexp = USERNAME_PATTERN, message = "lastname.empty")
    private String lastname;

    @Pattern(regexp = MAIL_PATTERN, message = "Invalid Mail")
    private String email;

    @Pattern(regexp = PASSWORD_PATTERN, message = "Invalid Password")
    @Size(min = PASSWORD_MINSIZE, message = "Invalid Password Size")
    private String password;

    private TypeEnum type;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
}
