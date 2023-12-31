package com.uni.pu.fmi.travelagencyrestapi.controller;

import com.uni.pu.fmi.travelagencyrestapi.dto.*;
import com.uni.pu.fmi.travelagencyrestapi.service.HolidayService;
import com.uni.pu.fmi.travelagencyrestapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseReservationDTO>> getAllReservations() {
        List<ResponseReservationDTO> reservations = reservationService.getReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseReservationDTO> getReservationByIdDTO(@PathVariable long id) {
        ResponseReservationDTO reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ResponseReservationDTO> createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        ResponseReservationDTO responseReservationDTO = reservationService.createReservation(createReservationDTO);
        return new ResponseEntity<>(responseReservationDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseReservationDTO> updateReservation(@RequestBody UpdateReservationDTO updateReservationDTO) {
        ResponseReservationDTO responseReservationDTO = reservationService.updateReservation(updateReservationDTO);
        return new ResponseEntity<>(responseReservationDTO, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLocationById(@PathVariable long id){
        reservationService.deleteReservationById(id);
        return ResponseEntity.noContent().build();
    }
}
