package com.Sakila_Microservices;

import javax.persistence.*;

@Entity
@Table(name="City")

public class City {
    //Attributes//
    @Id
    @Column(name="city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cityID;

    @Column(name="city")
    String cityName;

    @Column(name="country_id")
    String cityCountryID;

    //Constructors//
    public City(String cityName, String cityCountryID) {
        this.cityName = cityName;
        this.cityCountryID = cityCountryID;
    }

    public City(){}

    //Methods//
    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCountryID() {
        return cityCountryID;
    }

    public void setCityCountryID(String cityCountryID) {
        this.cityCountryID = cityCountryID;
    }
}
