//package com.example.model;
//
//import java.util.Date;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class HotelsBooking {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Date checkInDate;
//    private Date checkOutDate;
//    private int numberOfGuests;
//    private double totalPrice;
//	public HotelsBooking() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public HotelsBooking(Long id, Date checkInDate, Date checkOutDate, int numberOfGuests, double totalPrice) {
//		super();
//		this.id = id;
//		this.checkInDate = checkInDate;
//		this.checkOutDate = checkOutDate;
//		this.numberOfGuests = numberOfGuests;
//		this.totalPrice = totalPrice;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Date getCheckInDate() {
//		return checkInDate;
//	}
//	public void setCheckInDate(Date checkInDate) {
//		this.checkInDate = checkInDate;
//	}
//	public Date getCheckOutDate() {
//		return checkOutDate;
//	}
//	public void setCheckOutDate(Date checkOutDate) {
//		this.checkOutDate = checkOutDate;
//	}
//	public int getNumberOfGuests() {
//		return numberOfGuests;
//	}
//	public void setNumberOfGuests(int numberOfGuests) {
//		this.numberOfGuests = numberOfGuests;
//	}
//	public double getTotalPrice() {
//		return totalPrice;
//	}
//	public void setTotalPrice(double totalPrice) {
//		this.totalPrice = totalPrice;
//	}
//
//    // Getters and Setters
//}

package com.example.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    
    private Long room;
    private Long adult;
    private Long child;
    private String departure;
    private String arrival;
    private Long totalamount;
    private Long savings;
    
    @ManyToOne
    //@JoinColumn(name = "user_id")
    //@JsonBackReference
    private User user;

    @ManyToOne
    //@JoinColumn(name = "hotel_id")
    //@JsonBackReference
    private Hotel hotel;


}

