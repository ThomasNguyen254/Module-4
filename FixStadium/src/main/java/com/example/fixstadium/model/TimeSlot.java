package com.example.fixstadium.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timeRange;
    private double price;

    @OneToMany(mappedBy = "timeSlot")
    private Set<Stadium> stadiumSet;

    public TimeSlot() {
    }

    public TimeSlot(Long id, String timeRange, double price, Set<Stadium> stadiumSet) {
        this.id = id;
        this.timeRange = timeRange;
        this.price = price;
        this.stadiumSet = stadiumSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Stadium> getStadiumSet() {
        return stadiumSet;
    }

    public void setStadiumSet(Set<Stadium> stadiumSet) {
        this.stadiumSet = stadiumSet;
    }
}
