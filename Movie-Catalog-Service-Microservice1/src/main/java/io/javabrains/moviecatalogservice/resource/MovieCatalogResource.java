package io.javabrains.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.service.MovieInfo;
import io.javabrains.moviecatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private MovieInfo movieInfo;

	@Autowired
	private UserRatingInfo UserRatingInfo;

	@RequestMapping("/{userId}")
	// @HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated movie IDs
		// List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new
		// Rating("5678", 3));

		UserRating userRatings = UserRatingInfo.getUserRating(userId);

		return userRatings.getRatings().stream()
				// for each movie ID, call movie info service and get details
				.map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());

		/*
		 * Movie movie =
		 * webClientBuilder.build().get().uri("http://localhost:8083/movies/" +
		 * rating.getMovieId()) .retrieve().bodyToMono(Movie.class).block();
		 */

	}

	/*
	 * public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String
	 * userId) { return Arrays.asList(new CatalogItem("No Movie", "", 0)); }
	 */
}
