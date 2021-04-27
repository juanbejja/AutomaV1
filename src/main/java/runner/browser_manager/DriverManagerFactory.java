package runner.browser_manager;

import com.aventstack.extentreports.Status;

import report.Reporte;

public class DriverManagerFactory {

	private DriverManagerFactory() {
	}

	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager = null;

		switch (type) {
		case CHROME:

			driverManager = new ChromeDriverManager();
			break;

		case FIREFOX:

			driverManager = new FirefoxDriverManager();
			break;

		case IE:

			driverManager = new IEDriverManager();
			break;

		default:
			Reporte.informar(Status.ERROR, "BROWSER INVALIDO");
			break;

		}

		return driverManager;

	}

}
