package com.handy.demo.distribute.weba.domain;

/**
 * @author longhairen
 * @create 2017/9/8 0008 下午 5:41
 */
public class Address {
    private int id;
    private int userId;
    private String addressName;
    private String notes;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
