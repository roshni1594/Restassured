package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {

	@Test
	public void test_1() {
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode,200);
		
	}
	@Test
	public void test_2() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
	}
}
