package seleniumgluecode.tests.login;

import org.junit.Assert;

import com.aventstack.extentreports.Status;

import exc.ExcepcionReporte;
import report.Reporte;
import seleniumgluecode.TestBase;

public class TC1 extends TestBase {

	public void ejecutar(String dni, String clave, String usuario, String brow) throws ExcepcionReporte, InterruptedException {
		Reporte.crearTest(getClass().getSimpleName() + " - " + brow);
		validarHomeOBP();
		ingresarDatosLogin(dni, clave, usuario);
		Thread.sleep(8000);
		validarLoginCorrecto();
	}

	private void validarHomeOBP() {
		this.login.validarElementosHome();
		Assert.assertTrue(this.login.validarTituloLogin());
		Reporte.informar(Status.PASS, "Se valido la home de prendarios correctamente");
	}

	private void ingresarDatosLogin(String dni, String clave, String usuario) throws ExcepcionReporte {
		this.login.ingresarDNI(dni);
		this.login.ingresarClave(clave);
		this.login.ingresarUsuario(usuario);
		this.login.clickBtnIngresar();
	}

	private void validarLoginCorrecto(){
		this.home.validarLogoSantander();
		Assert.assertTrue(this.home.validarTituloHome());
	}

}
