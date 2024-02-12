package com.javaexpress.userservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javaexpress.userservice.entity.Rating;
import com.javaexpress.userservice.entity.User;
import com.javaexpress.userservice.exceptions.ResourceNotFoundException;
import com.javaexpress.userservice.openfeign.HotelClient;
import com.javaexpress.userservice.openfeign.RatingClient;
import com.javaexpress.userservice.repo.UserRepository;
import com.javaexpress.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private HotelClient hotelClient;
	
	@Autowired
	private RatingClient ratingClient;
	
	@Override
	public User save(User user) {
		
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	//Using RestTemplate
/*
	@Override	
	public User getUser(String userId) {
		
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server !!"+userId));
		
		
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/"+userId, Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(r->{
			r.setHotel(restTemplate.getForObject("http://HOTELSERVICE/hotels/"+r.getHotelId(), Hotel.class));
			return r;
		}).collect(Collectors.toList());
		user.setRatings(ratings);
		return user;
	}*/
	
	//Using Feign Client
	@Override	
	public User getUser(String userId) {
		
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server !!"+userId));
		
		List<Rating> ratings = ratingClient.findRatingsByUserId(userId).getBody();
		List<Rating> ratingList = ratings.stream().map(r->{
			r.setHotel(hotelClient.get(r.getHotelId()).getBody());
			return r;
		}).collect(Collectors.toList());
		user.setRatings(ratings);
		return user;
	}

}
