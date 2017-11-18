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
public class Horario {
    private Integer id;
    private String tipoPermitido;
    private List<HorarioItem> horarioItens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPermitido() {
        return tipoPermitido;
    }

    public void setTipoPermitido(String tipoPermitido) {
        this.tipoPermitido = tipoPermitido;
    }

    public List<HorarioItem> getHorarioItens() {
        return horarioItens;
    }

    public void setHorarioItens(List<HorarioItem> horarioItens) {
        this.horarioItens = horarioItens;
    }
    
    
}
