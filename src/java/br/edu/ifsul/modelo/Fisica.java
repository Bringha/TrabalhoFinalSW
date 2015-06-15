/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.br.CPF;


/**
 *
 * @author bringha
 */
@Entity
@Table(name = "fisica")
public class Fisica extends Pessoa implements Serializable{
    @Length(min = 10, max = 10, message = "O RG deve ter {max} caracteres")
    @NotEmpty(message = "O RG não pode ser nulo")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;
    @CPF(message = "CPF inválido")
    @Length(min = 14, max = 14, message = "O CPF deve ter {max} caracteres")
    @NotEmpty(message = "O CPF não pode ser nulo")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    
    public Fisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
