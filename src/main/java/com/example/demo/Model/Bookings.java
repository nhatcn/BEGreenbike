package com.example.demo.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tours tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bicycle_id")
    private Bicycles bicycle;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "participants")
    private Long participants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_code", nullable = false)
    private DiscountCodes discountCode;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status")
    private String status;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return user != null ? user.getUserId() : null;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getTourId() {
        return tour != null ? tour.getTourId() : null;
    }

    public void setTour(Tours tour) {
        this.tour = tour;
    }

    public Long getBicycleId() {
        return bicycle != null ? bicycle.getBicycleId() : null;
    }

    public void setBicycle(Bicycles bicycle) {
        this.bicycle = bicycle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getParticipants() {
        return participants;
    }

    public void setParticipants(Long participants) {
        this.participants = participants;
    }

    public Users getUser() {
        return user;
    }

    public Tours getTour() {
        return tour;
    }

    public Bicycles getBicycle() {
        return bicycle;
    }

    public DiscountCodes getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCodes discountCode) {
        this.discountCode = discountCode;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
