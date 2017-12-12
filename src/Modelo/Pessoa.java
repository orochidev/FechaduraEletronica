package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;


/**
 *
 * @author Orochi
 */
abstract public class Pessoa implements  Serializable{
    private String nome;
    private String type;
    private Integer id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Credencial> getCredenciais() {
        return credenciais;
    }

    public void setCredenciais(List<Credencial> credenciais) {
        this.credenciais = credenciais;
    }
    private List<Credencial> credenciais;
    
    
    
    public String getNome() {
        
        return nome;
        
    }

    public void setNome(String nome) {
        this.nome = nome;
        
    }
    
}
