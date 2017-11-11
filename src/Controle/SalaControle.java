/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.BufferedReader;
import Principal.Connection;
import java.io.IOException;
import java.util.ArrayList;
import Modelo.Sala;

/**
 *
 * @author Daniel
 */
public class SalaControle {

    ArrayList<Sala> salas;
    private String id;
    private SimpleDateFormat created_at, updated_at;
    private String codigo;
    private String url;
    private ArrayList horarios;

        public SalaControle(){
            salas = new ArrayList<>();	//enquanto as salas não estão sendo persistidos no banco de dados, elas serão armazenadas aqui
        }

    public void updateSala() throws InterruptedException, ParseException, IOException{

        JSONParser parse = new JSONParser();    //usado para recuperar os jsons
        BufferedReader buffer;                  //buffer onde o arquivo json será armazenado

        while(true){		//enquanto o Rasp estiver ativo, ele sempre terá que executar este loop

            System.out.println("Verificando conectividade ...");
            System.out.println("");
            if(!Connection.hasConnection()){    //se nao tiver conexao
            System.out.println("Conectividade falhou!");
                Thread.sleep(1000*60);         	//aguarda 60 segundos
                continue;						//e volta para o começo
            }

            System.out.println("conectividade OK.");
            System.out.println("Recuperando JSON");
            buffer = Connection.getJson("http://127.0.0.6:8000/arquivo.json");	//dado o link, o arquivo JSON será recuperado
            JSONArray arrayJson = (JSONArray) parse.parse(buffer);				//JSONArray, pois pode ter mais de um objeto sala no JSON
            System.out.println("JSON recuperado");

            while(!arrayJson.isEmpty()){     //retirando do json e criando a sala e adicionando no array de salas

                JSONObject salaJson = (JSONObject) arrayJson.remove(arrayJson.size()-1);	//Dos vários objetos (salas) JSON dentro do array, pego um deles, o primeiro.
                id = (String) salaJson.get("id");

                ////o timestamp não pode ser deste formato: 2017-11-07T06:45:24.427-02:00, pois o "T" não faz parte. Então tenho que pegar a substring e concatenar as partes antes do "T" e a parte depois.
                String timestamp = (String) salaJson.get("created_at");
                created_at = new SimpleDateFormat(timestamp.substring(0, timestamp.indexOf("T")) + " " + timestamp.substring(timestamp.indexOf("T")+1));
                timestamp = (String) salaJson.get("updated_at");
                updated_at = new SimpleDateFormat(timestamp.substring(0, timestamp.indexOf("T")) + " " + timestamp.substring(timestamp.indexOf("T")+1));

                codigo = (String) salaJson.get("codigo");
                url = (String) salaJson.get("url");
                horarios = (ArrayList<Sala>) salaJson.get("horarios");

                Sala sala = new Sala(id, created_at, updated_at, codigo, url, horarios);
                salas.add(sala);
                System.out.println("Sala adicionada: " + sala);
            }

            Thread.sleep(1000*60);         //terminou, entao aguarda 60 segundos
        }
    }


}
