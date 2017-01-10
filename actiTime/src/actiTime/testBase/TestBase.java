package actiTime.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import actiTime.testUtils.Utills;

public class TestBase extends Utills{

	public Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	
	public void init() throws IOException{
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		impliciteWait(30);
		driver.get(Repository.getProperty("url"));
		
	}

	private void loadPropertiesFile() throws IOException {
		f = new File(System.getProperty("user.dir")+"/actiTime/src/actiTime/config/config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"/actiTime/src/actiTime/pageLocators/loginPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"/actiTime/src/actiTime/pageLocators/reportsPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"/actiTime/src/actiTime/pageLocators/tasksPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"/actiTime/src/actiTime/pageLocators/timeTracksPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"/actiTime/src/actiTime/pageLocators/usersPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
	}
	public static WebElement getLocator(String locator) throws Exception{
		String locatorType = locator.split("_")[0];
		String locatorValue = locator.split("_")[1];
		if (locatorType.toLowerCase().equals("id"))
		return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorType));
		else if( (locatorType.toLowerCase().equals("classname"))
			||(locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorType));
		
		else if ((locatorType.toLowerCase().equals("tagname"))
			||(locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.tagName(locatorType));
		
		else if (locatorType.toLowerCase().equals("linktext")
			||(locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorType));
		
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorType));
		
		else if( (locatorType.toLowerCase().equals("cssselector"))
			||(locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorType));
		
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorType));
		else 
			throw new Exception("Unknow eliment locator type " + locatorType);		
	}
	public WebElement geWebElement(String locator) throws Exception{
	return getLocator(Repository.getProperty(locator));
	}
	
	public void closeBrowser(){
		driver.quit();
	}
}
