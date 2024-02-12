package com.javaexpress.hotelservice.service;

import java.util.List;

import com.javaexpress.hotelservice.entity.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(String id);
	
	

}
