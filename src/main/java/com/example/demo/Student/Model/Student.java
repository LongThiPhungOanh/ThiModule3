package com.example.demo.Student.Model;

import java.time.LocalDate;

public class Student {
    private int id;
   private String name;
    private String Email;
    private LocalDate dateOfBirth;
    private String Address;
    private String PhoneNumber;
   private ClassRom classRom;

    public Student(int id, String name, String email, LocalDate dateOfBirth, String address, String phoneNumber, ClassRom classRom) {
        this.id = id;
        this.name = name;
        this.Email = email;
        this.dateOfBirth = dateOfBirth;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.classRom = classRom;
    }

    public Student(String name, String email, LocalDate dateOfBirth, String address, String phoneNumber, ClassRom classRom) {
        this.name = name;
        this.Email = email;
        this.dateOfBirth = dateOfBirth;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.classRom = classRom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public ClassRom getClassRom() {
        return classRom;
    }

    public void setClassRom(ClassRom classRom) {
        this.classRom = classRom;
    }
}
