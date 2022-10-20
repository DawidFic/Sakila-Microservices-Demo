package com.Sakila_Microservices;

import javax.persistence.*;

@Entity
@Table(name="Country")

public class Country {
    //Attributes//
    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int countryID;

    @Column(name="country")
    String countryName;

    //Constructors//
    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country(){}

    //Methods
    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
