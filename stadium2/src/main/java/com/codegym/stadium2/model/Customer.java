package com.example.stadium.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private int gender;
    @OneToMany(mappedBy = "customer")
    private Set<Stadium> stadiumSet;

    public Customer() {
    }

    public Customer(Long id, String name, String phoneNumber, int gender, Set<Stadium> stadiumSet) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.stadiumSet = stadiumSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Set<Stadium> getStadiumSet() {
        return stadiumSet;
    }

    public void setStadiumSet(Set<Stadium> stadiumSet) {
        this.stadiumSet = stadiumSet;
    }
}
