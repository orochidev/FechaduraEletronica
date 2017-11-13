/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ws;

import Modelo.Aluno;
import Modelo.Pessoa;
import Modelo.Professor;
import Modelo.Servidor;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Orochi
 */
public class PessoaDeserializer  implements JsonDeserializer<Pessoa>{

    @Override
    public Pessoa deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
         if (json.isJsonObject()) {
            JSONObject j = null;
            try {
                j = new JSONObject(json.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                switch(j.getString("type")){
                    case "Aluno":
                        return context.deserialize(json, Aluno.class);
                    case "Professor":
                        return context.deserialize(json, Professor.class);
                    case "Servidor":
                        return context.deserialize(json, Servidor.class);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // If you need to deserialize as MediaPojo,
            // deserialize without the current context
            // or you will infinite loop

        } else {
            // Return a blank object on error, could use null
            return null;
        }
        return null;    
    }
    
}
