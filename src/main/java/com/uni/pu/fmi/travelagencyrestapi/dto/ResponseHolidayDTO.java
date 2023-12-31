package com.uni.pu.fmi.travelagencyrestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseHolidayDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("startDate")
    private LocalDate startDate;
    @JsonProperty("duration")
    private int duration;
    @JsonProperty("price")
    private String price;
    @JsonProperty("freeSlots")
    private int freeSlots;
    @JsonProperty("location")
    private ResponseLocationDTO location;
}
