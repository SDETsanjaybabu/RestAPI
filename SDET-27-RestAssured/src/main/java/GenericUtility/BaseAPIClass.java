package GenericUtility;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author SanjayBabu
 *
 */
public class BaseAPIClass {
	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	
	{
		baseURI = "http://localhost";
		port = 8084;
		
		dLib.connectToDB();
		System.out.println("=====database connection established");
	}
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("======database connection closed");
	}

}
