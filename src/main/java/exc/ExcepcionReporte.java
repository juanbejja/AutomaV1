package exc;

import com.aventstack.extentreports.Status;

import report.Reporte;

public class ExcepcionReporte extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcepcionReporte(String msg) {
		super(msg);
		Reporte.informar(Status.FAIL, msg);
	}

}
