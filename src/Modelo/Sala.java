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

    private String id;
    private String codigo;
    private List<Horario> horarios;
    private Fechadura fechadura;
   
    public Boolean isAutorizado(Pessoa pessoa){
        for(Horario horario: horarios){
            if(pessoa instanceof Aluno){
            }
        }
        return true;
    }
}