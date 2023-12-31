package com.uni.pu.fmi.travelagencyrestapi.repository;

import com.uni.pu.fmi.travelagencyrestapi.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
