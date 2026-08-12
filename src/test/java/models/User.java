package models;

import utils.TestDataReader;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User getStandardUser() {
        return new User(
                TestDataReader.getProperty("user.valid.username"),
                TestDataReader.getProperty("user.valid.password")
        );
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}