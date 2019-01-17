package com.company.restApi.domain;

import javax.persistence.*;

@Entity
@Table(name ="Uploads")
public class Upload {

    @Id
    @Column(name ="Upload_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long upload_id;

    @Column(name ="Ref_Key",unique = true,length = 100)
    private String ref_key;


    @Column(name ="Size")
    private long size;


    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "User_id")
    private User user;


    public Upload() {
    }

    public Upload(String ref_key, User user, long size) {
        this.ref_key = ref_key;
        this.user = user;
        this.size = size;
    }

    public long getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(long upload_id) {
        this.upload_id = upload_id;
    }

    public String getRef_key() {
        return ref_key;
    }

    public void setRef_key(String ref_key) {
        this.ref_key = ref_key;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
