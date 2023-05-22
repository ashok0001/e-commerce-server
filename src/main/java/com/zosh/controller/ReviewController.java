package com.zosh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exception.UserException;
import com.zosh.modal.Review;
import com.zosh.modal.User;
import com.zosh.service.ReviewService;
import com.zosh.service.UserService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	private ReviewService reviewService;
	private UserService userService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService=reviewService;
		// TODO Auto-generated constructor stub
	}
	
	public ResponseEntity<Review> createReviewHandler(@RequestBody Review req,@RequestHeader("Authorization") String jwt) throws UserException{
		User user=userService.findUserProfileByJwt(jwt);
		Review review=reviewService.createReview(req, user);
		return new ResponseEntity<Review>(review,HttpStatus.ACCEPTED);
	}

}