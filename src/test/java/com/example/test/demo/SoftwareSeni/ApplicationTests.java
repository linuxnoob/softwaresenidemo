package com.example.test.demo.SoftwareSeni;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllTranscation(){
		String endpoint = "http://localhost:8080/getAlltransactions";
		var response = given().when().get(endpoint).then();
		response.log().body();
	}

	@Test
	public void getTransactionByID(){
		String endpoint="http://localhost:8080/transaction/" ;
		var response =
				given().
						queryParam("id", 1).
						when().
						get(endpoint).
						then();
		response.log().body();
	}

}
