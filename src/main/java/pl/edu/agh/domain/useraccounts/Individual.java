package pl.edu.agh.domain.useraccounts;


import pl.edu.agh.domain.common.implementation.BaseObject;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-05-30.
 */
public class Individual extends BaseObject {

    public enum Gender {
        MALE,
        FEMALE
    }

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    private String description;
    private String facebookAccountUrl;
    private String city;
    private String country;

    public Individual() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebookAccountUrl() {
        return facebookAccountUrl;
    }

    public void setFacebookAccountUrl(String facebookAccountUrl) {
        this.facebookAccountUrl = facebookAccountUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
