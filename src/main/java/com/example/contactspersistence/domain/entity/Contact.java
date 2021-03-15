package com.example.contactspersistence.domain.entity;

import javax.persistence.*;

@Entity
public class Contact {
    // todo : something going on with id - goes 1, 2, -45, -46..
    @Id
    @SequenceGenerator(name = "contact_seq", sequenceName = "contact_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String occupation;
    private String phoneNumber;
    private String emailAddress;
    // internal data we don't want to expose
    // random data points for demo
    private String dateOfBirth;
    private Long salary;
    private Long age;
    private String employeeId;

    public Contact(String firstName, String lastName, String occupation, String phoneNumber, String emailAddress, String dateOfBirth, Long salary, Long age, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.age = age;
        this.employeeId = employeeId;
    }

    public Contact() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
