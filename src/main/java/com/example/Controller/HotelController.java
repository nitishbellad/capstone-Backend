//package com.example.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Hotels;
//import com.example.repo.HotelsRepo;
//
//@RestController
//@RequestMapping("/hotels")
//public class HotelsController {
//
//    @Autowired
//    HotelsRepo hotelRepo;
//
//    @GetMapping("/show")
//    public List<Hotels> showAllHotels() {
//        return hotelRepo.findAll();
//    }
//
//    @GetMapping("/show/{id}")
//    public Optional<Hotels> showHotelById(@PathVariable Long id) {
//        return hotelRepo.findById(id);
//    }
//
//    @PostMapping("/add")
//    public void addHotel(@RequestBody Hotels newHotel) {
//        hotelRepo.save(newHotel);
//    }
//
//    @PutMapping("/update/{id}")
//    public void updateHotel(@RequestBody Hotels newHotel, @PathVariable Long id) {
//        Optional<Hotels> hotelOld = hotelRepo.findById(id);
//        if (hotelOld.isPresent()) {
//            Hotels hotel = hotelOld.get();
//            hotel.setName(newHotel.getName());
//            hotel.setLocation(newHotel.getLocation());
//            hotel.setDescription(newHotel.getDescription());
//            hotel.setRating(newHotel.getRating());
//            hotelRepo.save(hotel);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteHotel(@PathVariable Long id) {
//        hotelRepo.deleteById(id);
//    }
//}

package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hotel;
import com.example.repo.HotelRepo;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "*")
public class HotelController {
    @Autowired
    HotelRepo hr;

//    @GetMapping("/show")
//    public List<Hotel> show() {
//        return hr.findAll();
//    }

    @GetMapping("/show")
    public List<Hotel> show(@RequestParam(required = false) String place) {
        if (place != null && !place.isEmpty()) {
            return hr.findByPlace(place); // Implement this method in HotelRepo
        }
        return hr.findAll();
    }
    
    @GetMapping("/readone/{id}")
    public Optional<Hotel> showone(@PathVariable long id) {
        return hr.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Hotel hotel) {
        hr.save(hotel);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Hotel h, @PathVariable long id) {
        Optional<Hotel> hotelOld = hr.findById(id);
        hotelOld.ifPresent(hotel -> {
            hotel.setImage(h.getImage());
            hotel.setImg1(h.getImg1());
            hotel.setImg2(h.getImg2());
            hotel.setImg3(h.getImg3());
            hotel.setImg4(h.getImg4());
            hotel.setRating(h.getRating());
            hotel.setRatingtext(h.getRatingtext());
            hotel.setName(h.getName());
            hotel.setPlace(h.getPlace());
            hotel.setDescription(h.getDescription());
            hotel.setAdditional(h.getAdditional());
            hotel.setPrice(h.getPrice());
            hotel.setAdditional1(h.getAdditional1());
            hr.save(hotel);
        });
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        hr.deleteById(id);
    }

   
}

