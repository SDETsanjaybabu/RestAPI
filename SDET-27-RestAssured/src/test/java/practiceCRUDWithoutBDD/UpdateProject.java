package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
@Test
public void updateProject()
{
	//step1:create test data
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "sanjay");
	jObj.put("projectName", "ROBO");
	jObj.put("status", "Completed");
	jObj.put("teamSize", 7);
	
	//step2:
    RequestSpecification req = RestAssured.given();
    req.contentType(ContentType.JSON);
    req.body(jObj);
    
    //step3
    Response resp = req.put("http://localhost:8084/projects/TY_PROJ_802");
    
    //step4
    ValidatableResponse validate = resp.then();
    validate.assertThat().statusCode(200);
    validate.log().all();
}
}