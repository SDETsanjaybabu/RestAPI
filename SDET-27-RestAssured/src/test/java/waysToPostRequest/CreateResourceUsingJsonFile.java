package waysToPostRequest;

import java.io.File;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResourceUsingJsonFile {
@Test
public void jsonFile()
{
	File file = new File("./file.json");
	
	given()
		.body(file)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
}
}	

