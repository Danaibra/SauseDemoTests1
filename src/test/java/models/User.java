package models;

import utils.TestDataReader;

public record User(String username, String password) {

    public static User getStandardUser() {
        return new User(
                TestDataReader.getProperty("user.valid.username"),
                TestDataReader.getProperty("user.valid.password")
        );
    }
}