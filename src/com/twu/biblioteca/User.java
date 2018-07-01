package com.twu.biblioteca;

public class User {
    private String userId;
    private String password;

    public User(String userIdArg, String passwordArg) {
        userId = userIdArg;
        password = passwordArg;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isThisLogin(String potentialUserId, String potentialPassword) {
        return userId.equals(potentialUserId) && password.equals(potentialPassword);
    }
}
