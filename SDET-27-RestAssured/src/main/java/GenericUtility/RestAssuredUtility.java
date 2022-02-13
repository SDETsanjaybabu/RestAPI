package GenericUtility;

import io.restassured.response.Response;
/**
 * 
 * @author SanjayBabu
 *
 */
public class RestAssuredUtility {
	/**
	 * this method will return the json path specified
	 * @param resp
	 * @param jsonPath
	 * @return 
	 */
	public String getJsonDta(Response resp,String jsonPath)
	{
		String jsonData=resp.jsonPath().get(jsonPath);
		return jsonData;
	}
}
