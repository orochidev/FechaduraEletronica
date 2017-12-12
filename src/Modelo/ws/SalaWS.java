/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ws;

import Modelo.Pessoa;
import Modelo.RFID;
import Modelo.Sala;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Orochi
 */
public class SalaWS extends WS{
    private Sala sala;
    public SalaWS(Sala sala) {
        this.sala = sala;
    }
    
    public static Sala getById(Integer id){
        return new Sala();
    }
    
    public static List<Sala> getAll(){
         Gson gson = new GsonBuilder().create();
        String json = Connection.getJson(WS.baseURL + "salas.json");
        System.out.println(WS.baseURL + "salas.json");
        List<Sala> retorno = gson.fromJson(json, new TypeToken<ArrayList<Sala>>(){}.getType());
         return retorno;
      
    }
}
