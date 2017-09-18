package com.completefuture;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class BookMovieTicket {

	public List<String> getMovieList(final String name) {
		final List<String> moviesMatched = new LinkedList<>();
		MoviesRepository.movies.values().forEach(entry -> {
			if (entry.contains(name))
				moviesMatched.add(entry);
		});
		return moviesMatched.isEmpty() ? Collections.emptyList() : moviesMatched;
	}

	public boolean isTimeSlotAvailble(final String movie, final String cinemaName, Date dateTime) {
		if (movie == null || cinemaName == null)
			return false;
		return System.currentTimeMillis() > dateTime.getTime();
	}

	public Integer getPrice(final String movieName) {
		if (movieName == null)
			return 0;
		return Math.abs(new Random().nextInt() % 16);
	}

	public Map<Integer, String> comparePrice(String movieA, Integer priceA, String movieB, Integer priceB) {
		Map<Integer, String> priceMap = new TreeMap<>();
		priceMap.put(priceA, movieA);
		priceMap.put(priceB, movieB);
		return priceMap;
	}
}
