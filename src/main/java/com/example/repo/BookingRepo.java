//package com.example.repo;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.model.HotelsBooking;
//
//public interface HotelsBookingRepo extends JpaRepository<HotelsBooking, Long> {
//}
package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
	List<Booking> findByUserId(Long userId);
}


