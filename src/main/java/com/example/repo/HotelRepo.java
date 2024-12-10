//package com.example.repo;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.model.Hotels;
//
//public interface HotelsRepo extends JpaRepository<Hotels, Long> {
//}
package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
	List<Hotel> findByPlace(String place);
}
