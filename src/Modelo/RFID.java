package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Orochi
 */
public class RFID extends Credencial{

    public RFID(String codigo) {
        super(codigo);
    }
    
    @Override
    public String toString(){
        return this.getCodigo();
    }
}
