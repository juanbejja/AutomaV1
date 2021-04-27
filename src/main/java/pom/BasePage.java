package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import exc.ExcepcionReporte;
import report.Reporte;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void esperarElemento(By elemento) {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(elemento));

			Reporte.informar(Status.PASS, "Se encontro el elemento: " + elemento);

		} catch (Exception e) {

			Reporte.informar(Status.WARNING, "No se encontro el elemento: " + elemento);

		}

	}

	public void elementoClickeable(By elemento) throws ExcepcionReporte {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 15);

			wait.until(ExpectedConditions.elementToBeClickable(elemento));

		} catch (Exception e) {

			throw new ExcepcionReporte("El elemento: " + elemento + " no es clickeable");

		}

	}

	public void scrollToElement(By elemento) {

		WebElement element = driver.findElement(elemento);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void click(By elemento) throws ExcepcionReporte {

		try {

			elementoClickeable(elemento);

			driver.findElement(elemento).click();

			Reporte.informar(Status.PASS, "Se hizo click en el elemento: " + elemento);

		} catch (Exception e) {

			throw new ExcepcionReporte("No se pudo clickear sobre el elemento: " + elemento);
		}
	}

	public void enviarDatos(By elemento, String dato) {
		try {

			driver.findElement(elemento).sendKeys(dato);

			Reporte.informar(Status.PASS, "Se envio el dato: " + dato + " al elemento: " + elemento);

		} catch (Exception e) {

			Reporte.informar(Status.FAIL, "No se pudo enviar el dato: " + dato + " al elemento: " + elemento);

		}
	}

	public boolean isDisplay(By elemento) throws ExcepcionReporte {

		try {

			return driver.findElement(elemento).isDisplayed();

		} catch (Exception e) {

			throw new ExcepcionReporte("No se pudo encontrar el elemento: " + elemento);

		}
	}

	public String getText(By elemento) throws ExcepcionReporte {

		try {

			return driver.findElement(elemento).getText();

		} catch (Exception e) {

			throw new ExcepcionReporte("No se pudo tomar el texto del elemento: " + elemento);

		}
	}

	public String getTitle(){
		Reporte.informar(Status.INFO, "Titulo: " + driver.getTitle());
		return driver.getTitle();
	}
}
