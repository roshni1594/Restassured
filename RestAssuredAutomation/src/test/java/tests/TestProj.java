package tests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.simple.JSONObject;

import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;

public class TestProj {
	
	public void testGetAccounts() {
		baseURI="https://int-essys1.lfnet.se/";
		JSONObject request=new JSONObject();
//		request.put(", request)
//		given().
//		header("Cookie","USERSESSION=").
//		body().
//		when().
//		post().
//		then().
		
	}
}
