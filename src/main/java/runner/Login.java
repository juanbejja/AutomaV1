package runner;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exc.ExcepcionReporte;
import json.JSONManager;
import report.Reporte;
import seleniumgluecode.Hooks;
import seleniumgluecode.tests.login.TC1;
import seleniumgluecode.tests.login.TC2;

public class Login {

	private Hooks hooks;

	@BeforeClass
	public void reporte() {
		Reporte.crearReporte();
	}

	@Test(dataProvider = "login")
	public void tc1(String data) throws ExcepcionReporte, InterruptedException {
		String[] datos = data.split(",");
		hooks = new Hooks(datos[3]);
		TC1 test = new TC1();
		test.ejecutar(datos[0], datos[1], datos[2], datos[3]);
	}

	@Test(dataProvider = "login")
	public void tc2(String data) throws ExcepcionReporte {
		String[] datos = data.split(",");
		hooks = new Hooks(datos[3]);
		TC2 test = new TC2();
		test.ejecutar(datos[0], datos[1], datos[2], datos[3]);
	}

	@AfterMethod
	public void teardown() {
		hooks.tearDown();
		Reporte.actualizar();
	}

	@DataProvider(name = "login")
	public String[] readJSON(Method m) throws ExcepcionReporte {
		return JSONManager.readJSON("Login", m.getName());
	}

}
