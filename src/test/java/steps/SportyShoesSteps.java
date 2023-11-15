package steps;

import static org.hamcrest.Matchers.equalTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class SportyShoesSteps {

	@Given("listof users are registered get-users method")
	public void listof_users_are_registered_get_users_method() {
	    
		//http://localhost:9010/get-users
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/get-users")
				.when()
				.get()
				.then()
				.statusCode(200)
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		
	}

	@Given("list of products are available  get-shoes method")
	public void list_of_products_are_available_get_shoes_method() {
		
		//http://localhost:9010/get-shoes
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/get-shoes")
				.when()
				.get()
				.then()
				.statusCode(200)
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
	
	}

	@Then("add a product using post method")
	public void add_a_product_using_post_method() {
		
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/add-shoe")
				.contentType("application/json")
				.queryParam("id","1020")
				.queryParam("image", "www.imge.com")
				.queryParam("name","Nike")
				.queryParam("category", "Running")
				.queryParam("sizes","5,6,7")
				.queryParam("price", "2000")
				.when()
				.post()
				.then()
				.statusCode(200)
				.body("message",equalTo("Nike Added Successfully."))
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		
	}

	@Then("update the product details using put method")
	public void update_the_product_details_using_put_method() {
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/update-shoe")
				.queryParam("id","1020")
				.queryParam("image", "www.imge123.com")
				.queryParam("name","sketchers")
				.queryParam("category", "Running")
				.queryParam("sizes","5,6,7")
				.queryParam("price", "2500")
				.when()
				.put()
				.then()
				.statusCode(200)
				.body("message",equalTo("sketchers Updated Successfully."))
				.extract()
				.response();
	
		
		System.out.println(response.getBody().asPrettyString());
				
		
	}

	@Then("delete the product")
	public void delete_the_product() {
	   
		RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/delete-shoe")
		.queryParam("id", "1020")
		.when()
		.delete()
		.then()
		.statusCode(200);
	}
	
}
