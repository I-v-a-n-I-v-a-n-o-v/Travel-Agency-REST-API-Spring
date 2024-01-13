package com.uni.pu.fmi.travelagencyrestapi.service;

import com.uni.pu.fmi.travelagencyrestapi.dto.CreateReservationDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.ResponseReservationDTO;
import com.uni.pu.fmi.travelagencyrestapi.dto.UpdateReservationDTO;
import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import com.uni.pu.fmi.travelagencyrestapi.entity.Reservation;
import com.uni.pu.fmi.travelagencyrestapi.mapper.ReservationMapper;
import com.uni.pu.fmi.travelagencyrestapi.repository.HolidayRepository;
import com.uni.pu.fmi.travelagencyrestapi.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final HolidayRepository holidayRepository;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, HolidayRepository holidayRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.holidayRepository = holidayRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<ResponseReservationDTO> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservationMapper::reservationToResponseReservationDTO).toList();
    }

    public ResponseReservationDTO getReservationById(long id) {
        Reservation reservation = reservationRepository.getReferenceById(id);
        return reservationMapper.reservationToResponseReservationDTO(reservation);
    }

    @Transactional
    public ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setContactName(createReservationDTO.getContactName());
        reservation.setPhoneNumber(createReservationDTO.getPhoneNumber());
        Holiday holiday = holidayRepository.findById(createReservationDTO.getHolidayId()).orElseThrow();
        holiday.setFreeSlots(holiday.getFreeSlots() - 1);
        holidayRepository.save(holiday);
        reservation.setHoliday(holiday);

        reservationRepository.save(reservation);
        return reservationMapper.reservationToResponseReservationDTO(reservation);
    }

    @Transactional
    public ResponseReservationDTO updateReservation(UpdateReservationDTO updatedReservationDTO) {
        Reservation reservation = reservationRepository
                .findById(updatedReservationDTO.getId())
                .orElseThrow();
        reservation.setPhoneNumber(updatedReservationDTO.getPhoneNumber());
        reservation.setContactName(updatedReservationDTO.getContactName());
        Holiday holiday = holidayRepository
                .findById(updatedReservationDTO.getHolidayId())
                .orElseThrow();
        reservation.setHoliday(holiday);

        reservationRepository.save(reservation);
        return reservationMapper.reservationToResponseReservationDTO(reservation);
    }

    public void deleteReservationById(long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        Holiday holiday = holidayRepository.findById(reservation.getHoliday().getId()).orElseThrow();
        holiday.setFreeSlots(holiday.getFreeSlots() + 1);
        holidayRepository.save(holiday);
        reservationRepository.deleteById(id);
    }
}
