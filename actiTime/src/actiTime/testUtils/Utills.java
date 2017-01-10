package actiTime.testUtils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Utills {

	public static WebDriver driver;

	public static WebDriver selectBrowser(String browser){
		if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty
					("user.dir")+"/src/actiTime/BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.internerexplorer.driver", System.getProperty
					("use.dir")+"/src/actiTime/BrowserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}

		return null;

	}
	public void impliciteWait(int timeInsec){
		Reporter.log("Waiting for page to load......");
		try
		{
			driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
			Reporter.log("page is loaded");
		}
		catch(Throwable error)
		{ 
			System.out.println("Timeout for page Load request after "+ timeInsec + " seconds");
					Assert.assertTrue(false, "Timeout for Page load request after "+timeInsec+" second");
		}
	}
	public void driverwait() throws InterruptedException {
	Thread.sleep(30000);
	}
}