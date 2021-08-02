package com.home.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import io.restassured.response.Response;

public class ELKUtils {

	private ELKUtils() {
	}

	public static void postResultsToELK(String testcasename, String status) {

		
		Map<String, String> map = new HashMap<>();		
		map.put("status", status);
		map.put("module", "practice");
		map.put("author", "shashi");
		map.put("testname", testcasename);
		map.put("executiontime", LocalDateTime.now().toString());

		Response response = given().header("Content-type", "application/json")
				.log().all()
				.body(map)
				.post("http://localhost:9200/regression/results");

		Assert.assertEquals(response.getStatusCode(), 201);
		response.prettyPrint();
	}

}
