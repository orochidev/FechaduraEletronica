/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import org.json.simple.parser.ParseException;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URLConnection;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Daniel
 */
public class Connection {

    public static boolean hasConnection(){

        try{
            java.net.URL connection = new java.net.URL("https://www.google.com.br");
            java.net.HttpURLConnection httpConnection = (java.net.HttpURLConnection) connection.openConnection();
            httpConnection.connect();

            return httpConnection.getResponseCode() == 200;
        } catch (IOException ex) {
            return false;
        }
    }

    public static BufferedReader getJson(String url_json) throws IOException{

        try{
            URL url = new URL(url_json);
            URLConnection conn = url.openConnection();

            return new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (MalformedURLException ex) {
            return null;
        }
    }
}
