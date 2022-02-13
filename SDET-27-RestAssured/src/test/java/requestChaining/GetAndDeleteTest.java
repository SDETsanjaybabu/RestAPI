package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndDeleteTest {
@Test
public void rqtChaining()
{
	Response response = when()
		.get("http://localhost:8084/projects");
	String projId = response.jsonPath().get("[0].projectId");
	System.out.println(projId);
	
	given()
		.pathParam("projectId", projId)
	.when()
		.delete("http://localhost:8084/projects/{projectId}")
	.then()
		.assertThat().statusCode(204)
		.log().all();
}
}
