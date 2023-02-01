package com.muharlyam.data.entity;

import androidx.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Profile {

    @Id
    private String id;
    private String name;
    private String userPic;
    @NonNull
    private String email;
    private String gender;
    private String locale;
    private String firstName;
    private String surname;
    private String middleName;
    private Long marketId;
    @Generated(hash = 71767243)
    public Profile(String id, String name, String userPic, @NonNull String email,
            String gender, String locale, String firstName, String surname,
            String middleName, Long marketId) {
        this.id = id;
        this.name = name;
        this.userPic = userPic;
        this.email = email;
        this.gender = gender;
        this.locale = locale;
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.marketId = marketId;
    }
    @Generated(hash = 782787822)
    public Profile() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserPic() {
        return this.userPic;
    }
    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getLocale() {
        return this.locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public Long getMarketId() {
        return this.marketId;
    }
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}
