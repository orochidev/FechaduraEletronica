/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ws;
import Modelo.Pessoa;
import Modelo.RFID;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Orochi
 */
public class RFIDWS extends WS{
    private RFID rfid;
    public RFIDWS(RFID rfid){
        this.rfid = rfid;
    }
    
    public static RFID getRFID(String rfid){
        Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Pessoa.class, new PessoaDeserializer())
                    .create();
        String json = Connection.getJson(WS.baseURL + "rfids.json?search=" + rfid);
        List<RFID> retorno = gson.fromJson(json, new TypeToken<ArrayList<RFID>>(){}.getType());
        if(retorno.isEmpty()){
            return null;
        }else{
            return retorno.get(0);
        }
    }
}
