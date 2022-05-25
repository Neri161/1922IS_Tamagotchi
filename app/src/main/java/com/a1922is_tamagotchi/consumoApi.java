package com.a1922is_tamagotchi;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class consumoApi {
    private String direccion = "https://pokeapi.co/api/v2/pokemon?limit=3";
    private String inputLine, JSON = "";
    public String mensaje = "";
    private StringBuffer respuesta = new StringBuffer();
    private StrictMode.ThreadPolicy test = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    private URL url = null;
    private HttpURLConnection conexion;
    private BufferedReader in;

    public String accederApi(String metodo, String atributo, String resultados) {
        StrictMode.setThreadPolicy(test);
        try {
            url = new URL(direccion);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod(metodo);
            conexion.connect();

            if(metodo.equals("GET")){
                in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                while ((inputLine = in.readLine()) != null) {
                    respuesta.append(inputLine);
                }
                JSON = respuesta.toString();
                JSONObject objetoJSON = new JSONObject(JSON);
                JSONArray arregloJSON = objetoJSON.getJSONArray(resultados);
                for (int i = 0; i < arregloJSON.length(); i++) {
                    JSONObject explrObject = arregloJSON.getJSONObject(i);
                    mensaje += atributo + " " + explrObject.optString(atributo) + "\n";
                }
            } else if (metodo.equals(("POST"))){
                mensaje="CTM";
            }

            return mensaje;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "ERROR URL";
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR IO";
        } catch (JSONException e) {
            e.printStackTrace();
            return "ERROR JSON";
        }
    }

}
