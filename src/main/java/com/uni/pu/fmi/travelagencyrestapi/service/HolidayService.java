package com.uni.pu.fmi.travelagencyrestapi.service;

import com.uni.pu.fmi.travelagencyrestapi.dto.CreateHolidayDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.ResponseHolidayDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.UpdateHolidayDTO;
import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import com.uni.pu.fmi.travelagencyrestapi.entity.Location;
import com.uni.pu.fmi.travelagencyrestapi.mapper.HolidayMapper;
import com.uni.pu.fmi.travelagencyrestapi.repository.HolidayRepository;
import com.uni.pu.fmi.travelagencyrestapi.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;
    private final HolidayMapper holidayMapper;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository, LocationRepository locationRepository, HolidayMapper holidayMapper) {
        this.holidayRepository = holidayRepository;
        this.locationRepository = locationRepository;
        this.holidayMapper = holidayMapper;
    }

    public List<ResponseHolidayDTO> getAllHolidays() {
        List<Holiday> holiday = holidayRepository.findAll();
        return holiday.stream().map(holidayMapper::holidayToResponseHolidayDTO).toList();
    }

    public ResponseHolidayDTO getHolidayById(long id) {
        Holiday holiday = holidayRepository.getReferenceById(id);
        return holidayMapper.holidayToResponseHolidayDTO(holiday);
    }

    @Transactional
    public ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO) {
        Holiday holiday = new Holiday();
        holiday.setTitle(createHolidayDTO.getTitle());
        holiday.setPrice(createHolidayDTO.getPrice());
        holiday.setFreeSlots(createHolidayDTO.getFreeSlots());
        Location location = locationRepository
                .findById(createHolidayDTO.getLocationId())
                .orElseThrow();
        holiday.setLocation(location);
        holiday.setDuration(createHolidayDTO.getDuration());
        holiday.setStartDate(createHolidayDTO.getStartDate());

        holidayRepository.save(holiday);
        return holidayMapper.holidayToResponseHolidayDTO(holiday);
    }

    @Transactional
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO) {
        Holiday holiday = holidayRepository.findById(updateHolidayDTO.getId()).orElseThrow();
        holiday.setStartDate(updateHolidayDTO.getStartDate());
        holiday.setFreeSlots(updateHolidayDTO.getFreeSlots());
        holiday.setDuration(updateHolidayDTO.getDuration());
        holiday.setPrice(updateHolidayDTO.getPrice());
        holiday.setTitle(updateHolidayDTO.getTitle());
        holiday.setStartDate(updateHolidayDTO.getStartDate());
        holiday.setFreeSlots(updateHolidayDTO.getFreeSlots());
        holiday.setLocation(locationRepository.findById(updateHolidayDTO.getLocationId()).orElseThrow());

        holidayRepository.save(holiday);
        return holidayMapper.holidayToResponseHolidayDTO(holiday);
    }

    public void deleteHolidayById(long id) {
        holidayRepository.deleteById(id);
    }
}
