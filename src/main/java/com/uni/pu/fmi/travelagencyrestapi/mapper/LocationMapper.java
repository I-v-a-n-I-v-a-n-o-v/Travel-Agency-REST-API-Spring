package com.uni.pu.fmi.travelagencyrestapi.mapper;

import com.uni.pu.fmi.travelagencyrestapi.dto.CreateLocationDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.ResponseLocationDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.UpdateLocationDTO;
import com.uni.pu.fmi.travelagencyrestapi.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    ResponseLocationDTO locationToResponseLocationDTO(Location location);
}
