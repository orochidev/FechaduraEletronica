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
abstract public class Fechadura {
    private Boolean aberta;
    private Leitor leitorAbertura;
    private Leitor leitorFechamento;

    private Sala sala;

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    
    public Fechadura(Leitor leitor){
        this.leitorAbertura = leitor;
        this.aberta = false;
    }
    public String realizarLeitura(){
        return leitorAbertura.realizarLeitura();
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
