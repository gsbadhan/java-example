package com.completefuture;

import java.util.HashMap;
import java.util.Map;

public class MoviesRepository {
	private MoviesRepository() {
	}
	//short-code:full name
	public static Map<String, String> movies=new HashMap<>(100);

	static{
		movies.put("cnj1", "conjuring part 1");
		movies.put("cnj2", "conjuring part 2");
		movies.put("bld1", "blades part 1");
		movies.put("bld2", "blades part 2");
		movies.put("snw", "snow");
		movies.put("wht", "white");
		movies.put("ert", "earth");
		movies.put("skf", "sky fall");
	}
}
