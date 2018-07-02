package com.twu.biblioteca;

public class User {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String userIdArg, String passwordArg, String nameArg, String emailArg, String phoneArg) {
        userId = userIdArg;
        password = passwordArg;
        name = nameArg;
        email = emailArg;
        phone = phoneArg;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isThisLogin(String potentialUserId, String potentialPassword) {
        return userId.equals(potentialUserId) && password.equals(potentialPassword);
    }

    public String getUserInfo() {
        return "User ID: " + userId + "\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone;
    }
}
