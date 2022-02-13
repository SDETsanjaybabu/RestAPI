package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2Test {
@Test
public void oauthTest()
{
	     Response response = given()
			 .formParam("client_id", "SDET-Sanjay")
			 .formParam("client_secret", "0612ed2bcf8a7dc3c94a0491750f2b12")
			 .formParam("grant_type", "client_credentials")
			 .formParam("Redirect URI", "https://example.com")
	.when()
		.post("http://coop.apps.symfonycasts.com/token");
	    String token = response.jsonPath().get("access_token");
	     
	given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "2793")
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
	.then()
		.log().all();
}
}
