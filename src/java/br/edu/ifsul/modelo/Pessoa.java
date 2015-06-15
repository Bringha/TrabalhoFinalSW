/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author bringha
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Pessoa")
public abstract class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_id_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 100, message = "O nome não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Length(max = 100, message = "O endereço não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O endereço deve ser informado")
    @Column(name = "endereco", length = 100, nullable = false)
    private String endereco;
    @Length(max = 30, message = "O bairro não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O bairro deve ser informado")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    @Length(max = 10, message = "O cep não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O cep deve ser informado")
    @Column(name = "cep", length = 10, nullable = false)
    private String cep;
    @Length(max = 30, message = "O complemento não pode ultrapassar {max} caracteres")
    @Column(name = "complemento", length = 30)
    private String complemento;
    @Email(message = "Email inválido")
    @Length(max = 50, message = "O email não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O email deve ser informado")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Length(min = 8, max = 14, message = "O telefone não deve ultrapassar {max} caracteres")
    @NotEmpty(message = "O telefone não pode ser nulo")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;
    
    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }
}
