package runner.browser_manager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	private static final String URL_CHROME = "src/test/resources/chrome_driver/chromedriver.exe";
	private static final String WD_CHROME = "webdriver.chrome.driver";

	@Override
	protected void createDriver() {
		System.setProperty(WD_CHROME, URL_CHROME);
		driver = new ChromeDriver();
	}

}
