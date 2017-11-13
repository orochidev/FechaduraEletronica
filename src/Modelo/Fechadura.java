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
abstract class Fechadura {
    private Boolean aberta;
    private Leitor leitor;
    
    public Fechadura(Leitor leitor){
        this.leitor = leitor;
        this.aberta = false;
    }
    
    abstract public void abrir();
    abstract public void fechar();
    public Boolean isAberta(){
        return aberta;
    }
    public void setAberta(Boolean aberta){
        this.aberta = aberta;
    }
}
