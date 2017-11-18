/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Orochi
 */
abstract public class Evento implements Savable{
    private Date realizadoEm;

    private Pessoa pessoa;
    private Sala sala;

    public Date getRealizadoEm() {
        return realizadoEm;
    }

    public void setRealizadoEm(Date realizadoEm) {
        this.realizadoEm = realizadoEm;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
}
