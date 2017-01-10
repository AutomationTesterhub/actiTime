package actiTime.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;

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
	public static WebElement getLocator(String locator){
		String locatorType = locator.split("_")[0];
		String locatorValue = locator.split("_")[1];
		if (locatorType.toLowerCase().equals("id"))
		return driver
		
	}
	
	
}
