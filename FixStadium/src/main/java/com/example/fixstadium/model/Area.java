package com.example.fixstadium.model;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "area")
    private Set<Stadium> stadiumSet;

    public Area() {
    }

    public Area(Long id, String name, Set<Stadium> stadiumSet) {
        this.id = id;
        this.name = name;
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

    public Set<Stadium> getStadiumSet() {
        return stadiumSet;
    }

    public void setStadiumSet(Set<Stadium> stadiumSet) {
        this.stadiumSet = stadiumSet;
    }
}
