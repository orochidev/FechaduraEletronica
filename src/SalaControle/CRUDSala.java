/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaControle;

import Principal.Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daniel
 */
public class CRUDSala {

    ArrayList<Sala> salas;
    private String id;
    private Timestamp created_at, updated_at;
    private String codigo;
    private String url;
    private ArrayList horarios;

        public CRUDSala(){
            salas = new ArrayList<>();
        }

    public void updateSala() throws InterruptedException, IOException, ParseException{

        JSONParser parse = new JSONParser();    //usado para recuperar os jsons
        BufferedReader buffer;                  //buffer onde o arquivo json será armazenado

        while(true){

            System.out.println("Verificando conectividade ...");
            System.out.println("");
            if(!Connection.hasConnection()){    //se nao tiver conexao
            System.out.println("Conectividade falhou!");
                Thread.sleep(1000*60);         //aguarda 60 segundos
                continue;
            }

            System.out.println("conectividade OK.");
            System.out.println("Recuperando JSON");
            buffer = Connection.getJson("http://127.0.0.6:8000/json.txt");
            JSONArray arrayJson = (JSONArray) parse.parse(buffer);
            System.out.println("JSON recuperado");

            while(!arrayJson.isEmpty()){     //retirando do json e criando a sala e adicionando no array de salas
                System.out.println("Transformando JSON em SALA");
                JSONObject salaJson = (JSONObject) arrayJson.remove(arrayJson.size()-1);
                id = (String) salaJson.get("id");
                created_at = Timestamp.valueOf( (String) salaJson.get("created_at"));   //o timestamp não pode ser deste formato: 2017-11-07T06:45:24.427-02:00. O mesmo tem que ser assim: 2017-11-07 06:45:24
                updated_at = Timestamp.valueOf( (String) salaJson.get("updated_at"));
                codigo = (String) salaJson.get("codigo");
                url = (String) salaJson.get("url");
                horarios = (ArrayList<Sala>) salaJson.get("horarios");

                Sala sala = new Sala(id, created_at, updated_at, codigo, url, horarios);
                salas.add(sala);
                System.out.println(sala);
            }

            Thread.sleep(1000*60);         //terminou, entao aguarda 60 segundos
        }
    }


}
