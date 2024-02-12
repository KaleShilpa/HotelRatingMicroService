package com.javaexpress.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.ratingservice.entity.Rating;
import com.javaexpress.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> findRatings(){
		
		return ResponseEntity.ok(ratingService.getRatings());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> findRatingsByUserId(@PathVariable String userId){
		
		return ResponseEntity.ok(ratingService.getRatingsByUser(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> findRatingsByHotelId(@PathVariable String hotelId){
		
		return ResponseEntity.ok(ratingService.getRatingsByHotel(hotelId));
	}

}
