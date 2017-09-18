package com.completefuture;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Test {
	private BookMovieTicket bookMovieTickets = new BookMovieTicket();

	// use case: simple testing
	@org.junit.Test
	public void test() throws Exception {
		CompletableFuture<String> helloCompletableFuture = CompletableFuture.completedFuture("say hello !!");
		String result = helloCompletableFuture.get();

		System.out.println("result:" + result);
	}

	// use case: search movies from repository
	@org.junit.Test
	public void testSupplyAsync() throws Exception {
		String movieName = "conjuring";
		CompletableFuture<List<String>> completableFuture = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieName));

		List<String> movies = completableFuture.get();

		System.out.println("movies found for name[" + movieName + "]:" + movies);
	}

	// use case: find movie and time slots
	@org.junit.Test
	public void testThenAplly() throws Exception {
		String movieName = "snow";

		// find movie
		CompletableFuture<List<String>> searchMovie = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieName));

		CompletableFuture<String> selectedMovie = searchMovie.thenApply(movies -> {
			if (!movies.isEmpty()) {
				return movies.get(0);
			} else {
				return null;
			}
		});

		// check availability
		CompletableFuture<Boolean> isMovieSlotAvailble = selectedMovie.thenApply(movie -> bookMovieTickets
				.isTimeSlotAvailble(movie, "PVR", new Date(System.currentTimeMillis() - 1000)));
		boolean finalYesOrNo = isMovieSlotAvailble.get();

		System.out.println("is movie slot available:" + finalYesOrNo);
	}

	// use case: find movie and time slots
	@org.junit.Test
	public void testThenApllyChain() throws Exception {
		String movieName = "snow";

		CompletableFuture<Boolean> isMovieSlotAvailble = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieName)).thenApply(movies -> {
					return movies.get(0);
				}).thenApply(movie -> bookMovieTickets.isTimeSlotAvailble(movie, "PVR",
						new Date(System.currentTimeMillis() - 1000)));

		boolean finalYesOrNo = isMovieSlotAvailble.get();
		System.out.println("is movie slot available:" + finalYesOrNo);
	}

	// use case: compare price b/w movies
	@org.junit.Test
	public void testThenCombine() throws Exception {
		String movieA = "snow";
		String movieB = "white";

		CompletableFuture<Integer> movieAFuture = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getPrice(movieA));
		CompletableFuture<Integer> movieBFuture = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getPrice(movieB));

		CompletableFuture<Map<Integer, String>> compareFuture = movieAFuture.thenCombine(movieBFuture,
				(Integer priceA, Integer priceB) -> bookMovieTickets.comparePrice(movieA, priceA, movieB, priceB));

		Map<Integer, String> sortedPrice = compareFuture.get();

		System.out.println("sorted by price:" + sortedPrice);
	}

	// use case: expecting atleast one result from multiple futures
	@org.junit.Test
	public void testAnyOf() throws Exception {
		String movieNameA = "conjuring";
		String movieNameB = "snow";
		String movieNameC = "white";
		CompletableFuture<List<String>> completableFutureA = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieNameA));
		CompletableFuture<List<String>> completableFutureB = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieNameB));
		CompletableFuture<List<String>> completableFutureC = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieNameC));

		List<String> movies = (List<String>) CompletableFuture
				.anyOf(completableFutureA, completableFutureB, completableFutureC).get();

		System.out.println("any movie:" + movies);
	}

	// use case: expecting all results from all futures
	@org.junit.Test
	public void testAllOf() throws Exception {
		String movieNameA = "conjuring";
		String movieNameB = "snow";
		String movieNameC = "white";
		CompletableFuture<List<String>> completableFutureA = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieNameA));
		CompletableFuture<List<String>> completableFutureB = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieNameB));
		CompletableFuture<List<String>> completableFutureC = CompletableFuture
				.supplyAsync(() -> bookMovieTickets.getMovieList(movieNameC));

		CompletableFuture.allOf(completableFutureA, completableFutureB, completableFutureC);

		System.out.println("A:" + completableFutureA.get());
		System.out.println("B:" + completableFutureB.get());
		System.out.println("C:" + completableFutureC.get());
	}

}
