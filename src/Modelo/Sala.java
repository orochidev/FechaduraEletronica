package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Sala{

    private Integer id;
    private String codigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Fechadura getFechadura() {
        return fechadura;
    }

    public void setFechadura(Fechadura fechadura) {
        this.fechadura = fechadura;
    }
    private List<Horario> horarios;
    private Fechadura fechadura;
   
    public Boolean isAutorizado(Pessoa pessoa){
        for(Horario horario: horarios){
            if(pessoa instanceof Aluno){
            }
        }
        return true;
    }
    @Override
    public String toString(){
        return codigo;
    }
}