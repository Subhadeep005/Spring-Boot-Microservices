package io.javabrains.movieratingdataservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieratingdataservice.models.Rating;
import io.javabrains.movieratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {

		return new Rating(movieId, 4);
	}

	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {

		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
	}
}
