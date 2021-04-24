package runner.browser_manager;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.ie.driver", "src/test/resources/ie_driver/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

}
