package com.example.final203;

public class Employee {
    private String name;
    private String surname;
    private String role;
    private String email;
    private String address;
    private String startDate;

    public Employee(String name, String surname, String role, String email, String address, String startDate) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.address = address;
        this.startDate = startDate;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
