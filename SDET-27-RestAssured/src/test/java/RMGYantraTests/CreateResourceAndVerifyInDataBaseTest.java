package RMGYantraTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;

public class CreateResourceAndVerifyInDataBaseTest extends BaseAPIClass {
	
	@Test
	public void createResourceAndverifyInDB() throws Throwable
	{
	//step1: create test data
			PojoClass pLib = new PojoClass("sanjaybabu" , "jathre"+jLib.getRandomNum(), "Created", 20);
			
	//step2:execute post request
	 Response resp = given()
					.body(pLib)
					.contentType(ContentType.JSON)
					.when()
					.post(EndPoints.createProject);
	 
	 //step3: capture the project from response
	 String expData = rLib.getJsonDta(resp, "projectId");
	 
	 //step 4:verify in db
	 String query = "select * from project;";
	 String actData = dLib.executeQueryAndGetData(query, 1, expData);
	 Reporter.log(actData,true);
		
		//step 5: validate
		
	Assert.assertEquals(expData, actData);
	Reporter.log("data verification successful", true);
	
		}
}