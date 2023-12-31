package com.uni.pu.fmi.travelagencyrestapi.repository;

import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
