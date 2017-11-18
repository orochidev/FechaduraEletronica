package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;


/**
 *
 * @author Orochi
 */
abstract public class Pessoa implements Savable{
    private String nome;
    private String type;
    private List<Credencial> credenciais;
    
    
    
    public String getNome() {
        
        return nome;
        
    }

    public void setNome(String nome) {
        this.nome = nome;
        
    }
    
}
