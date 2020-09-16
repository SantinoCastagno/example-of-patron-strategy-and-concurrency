

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Covid {

    public static Country[] getCountries() {
        String json = "";
        Country[] countries = null;
        try {
            // URL que vamos a utilizar
            String webService = "https://api.covid19api.com/summary";
            URL url = new URL(webService);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("ACCEPT", "application/json");

            if (conn.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                // Leemos en formato JSON (con la librería "json").
                String output;
                while ((output = br.readLine()) != null) {
                    json += output;
                }

                // Utilizamos la librería "Gson" para transformar el archivo Json al objeto que nos interesa.
                Gson gson = new Gson();
                //En este caso, el objeto que nos interesa es de la clase Json que definí.
                Json json2 = gson.fromJson(json, Json.class);

                // Obtengo sólo el array de los países con sus respectivos datos (que es lo que nos interesa).
                countries = json2.getCountries();

                conn.disconnect();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return countries;
    }
}
