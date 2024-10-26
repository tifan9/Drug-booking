package com.drug.drugbooking.service;

import com.drug.drugbooking.domain.Booking;
import com.drug.drugbooking.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingService {
    @Autowired
    private BookingRepo bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public boolean deleteBooking(int id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true; // Booking deleted successfully
        } else {
            return false; // Booking not found
        }
    }
}
