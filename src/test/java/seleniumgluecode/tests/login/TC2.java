package seleniumgluecode.tests.login;

import java.io.IOException;

import org.junit.Assert;

import com.aventstack.extentreports.Status;

import report.Reporte;
import seleniumgluecode.TestBase;

public class TC2 extends TestBase {

	public void ejecutar(String dni, String clave, String usuario, String brow) throws Throwable {

		Reporte.crearTest(getClass().getSimpleName() + " - " + brow);

		validarHomeOBP();
		ingresarDatosLogin(dni, clave, usuario);
		validarFeedbackNegativo();
	}

	private void validarHomeOBP() throws Exception {
		this.login.validarElementosHome();
		Assert.assertTrue(this.login.validarTituloLogin());
		System.out.println("Se valido la home de prendarios correctamente");
	}

	private void ingresarDatosLogin(String dni, String clave, String usuario) throws Exception {
		this.login.ingresarDNI(dni);
		this.login.ingresarClave(clave);
		this.login.ingresarUsuario(usuario);
		this.login.clickBtnIngresar();
	}

	private void validarFeedbackNegativo() throws IOException {
		this.login.validarFdbNegativoHeader();
		this.login.validarFdbNegativoLeyenda();
		this.login.validarFdbNegativoIcon();
		Reporte.takeScreenshot(Status.PASS, "pantallaLogin");
		//coment

	}

}