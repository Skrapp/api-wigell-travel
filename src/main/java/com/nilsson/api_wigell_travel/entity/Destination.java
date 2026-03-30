package com.nilsson.api_wigell_travel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weely_rate", nullable = false)
    private double weeklyRate;

    @Column(name = "hotel_name", length = 50)
    private String hotelName;

    @Column(name = "city", nullable = false, length = 60)
    private String city;

    @Column(name = "country", nullable = false, length = 40)
    private String country;

    protected Destination() {
    }

    public Destination(double weeklyRate, String hotelName, String city, String country) {
        this.weeklyRate = weeklyRate;
        this.hotelName = hotelName;
        this.city = city;
        this.country = country;
    }

    @SuppressWarnings("unused")
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getWeeklyRate() {
        return weeklyRate;
    }

    public void setWeeklyRate(double weeklyRate) {
        this.weeklyRate = weeklyRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
