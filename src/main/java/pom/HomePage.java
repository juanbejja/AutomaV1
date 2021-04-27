package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exc.ExcepcionReporte;

public class HomePage extends BasePage {
	private String tituloPagina = "Online Banking Santander | Home";
	private By logoSantander = By.xpath("//div[@class=\"logo-container\"]");
	private By btnMenu = By.id("menubtn");
	
	

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean validarTituloHome() {
		return this.getTitle().equals(tituloPagina);
	}
	
	public void clickBtnMenu() throws ExcepcionReporte  {
		this.click(btnMenu);
	}
	
	public void validarLogoSantander() {
		this.esperarElemento(logoSantander);
	}
}
