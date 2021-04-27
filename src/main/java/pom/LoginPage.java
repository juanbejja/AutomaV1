package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exc.ExcepcionReporte;

public class LoginPage extends BasePage {
	private String tituloPagina = "Online Banking Santander | Login";
	private By inputDNI = By.id("input_0");
	private By inputClave = By.id("input_1");
	private By inputUsuario = By.id("input_2");
	private By btnIngresar = By.className("btn-login");
	private By fdbNegativoHeader = By.xpath("//h2[text()=\"No hemos podido identificarte\"]");
	private By fdbNegativoIcon = By.xpath("//div[@class=\"marco-imagen feedback_negativo\"]");
	private By fdbNegativoLeyenda = By.xpath("//p[@class=\"subtitulo ng-binding ng-scope\"]");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void validarFdbNegativoHeader() {
		this.esperarElemento(fdbNegativoHeader);
	}

	public void validarFdbNegativoIcon() {
		this.esperarElemento(fdbNegativoIcon);
	}

	public void validarFdbNegativoLeyenda() {
		this.esperarElemento(fdbNegativoLeyenda);
	}

	public boolean validarTituloLogin(){
		return this.getTitle().equals(tituloPagina);
	}

	public void ingresarUsuario(String usuario) {
		this.enviarDatos(inputUsuario, usuario);
	}

	public void ingresarClave(String clave) {
		this.enviarDatos(inputClave, clave);
	}

	public void ingresarDNI(String dni) {
		this.enviarDatos(inputDNI, dni);
	}

	public void validarElementosHome() {
		this.esperarElemento(inputDNI);
		this.esperarElemento(inputClave);
		this.esperarElemento(inputUsuario);
		this.esperarElemento(btnIngresar);
	}

	public void clickBtnIngresar() throws ExcepcionReporte {
		this.click(btnIngresar);
	}

}
