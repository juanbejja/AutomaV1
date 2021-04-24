package runner.browser_manager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	
	@Override
	protected void createDriver() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/gecko_driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
}
