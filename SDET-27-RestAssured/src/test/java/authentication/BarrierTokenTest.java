package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarrierTokenTest {
@Test
public void barrierToken()
{
	given()
		.auth().oauth2("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")
	.when()
		.get("https://api.github.com/user/repos")
	.then()
		.assertThat().statusCode(200)
		.log().all();
}
}
