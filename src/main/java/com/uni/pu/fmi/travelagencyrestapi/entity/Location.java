package com.uni.pu.fmi.travelagencyrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {
    @Id
    @Column(nullable = false, name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "street_number", nullable = false)
    private String number;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private Set<Holiday> holidays;
}
