package com.example.final203;

import java.util.List;

import retrofit2.Call;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String department;
    private double salary;
    private String startDate;
    private int leaves;

    public Employee() {

    }
    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getLeaves() {
        return leaves;
    }

    public void setLeaves(int leaves) {
        this.leaves = leaves;
    }

    public Call<List<Employee>> getAllEmployees() {
        return null;
    }

    public char[] name() {
        return new char[0];
    }
}