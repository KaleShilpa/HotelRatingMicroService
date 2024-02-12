package com.javaexpress.hotelservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.hotelservice.entity.Hotel;
import com.javaexpress.hotelservice.repo.HotelRepository;
import com.javaexpress.hotelservice.service.HotelService;
import com.javaexpress.hotelservice.service.exception.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String uuid = UUID.randomUUID().toString();
		hotel.setHotelId(uuid);
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}

	
	@Override
	public Hotel get(String id) {
				return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found on server !!"+id));
	}
	

}
