package tests;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetandPostExample {

	//@Test
	public void testGet() {
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200)
			.body("data[0].first_name", equalTo("Michael"))
			.body("data.first_name",hasItems("Rachel","George","Michael"));
		
	}
	
	@Test
	public void testPost() {
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("name","raghav");
//		System.out.println(map);
		baseURI="https://reqres.in/api";
		JSONObject request=new JSONObject();
		request.put("name","Roshni");
		request.put("job","Tester");
		System.out.println(request.toJSONString());
		
		given().
		header("Content-type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
		given().
			get("/users?page=2").
		then().
			assertThat().body("data.first_name",hasItems("Roshni")).
		log().all();
	}
}
