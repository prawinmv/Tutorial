package com.qa.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC01_GET_Request {
  @Test
	public void test1SyntaxValidation() {
			
			given().
			when().
			get("http://ergast.com/api/f1/2017/circuits.json").
			then().
			assertThat().
			body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));	
			
		}
		
	@Test()
	public void test2technicalResponseValidations() {
			
			given().
			when().
			get("http://ergast.com/api/f1/2017/circuits.json").
			then().
			assertThat().
				statusCode(200).
			and().
				contentType(ContentType.JSON).
			and().
				header("Content-Length",equalTo("4551"));
			
			
		}
		
}
