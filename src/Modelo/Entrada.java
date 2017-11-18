/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.dao.EntradaDAO;
import Modelo.ws.Connection;
import Modelo.ws.EntradaWS;

/**
 *
 * @author Orochi
 */
public class Entrada extends Evento{

    @Override
    public void save() {
        if(Connection.hasConnection()){
           new EntradaWS(this).save();
        }else{
           new EntradaDAO(this).save();
        }
    }
    
}
