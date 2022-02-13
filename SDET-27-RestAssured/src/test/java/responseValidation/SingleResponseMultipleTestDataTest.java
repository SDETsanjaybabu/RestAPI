package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SingleResponseMultipleTestDataTest {
@Test(dataProvider = "getData")
public void multipleResponse(String createdBy,String projectName,String status,int teamSize)
{
	PojoClass pojo=new PojoClass(createdBy, projectName, status, teamSize);
	given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArray=new Object[2][4];
		objArray[0][0]="sanjay";
		objArray[0][1]="Toyota";
		objArray[0][2]="Completed";
		objArray[0][3]=9;
		
		objArray[1][0]="babu";
		objArray[1][1]="TATA";
		objArray[1][2]="Created";
		objArray[1][3]=8;
		
		return objArray;
	}
}
