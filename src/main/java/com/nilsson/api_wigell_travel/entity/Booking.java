package com.nilsson.api_wigell_travel.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = true)
    private Destination destination;

    @Column(name = "hotel_name", length = 50)
    private String hotelName;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "total_price_sek", nullable = false)
    private Double totalPriceSek;

    @Column(name = "total_price_pln", nullable = false)
    private Double totalPricePln;

    protected Booking() {
    }

    public Booking(Customer customer, Destination destination, String hotelName, LocalDate departureDate, LocalDate returnDate, Double totalPriceSek, Double totalPricePln) {
        this.customer = customer;
        this.destination = destination;
        this.hotelName = hotelName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.totalPriceSek = totalPriceSek;
        this.totalPricePln = totalPricePln;
    }

    @SuppressWarnings("unused")
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getTotalPriceSek() {
        return totalPriceSek;
    }

    public void setTotalPriceSek(Double totalPrice) {
        this.totalPriceSek = totalPrice;
    }

    public Double getTotalPricePln() {
        return totalPricePln;
    }

    public void setTotalPricePln(Double totalPricePln) {
        this.totalPricePln = totalPricePln;
    }
}
