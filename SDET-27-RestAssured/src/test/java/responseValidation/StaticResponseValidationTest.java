package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
@Test
public void verify()
{
	String expectedProjectName="mission123";
	Response response = when()
		.get("http://localhost:8084/projects");
	String actualProjectName=response.jsonPath().getString("[1].projectName");
	
	response.then()
		.assertThat()
		.contentType(ContentType.JSON).and().statusCode(200)
		.log().all();
	
	Assert.assertEquals(expectedProjectName,actualProjectName);
}
}
