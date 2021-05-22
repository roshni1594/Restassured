package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.io.*;
public class PutPatchDeleteExample {
	//@Test
	public void testPut() {
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		request.put("name","Roshni");
		request.put("job","Tester");
		System.out.println(request.toJSONString());
		
		given().
		header("Content-type","application/json").
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	//@Test
	public void testPatch() {
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		request.put("name","Roshni");
		request.put("job","Tester");
		System.out.println(request.toJSONString());
		
		given().
		header("Content-type","application/json").
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void testDelete() {
		baseURI="https://reqres.in/api";
		
		given().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
