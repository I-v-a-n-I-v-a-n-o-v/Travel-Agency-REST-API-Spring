package com.uni.pu.fmi.travelagencyrestapi.controller;

import com.uni.pu.fmi.travelagencyrestapi.dto.*;
import com.uni.pu.fmi.travelagencyrestapi.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays() {
        List<ResponseHolidayDTO> allHolidays = holidayService.getAllHolidays();
        return new ResponseEntity<>(allHolidays, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseHolidayDTO> getHolidayById(@PathVariable long id){
        ResponseHolidayDTO holiday = holidayService.getHolidayById(id);
        return new ResponseEntity<>(holiday, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseHolidayDTO> createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO){
        ResponseHolidayDTO responseHolidayDTO = holidayService.createHoliday(createHolidayDTO);

        return new ResponseEntity<>(responseHolidayDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseHolidayDTO> updateHoliday(@RequestBody UpdateHolidayDTO updateHolidayDTO) {
        ResponseHolidayDTO responseHolidayDTO = holidayService.updateHoliday(updateHolidayDTO);
        return new ResponseEntity<>(responseHolidayDTO, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHolidayById(@PathVariable long id){
        holidayService.deleteHolidayById(id);
        return ResponseEntity.noContent().build();
    }

}
