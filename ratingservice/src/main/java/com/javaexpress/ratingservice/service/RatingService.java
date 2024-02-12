package com.javaexpress.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaexpress.ratingservice.entity.Rating;

@Service
public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingsByUser(String userId);
	
	List<Rating> getRatingsByHotel(String hotelId);
	
}
