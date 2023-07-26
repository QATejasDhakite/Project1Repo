package Base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentReportManager;
import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

 public class TestBase {
	
	 public ExtentReports report = ExtentReportManager.getReportInstance();
	 public ExtentTest logger;
	 
	 public static WebDriver driver;
	 public void initalization() throws Exception
	 {	
		
		 String browser = ReadData.readPropertyFile("browser");
		 if(browser.equals("chrome"))
		 { 
			 System.setProperty("webdriver.http.factory","jdk-http-client");
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
	 	 }
		 
		 else if(browser.equals("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }
		 
		 else if(browser.equals("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		 }
		  
	   	 driver.manage().window().maximize();
	   	 driver.manage().deleteAllCookies();
	   	 //Thread.sleep(3000);
	   	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   	 driver.get(ReadData.readPropertyFile("url"));
	   	 
     }
}
