/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author bringha
 */
@Entity
@Table(name = "juridica")
public class Juridica extends Pessoa implements Serializable{
    @Length(max = 100, message = "O representante não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O representante deve ser informado")
    @Column(name = "representante", length = 100, nullable = false)
    private String representante;
    @Length(max = 100, message = "O nome fantasia não pode ultrapassar {max} caracteres")
    @Column(name = "nome_fantasia", length = 100)
    private String nomeFantasia;
    @CNPJ(message = "CNPJ inválido")
    @Length(min = 18, max = 18, message = "O CPF deve ter {max} caracteres")
    @NotEmpty(message = "O CNPJ não pode ser nulo")
    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;
    
    public Juridica() {
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
