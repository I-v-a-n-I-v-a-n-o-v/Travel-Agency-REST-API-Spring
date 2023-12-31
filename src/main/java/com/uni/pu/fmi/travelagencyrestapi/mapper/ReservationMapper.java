package com.uni.pu.fmi.travelagencyrestapi.mapper;

import com.uni.pu.fmi.travelagencyrestapi.dto.*;
import com.uni.pu.fmi.travelagencyrestapi.entity.Location;
import com.uni.pu.fmi.travelagencyrestapi.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ResponseReservationDTO reservationToResponseReservationDTO(Reservation reservation);
}
