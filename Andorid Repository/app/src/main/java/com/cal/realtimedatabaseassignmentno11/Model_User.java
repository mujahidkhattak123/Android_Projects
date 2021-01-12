package com.cal.realtimedatabaseassignmentno11;

public class Model_User {

    public String name;
    public String email;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Model_User() {
    }

    public Model_User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
