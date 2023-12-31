package com.uni.pu.fmi.travelagencyrestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import com.uni.pu.fmi.travelagencyrestapi.entity.Location;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateReservationDTO {
    @JsonProperty("contactName")
    private String contactName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("holiday")
    private long holidayId;
}
