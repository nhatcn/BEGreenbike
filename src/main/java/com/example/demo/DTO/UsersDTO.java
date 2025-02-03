package com.example.demo.DTO;

public class UsersDTO {
    private Long userId;
    private String userName;
    private String name;
    private String email;
    private String phone;
    private Boolean status;
    private String password;
    private String avatar;
    public UsersDTO() {
    }

    public UsersDTO(Long userId, String userName, String name, String email, String phone, Boolean status, String avatar) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.avatar = avatar;
    }

    public UsersDTO(Long userId, String userName, String name, String email, String phone, Boolean status, String password, String avatar) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.password = password;
        this.avatar = avatar;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}