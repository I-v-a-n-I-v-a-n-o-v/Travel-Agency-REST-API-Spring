package com.uni.pu.fmi.travelagencyrestapi.mapper;

import com.uni.pu.fmi.travelagencyrestapi.dto.ResponseHolidayDTO;
import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HolidayMapper {
    ResponseHolidayDTO holidayToResponseHolidayDTO(Holiday holiday);
}
