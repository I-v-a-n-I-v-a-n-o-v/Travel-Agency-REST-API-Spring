package com.uni.pu.fmi.travelagencyrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "holiday")
@Getter
@Setter
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "free_slots", nullable = false)
    private int freeSlots;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "location")
    private Location location;

}
