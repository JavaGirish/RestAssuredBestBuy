package com.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class categoriesAPITest {

	// @Test
	public void getAllCategoriesTest() {

		given()

				.when().get("http://localhost:3030/categories")

				.then().statusCode(200).log().body();
		

	}

	@Test(priority=1)
	public void createNewcategory() {
		HashMap<String, String> category = new HashMap<String, String>();
		category.put("id", "abcat0105452");
		category.put("name", "Sports Shoes Men");

		given().contentType("application/json").body(category)

				.when().post("http://localhost:3030/categories")

				.then().statusCode(201).log().body().body("id", equalTo("abcat0105452"))
				.body("name", equalTo("Sports Shoes Men"));
		System.out.println("New Product created successfully");
		System.out.println("*************************************************");

	}

	@Test(priority=2)
	public void getNewCategory() {
		given()

				.when().get("http://localhost:3030/categories/abcat0105452")

				.then().statusCode(200)
				.log().body()
				.body("id", equalTo("abcat0105452")).body("name", equalTo("Sports Shoes Men"));
				System.out.println("New Product fetched");
				System.out.println("*************************************************");

	}

	@Test(priority=3)
	public void updateNewCategory() {
		HashMap<String, String> update = new HashMap<String, String>();
		update.put("id", "abcat0105452");
		update.put("name", "asics gel contend 4");

		given().contentType("application/json").body(update)

				.when().patch("http://localhost:3030/categories/abcat0105452")

				.then().statusCode(201).log().body().body("name", equalTo("asics gel contend 4"));
				System.out.println("new product details updated");
				System.out.println("*************************************************");

	}
	
	
	@Test(priority=4)
	public void deleteNewProduct() {
		given()
		
		.when().delete("http://localhost:3030/categories/abcat0105452")
		
		.then().statusCode(200)
		.body("id", equalTo("abcat0105452"));
		System.out.println("Product deleted successfully");
		System.out.println("*********************************************************");
		
		
	}
	
	

}
