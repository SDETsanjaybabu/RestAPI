package requestChaining;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndDeleteTest {
@Test
public void postAndDelete()
{
	Random ran=new Random();
	int randNumb = ran.nextInt(500);

	PojoClass pojo=new PojoClass("dev", "highlevel"+randNumb, "Created", 20);
	Response resp = given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
	
    String proID = resp.jsonPath().get("projectId");
	delete("http://localhost:8084/projects/"+proID)
		.then()
		.assertThat().statusCode(204) .contentType(ContentType.JSON)
		.log().all();
}
}