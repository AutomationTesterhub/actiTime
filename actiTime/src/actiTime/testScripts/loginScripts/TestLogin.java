package actiTime.testScripts.loginScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actiTime.testBase.TestBase;

public class TestLogin extends TestBase {

	@BeforeClass
public void setUp() throws IOException {
	init();
}

@Test 
public void testLogin() throws Exception{
	WebElement userName = getWebElement("actiTime.login.username");
			userName.sendKeys(Repository.getProperty("userName"));
			driverwait();
}
@AfterTest
public void testDown(){
	closeBrowser();
}
}
