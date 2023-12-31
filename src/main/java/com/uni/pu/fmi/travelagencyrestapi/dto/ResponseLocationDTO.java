package com.uni.pu.fmi.travelagencyrestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseLocationDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private String number;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("imageUrl")
    private String imageUrl = null;
}
