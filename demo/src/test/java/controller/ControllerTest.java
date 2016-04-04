package controller;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.hamcrest.core.StringContains;
import com.jayway.restassured.RestAssured;
import demo.SpringBootThymeleafApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootThymeleafApp.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class ControllerTest {
	
	//@Value("${local.server.port")
	//int port; // is this java 8 only? check
	// add unit tests, tests for edge cases, negative cases
	
	public void setUp() {
		RestAssured.port = 8080;
	}

	@Test
	public void testGetLocation() {
		RestAssured.given().formParams("customerID","123").
		when().post("/getLocation").then().statusCode(HttpStatus.SC_OK).body(StringContains.containsString("London"));
	}
	
	@Test
	public void testGetCatalog() {
		RestAssured.given().formParams("location","Liverpool").		
		when().post("/getCatalog").then().statusCode(HttpStatus.SC_OK).body(StringContains.containsString("LiverpoolTV"));
	}

}