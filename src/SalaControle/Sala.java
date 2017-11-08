/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaControle;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Sala {

    private String id;
    private Timestamp created_at, updated_at;
    private String codigo;
    private String url;
    private ArrayList horarios;

    public Sala(String id, Timestamp created_at, Timestamp updated_at, String codigo, String url, ArrayList horarios) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.codigo = codigo;
        this.url = url;
        this.horarios = horarios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString(){
        return id + url;
    }

}