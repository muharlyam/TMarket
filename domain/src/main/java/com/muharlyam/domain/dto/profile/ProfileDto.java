package com.muharlyam.domain.dto.profile;

public class ProfileDto {
    private String id;
    private String name;
    private String userPic;
    private String email;
    private String gender;
    private String locale;
    private String firstName;
    private String surname;
    private String middleName;
    private Long marketId;

    public ProfileDto() {}

    public ProfileDto(String id,
                      String name,
                      String userPic,
                      String email,
                      String gender,
                      String locale,
                      String firstName,
                      String surname,
                      String middleName,
                      Long marketId) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}
