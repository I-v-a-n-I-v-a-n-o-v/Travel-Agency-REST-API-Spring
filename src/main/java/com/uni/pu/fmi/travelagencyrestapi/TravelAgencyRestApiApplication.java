package com.uni.pu.fmi.travelagencyrestapi;

import com.uni.pu.fmi.travelagencyrestapi.dto.CreateHolidayDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.UpdateHolidayDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.UpdateLocationDTO;
import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelAgencyRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyRestApiApplication.class, args);
    }
}
