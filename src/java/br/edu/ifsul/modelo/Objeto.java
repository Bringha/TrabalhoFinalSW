/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author bringha
 */
@Entity
@Table(name = "objeto")
public class Objeto implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_objeto", sequenceName = "seq_objeto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_objeto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty(message = "A descrição deve ser informada")
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(name = "descricao", nullable = false)
    @Lob
    private String descricao;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", columnDefinition = "decimal(12,2)", nullable = false)
    private Double valor;
    
    public Objeto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Objeto other = (Objeto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objeto{" + "descricao=" + descricao + ", valor=" + valor + '}';
    }
}
