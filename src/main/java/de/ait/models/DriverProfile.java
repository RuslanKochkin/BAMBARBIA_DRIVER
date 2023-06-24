package de.ait.models;
import java.util.List;

public class DriverProfile {
    private String nickname;
    private String password;
    public DriverProfile(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Name: "+ nickname +" = password: "+ password;
    }
}
