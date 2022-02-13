package practiceCRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingleProjectTest {
@Test
public void singleProject()
{
	when()
		.get("http://localhost:8084/projects/TY_PROJ_1002")
	.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
}
}
