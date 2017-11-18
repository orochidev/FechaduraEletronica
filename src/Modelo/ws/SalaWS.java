/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ws;

import Modelo.Sala;

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
    
    
}
