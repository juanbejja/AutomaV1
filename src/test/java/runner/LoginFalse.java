package runner;

import java.io.IOException;
import java.lang.reflect.Method;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import json.JSONManager;
import report.Reporte;
import seleniumgluecode.Hooks;
import seleniumgluecode.tests.login.TC2;

public class LoginFalse {
	private Hooks hooks;

	@BeforeClass
	public void reporte() {
		Reporte.crearReporte();
	}

	@Test(dataProvider = "login")
	public void tc2(String data) throws Throwable {
		String datos[] = data.split(",");
		hooks = new Hooks(datos[3]);
		TC2 test = new TC2();
		test.ejecutar(datos[0], datos[1], datos[2], datos[3]);
	}

	@AfterMethod
	public void teardown() {
		hooks.tearDown();
		Reporte.extent.flush();
	}

	@DataProvider(name = "login")
	public String[] readJSON(Method m) throws IOException, ParseException {
		return JSONManager.readJSON("Login", m.getName());
	}

}
