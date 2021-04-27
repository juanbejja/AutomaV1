package json;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import exc.ExcepcionReporte;

public class JSONManager {
	
	private JSONManager(){
	}

	public static String[] readJSON(String json, String object) throws ExcepcionReporte {
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader("data//" + json + ".json");

			Object obj = jsonParser.parse(reader);

			JSONObject userLoginsJSONobj = (JSONObject) obj;

			JSONArray userLoginsArray = (JSONArray) userLoginsJSONobj.get(object);

			String[] arr = new String[userLoginsArray.size()];

			for (int i = 0; i < userLoginsArray.size(); i++) {
				JSONObject users = (JSONObject) userLoginsArray.get(i);
				String dni = (String) users.get("dni");
				String clave = (String) users.get("clave");
				String usuario = (String) users.get("usuario");
				String browser = (String) users.get("browser");

				arr[i] = dni + "," + clave + "," + usuario + "," + browser;
			}

			return arr;

		} catch (Exception e) {
			throw new ExcepcionReporte("Error al leer JSON "+json);
		}

	}
}