/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Orochi
 */
abstract public class Evento implements  Serializable{
    @SerializedName("registrado_em")

    private Date registradoEm;

    public Date getRegistradoEm() {
        return registradoEm;
    }

    public void setRegistradoEm(Date registradoEm) {
        this.registradoEm = registradoEm;
    }
    @Expose(serialize = false)
    private Pessoa pessoa;
    @Expose(serialize = false)
    private Sala sala;
    
    @SerializedName("pessoa_id")
    private Integer pessoaId;
    @SerializedName("sala_id")
    private Integer salaId;
    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.pessoaId = pessoa.getId();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
        this.salaId = sala.getId();

    }
    
}
