/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ws;

import Modelo.Entrada;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Orochi
 */
public class EntradaWS extends WS {
    private Entrada entrada;
    
    public EntradaWS(Entrada entrada){
        this.entrada = entrada;
    }
    
    public void save(){
        HttpClient httpclient = new DefaultHttpClient();
        Gson  gson  = new Gson();
        HttpPost httppost = new HttpPost(WS.baseURL +  "entradas.json");
        httppost.addHeader("Content-Type","application/json");
        StringEntity postingString;
        JSONObject json = new JSONObject();
        JSONObject j2 = new JSONObject();

        try {
            j2.put("pessoa_id", entrada.getPessoa().getId());
            j2.put("sala_id", entrada.getSala().getId());

            json.put("entrada", j2);  

            postingString = new StringEntity(json.toString());
                    httppost.setEntity(postingString);
        HttpResponse response = httpclient.execute(httppost);
        System.out.println(WS.baseURL +  "entradas.json");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EntradaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EntradaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(EntradaWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
