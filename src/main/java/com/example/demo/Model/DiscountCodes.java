package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_codes")
public class DiscountCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private String code;

    @Column(name = "discount_percent")
    private Long discountPercent;

    @Column(name = "expiration_date")
    private java.sql.Date expirationDate;

    @Column(name = "status")
    private Boolean status;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(Long discountPercent) {
        this.discountPercent = discountPercent;
    }

    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
