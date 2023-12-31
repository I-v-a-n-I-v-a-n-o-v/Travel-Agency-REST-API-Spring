package com.uni.pu.fmi.travelagencyrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @Column(nullable = false, name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(targetEntity = Holiday.class)
    @JoinColumn(name = "holiday")
    private Holiday holiday;
}
