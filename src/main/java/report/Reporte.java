package report;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import seleniumgluecode.Hooks;

public class Reporte {
	private static ExtentHtmlReporter reporter;
	private static ExtentReports extent;
	private static ExtentTest logger;

	private static final String OBP = "Online Banking Personas";
	private static final String RUTA_WINDWOS = "\\";

	private Reporte() {
	}

	public static void crearReporte() {

		if (reporter == null) {
			new File("Evidencias\\Reporte\\" + getFecha() + RUTA_WINDWOS + getHora()).mkdirs();
			reporter = new ExtentHtmlReporter(
					"Evidencias\\Reporte\\" + getFecha() + RUTA_WINDWOS + getHora() + "\\Reporte.html");

			reporter.config().setDocumentTitle(OBP);
			reporter.config().setReportName(OBP);
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setEncoding("ANSI");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			reporter.config().setTheme(Theme.DARK);
		}
	}

	private static String getHora() {
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH.mm.ss");
		return hourFormat.format(date);
	}

	private static String getFecha() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(date);
	}

	public static void crearTest(String nombreTest) {
		logger = extent.createTest(nombreTest);
	}

	public static void informar(Status status, String mensaje) {

		switch (status) {

		case PASS:
			logger.pass(mensaje);
			break;

		case FAIL:
			logger.fail(mensaje);
			break;

		case INFO:
			logger.info(mensaje);
			break;

		case WARNING:
			logger.warning(mensaje);
			break;

		default:
			logger.info(mensaje);
			break;
		}

	}

	public static void takeScreenshot(Status status, String name) {

		try {
			String direccion = "Evidencias\\Screenshoots\\" + getFecha() + RUTA_WINDWOS + getHora();

			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.scaling(1.20f))
					.takeScreenshot(Hooks.getDriver());

			new File(direccion).mkdirs();

			ImageIO.write(screenshot.getImage(), "PNG",
					new File(System.getProperty("user.dir") + RUTA_WINDWOS + direccion + RUTA_WINDWOS + name + ".png"));
			logger.log(status, name + logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + RUTA_WINDWOS + direccion + RUTA_WINDWOS + name + ".png"));

		} catch (Exception e) {
			informar(Status.FAIL, "Error al tomar screen " + e);
		}

	}

	public static void actualizar() {
		extent.flush();
	}

}