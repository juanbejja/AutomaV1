package json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONManager {

	public static String[] readJSON(String json, String object) throws IOException, ParseException {
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader("data//" + json + ".json");

			Object obj = jsonParser.parse(reader);

			JSONObject userLoginsJSONobj = (JSONObject) obj;

			JSONArray userLoginsArray = (JSONArray) userLoginsJSONobj.get(object);

			String arr[] = new String[userLoginsArray.size()];

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
			System.out.println("fallo al leer " + e);
			return null;
		}

	}
}