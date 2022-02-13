package waysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJsonObjectTest {
@Test
public void CreateResourece()
{
	JSONObject jnOj = new JSONObject();
	jnOj.put("createdBy", "sanjay");
	jnOj.put("projectName", "ariya");
	jnOj.put("status", "Created");
	jnOj.put("teamSize", 11);
	
	given()
		.body(jnOj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
}
}
