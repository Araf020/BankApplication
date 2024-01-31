package src.arafat.model;

import java.util.Date;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String nationalIdNo;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;

    public Long getId() {
        return id;
    }
    public User setId(Long id) {
        this.id = id;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public User setNationalIdNo(String nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
        return this;
    }
   


    
    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    public User setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNationalIdNo() {
        return nationalIdNo;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    

}
