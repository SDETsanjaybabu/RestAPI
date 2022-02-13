package practiceCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteProject {
@Test
public void delProject()
{
	//step1:
	int expStatus=204;
	Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
	
	//step2:
	int actStatus = resp.getStatusCode();
	Assert.assertEquals(expStatus, actStatus);
	System.out.println(resp.prettyPrint());
}
}
