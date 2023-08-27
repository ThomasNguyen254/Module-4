package com.example.stadium.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StadiumType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String peopleAmount;

    @OneToMany(mappedBy = "stadiumType")
    private Set<Stadium> stadiumSet;

    public StadiumType() {
    }

    public StadiumType(Long id, String peopleAmount, Set<Stadium> stadiumSet) {
        this.id = id;
        this.peopleAmount = peopleAmount;
        this.stadiumSet = stadiumSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(String peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public Set<Stadium> getStadiumSet() {
        return stadiumSet;
    }

    public void setStadiumSet(Set<Stadium> stadiumSet) {
        this.stadiumSet = stadiumSet;
    }
}
