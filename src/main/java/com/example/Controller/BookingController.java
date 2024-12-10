//package com.example.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.HotelsBooking;
//import com.example.repo.HotelsBookingRepo;
//
//@RestController
//@RequestMapping("/hotel-bookings")
//public class HotelsBookingcontroller {
//
//    @Autowired
//    HotelsBookingRepo hotelBookingRepo;
//
//    @GetMapping("/show")
//    public List<HotelsBooking> showAllBookings() {
//        return hotelBookingRepo.findAll();
//    }
//
//    @GetMapping("/show/{id}")
//    public Optional<HotelsBooking> showBookingById(@PathVariable Long id) {
//        return hotelBookingRepo.findById(id);
//    }
//
//    @PostMapping("/add")
//    public void addBooking(@RequestBody HotelsBooking newBooking) {
//        hotelBookingRepo.save(newBooking);
//    }
//
//    @PutMapping("/update/{id}")
//    public void updateBooking(@RequestBody HotelsBooking newBooking, @PathVariable Long id) {
//        Optional<HotelsBooking> bookingOld = hotelBookingRepo.findById(id);
//        if (bookingOld.isPresent()) {
//            HotelsBooking booking = bookingOld.get();
//            booking.setCheckInDate(newBooking.getCheckInDate());
//            booking.setCheckOutDate(newBooking.getCheckOutDate());
//            booking.setNumberOfGuests(newBooking.getNumberOfGuests());
//            booking.setTotalPrice(newBooking.getTotalPrice());
//            hotelBookingRepo.save(booking);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteBooking(@PathVariable Long id) {
//        hotelBookingRepo.deleteById(id);
//    }
//}

package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Booking;
import com.example.repo.BookingRepo;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingRepo bookingRepo;

    @GetMapping("/show")
    public ResponseEntity<List<Booking>> show() {
        List<Booking> bookings = bookingRepo.findAll();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/readone/{id}")
    public ResponseEntity<Booking> showone(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepo.findById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Booking> add(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepo.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> update(@RequestBody Booking newBooking, @PathVariable Long id) {
        Optional<Booking> existingBookingOpt = bookingRepo.findById(id);
        if (existingBookingOpt.isPresent()) {
            Booking existingBooking = existingBookingOpt.get();
            existingBooking.setRoom(newBooking.getRoom());
            existingBooking.setAdult(newBooking.getAdult());
            existingBooking.setChild(newBooking.getChild());
            existingBooking.setDeparture(newBooking.getDeparture());
            existingBooking.setArrival(newBooking.getArrival());
            existingBooking.setTotalamount(newBooking.getTotalamount());
            existingBooking.setSavings(newBooking.getSavings());
            Booking updatedBooking = bookingRepo.save(existingBooking);
            return ResponseEntity.ok(updatedBooking);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingRepo.findByUserId(userId);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepo.save(booking);
        return ResponseEntity.ok(savedBooking);
    }
}

