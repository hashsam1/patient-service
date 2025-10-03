package com.example.patient_service.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Patient ID

    private String name;
    private String email;
    private String gender;
    private int age;

    @Column(unique = true)
    private String phoneNumber;



    // Default constructor
    public Patient() {}

    // Constructor
    public Patient(String name, String phoneNumber, String gender , int age) {

        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // <-- add this
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name =name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age= age;
    }


    //**//
    public Long getPatientId() {
        return id;
    }
    public void setPatientId(Long patientId) {
        this.id=patientId;
    }
    //**///
}


