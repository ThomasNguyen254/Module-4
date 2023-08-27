package com.example.fixstadium.model;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "area_id",referencedColumnName = "id",unique = true)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id",unique = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "stadiumType_id",referencedColumnName = "id",unique = true)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "timeSlot_id",referencedColumnName = "id",unique = true)
    private TimeSlot timeSlot;

    public Stadium() {
    }

    public Stadium(Long id, String name, String address, Area area, Customer customer, Type type, TimeSlot timeSlot) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.area = area;
        this.customer = customer;
        this.type = type;
        this.timeSlot = timeSlot;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
