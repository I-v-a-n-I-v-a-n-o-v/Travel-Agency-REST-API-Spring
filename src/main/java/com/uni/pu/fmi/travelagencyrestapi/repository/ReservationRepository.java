package com.uni.pu.fmi.travelagencyrestapi.repository;

import com.uni.pu.fmi.travelagencyrestapi.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
