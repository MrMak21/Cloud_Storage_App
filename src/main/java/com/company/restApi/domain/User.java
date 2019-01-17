package com.company.restApi.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {

    private static final int MAX_NAME_LENGTH = 60;

    @Id
    @Column(name = "User_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Firstname" , length = MAX_NAME_LENGTH)
    private String firstname;

    @Column(name = "Lastname" , length = MAX_NAME_LENGTH)
    private String lastname;

    @Column(name = "Email",unique = true, length = MAX_NAME_LENGTH)
    private String email;

    @Column(name = "Password", length = MAX_NAME_LENGTH)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", length = MAX_NAME_LENGTH)
    private TypeEnum type;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,targetEntity = Upload.class)
    private List<Upload> uploads;


    public User() {
    }

    public User(String firstname, String lastname, String email, String password, TypeEnum type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public List<Upload> getUploads() {
        return uploads;
    }

    public void setUploads(List<Upload> uploads) {
        this.uploads = uploads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
