package seleniumgluecode;

import org.openqa.selenium.WebDriver;

import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

public class Hooks {

	private static WebDriver driver;
	private DriverManager driverManager;
	private static final String URL_PRENDARIO = "https://www2.personas.santander.com.ar/obp-webapp/angular/#!/home";

	public Hooks(String driverType) throws Exception {

		if (driverType.equals("chrome") || driverType.equals("CHROME")) {
			driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		} else if (driverType.equals("firefox") || driverType.equals("FIREFOX")) {
			driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
		} else if (driverType.equals("internet") || driverType.equals("ie")) {
			driverManager = DriverManagerFactory.getManager(DriverType.IE);
		} else {
			throw new Exception("No se pudo identificar el tipo de browser: " + driverType);
		}

		driver = driverManager.getDriver();
		driver.get(URL_PRENDARIO);
		driver.manage().window().maximize();
	}

	public void tearDown() {
		if (getDriver() != null) {
			driverManager.quitDriver();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
