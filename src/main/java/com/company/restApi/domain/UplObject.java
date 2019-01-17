package com.company.restApi.domain;


public class UplObject {

    private String ref;
    private String size;
    private long id;

    public UplObject(String ref, String size, long id) {
        this.ref = ref;
        this.size = size;
        this.id = id;
    }

    public UplObject() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
