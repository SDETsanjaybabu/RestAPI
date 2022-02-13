package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
@Test
public void updatProject()
{
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy","babu");
	jObj.put("projectName", "mission123");
	jObj.put("status", "Completed");
	jObj.put("teamSize", 10);
	
	given()
		.body(jObj)
		.contentType(ContentType.JSON)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_1002")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
}
}
