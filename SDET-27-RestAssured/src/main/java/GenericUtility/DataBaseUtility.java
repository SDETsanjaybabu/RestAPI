package GenericUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author SanjayBabu
 *
 */
public class DataBaseUtility {
	Connection con = null;
	 /**
     * this method will establish connection with database
     * @throws Throwable
     */
	public void connectToDB() throws Throwable {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUsername, IConstants.dbPassword);

	}
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
				flag = true;//rising flag
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "Data verified");
			return expData;
		}
		else
		{
			System.out.println("data not present");
			return "";
		}	
	}
	/**
	 * this method will close the database
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
}
}
