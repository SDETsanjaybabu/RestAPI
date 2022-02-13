package practiceCRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectTest {
@Test
public void createProject()
{
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy","babu");
	jObj.put("projectName", "mission123");
	jObj.put("status", "Created");
	jObj.put("teamSize", 10);
	
	given()
		.body(jObj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
}
}
