package br.com.academia.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Atividade implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long atividade_id;

    private String descricao;

    private boolean ativo;


    private String categoria;


    public long getAtividade_id() {
        return atividade_id;
    }

    public void setAtividade_id(long atividade_id) {
        this.atividade_id = atividade_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
