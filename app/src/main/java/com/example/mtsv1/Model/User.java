package com.example.mtsv1.Model;

public class User {
    private String HostelId;
    private String MessNo;
    private String Name;
    private String Password;
    private String RoomNo;


    public User() {
    }

    public User(String hostelId, String messNo, String name, String password, String roomNo) {
        HostelId = hostelId;
        MessNo = messNo;
        Name = name;
        Password = password;
        RoomNo = roomNo;
    }

    public String getHostelId() {
        return HostelId;
    }

    public void setHostelId(String hostelId) {
        HostelId = hostelId;
    }

    public String getMessNo() {
        return MessNo;
    }

    public void setMessNo(String messNo) {
        MessNo = messNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }
}
