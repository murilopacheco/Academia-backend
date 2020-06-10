package br.com.academia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Plano implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long plano_id;

    private float valor;

    private String descricao;

    private String categoria;

    @ManyToMany(fetch = FetchType.LAZY,
                    cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<Atividade> atividades;

    public long getPlano_id() {
        return plano_id;
    }

    public void setPlano_id(long plano_id) {
        this.plano_id = plano_id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}