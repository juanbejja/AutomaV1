package runner.browser_manager;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {
	private static final String URL_IE = "src/test/resources/ie_driver/IEDriverServer.exe";
	private static final String WD_IE = "webdriver.ie.driver";

	@Override
	protected void createDriver() {
		System.setProperty(WD_IE, URL_IE);
		driver = new InternetExplorerDriver();
	}

}
