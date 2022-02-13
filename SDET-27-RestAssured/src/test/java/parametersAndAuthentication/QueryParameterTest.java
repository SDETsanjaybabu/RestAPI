package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
@Test
public void queryParameter()
{
	given()
		.queryParam("page", 2)
	.when()
		.get("https://reqres.in/api/users")
	.then()
		.assertThat().statusCode(200)
		.log().all();
}
}
