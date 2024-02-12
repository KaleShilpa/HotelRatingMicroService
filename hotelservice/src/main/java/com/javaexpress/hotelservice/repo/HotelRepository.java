package com.javaexpress.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
