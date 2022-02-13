package GenericUtility;

import java.util.Random;

/**
 * 
 * @author SanjayBabu
 *
 */
public class JavaUtility {
	/**
	 * 
	 * @return
	 */
public int getRandomNum()
{
	Random ran=new Random();
	int value = ran.nextInt(100);
	return value;
}
}
