package parametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameterTest {
@Test
public void pathParameter()
{
	String projId="TY_PROJ_004";
	given()
		.pathParam("projectId", projId)
	.when()
		.delete("http://localhost:8084/projects/{projectId}")
	.then()
		.log().all();
}
}
