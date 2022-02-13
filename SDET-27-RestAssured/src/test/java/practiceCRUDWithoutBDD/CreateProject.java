package practiceCRUDWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

@Test
public void createProject()
{
	//step1:create test data
	Random ran=new Random();
	int randomNumber=ran.nextInt(100);
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "sanjay");
	jObj.put("projectName", "ROBO"+randomNumber);
	jObj.put("status", "Created");
	jObj.put("teamSize", 7);
	
	//step2:provide request specification
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jObj);
	
	//step3:perform the action
	Response resp = req.post("http://localhost:8084/addProject");
	
	//step4:print in console and verify
	System.out.println("As String "+resp.asString());
	System.out.println("Preety Print "+resp.prettyPrint());
	System.out.println("Preety Peek============ "+resp.prettyPeek());
	System.out.println("Content Type "+resp.getContentType());
}
}
