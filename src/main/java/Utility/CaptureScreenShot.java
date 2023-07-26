package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import Base.TestBase;

public class CaptureScreenShot extends TestBase {

	public static String getDate() 
	{
		return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());   
	}
	
	public static void screenshot(String nameofMethod) throws Exception 
	{
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\tejas\\eclipse-workspace3\\ChannelProject\\Screenshots\\"+ nameofMethod +"---"+ getDate()+  ".jpeg");
		FileHandler.copy(source, dest);
	}
}
