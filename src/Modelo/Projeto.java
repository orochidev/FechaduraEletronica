/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Orochi
 */
public class Projeto {
    private static Projeto projeto;
    private Sala sala;
    
    public static Projeto getInstance(){
        if(projeto == null){
            projeto = new Projeto();
        }
        return projeto;
    }
    public Sala getSala(){
        return sala;
    }
    public void setSala(Sala sala){
        this.sala = sala;
    }
    

}
