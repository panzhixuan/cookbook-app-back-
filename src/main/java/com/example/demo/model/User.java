package com.example.demo.model;

public class User {
    private Integer userId;

    private String userEmail;

    private String userPassword;

    private Integer userTaste;

    private Integer userCuisine;

    private Integer userOccasion;

    private String userPhoto;

    private String userName;

    private String userAddress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserTaste() {
        return userTaste;
    }

    public void setUserTaste(Integer userTaste) {
        this.userTaste = userTaste;
    }

    public Integer getUserCuisine() {
        return userCuisine;
    }

    public void setUserCuisine(Integer userCuisine) {
        this.userCuisine = userCuisine;
    }

    public Integer getUserOccasion() {
        return userOccasion;
    }

    public void setUserOccasion(Integer userOccasion) {
        this.userOccasion = userOccasion;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }
}