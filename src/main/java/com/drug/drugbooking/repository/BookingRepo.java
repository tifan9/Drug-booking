package com.drug.drugbooking.repository;

import com.drug.drugbooking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
