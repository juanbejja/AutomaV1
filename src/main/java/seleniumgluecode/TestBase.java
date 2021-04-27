package seleniumgluecode;

import org.openqa.selenium.WebDriver;

import pom.HomePage;
import pom.LoginPage;

public class TestBase {
	protected WebDriver driver = Hooks.getDriver();
	protected LoginPage login = new LoginPage(driver);
	protected HomePage home = new HomePage(driver);
}
