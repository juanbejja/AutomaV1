package runner.browser_manager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	private static final String URL_GECKO = "src/test/resources/gecko_driver/geckodriver.exe";
	private static final String WD_GECKO = "webdriver.gecko.driver";

	@Override
	protected void createDriver() {
		System.setProperty(WD_GECKO, URL_GECKO);
		driver = new FirefoxDriver();
	}
}
