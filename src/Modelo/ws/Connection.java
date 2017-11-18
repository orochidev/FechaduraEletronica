/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ws;

import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static String getJson(String url){
        StringBuilder buffer = new StringBuilder();
        try {
            URL u = new URL(url);
            InputStream is = u.openStream();
            int ptr = 0;
            while ((ptr = is.read()) != -1) {
                buffer.append((char)ptr);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       return buffer.toString();
    }
}
