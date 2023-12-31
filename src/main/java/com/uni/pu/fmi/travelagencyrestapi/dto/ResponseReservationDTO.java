package com.uni.pu.fmi.travelagencyrestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseReservationDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("contactName")
    private String contactName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("holiday")
    private ResponseHolidayDTO holiday;
}
