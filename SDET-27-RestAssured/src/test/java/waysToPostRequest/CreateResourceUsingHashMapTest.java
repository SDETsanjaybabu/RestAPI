package waysToPostRequest;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResourceUsingHashMapTest {
@Test
public void usingHashMap()
{
	HashMap map=new HashMap();
	map.put("createdBy", "mohan");
	map.put("projectName", "car");
	map.put("status", "Created");
	map.put("teamSize", 23);
	
	given()
		.body(map)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
}
}