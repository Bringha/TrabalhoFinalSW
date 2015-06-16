package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "contrato")
public class Contrato implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_contrato", sequenceName = "seq_contrato_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_contrato", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty(message = "O número não pode ser nulo")
    @Length(max = 50, message = "O número não pode ultrapassar {max} caracteres")
    @Column(name = "numero", length = 50, nullable = false)
    private String numero;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio",nullable = false)
    private Calendar dataInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_assinatura",nullable = false)
    private Calendar dataAssinatura;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim",nullable = false)
    private Calendar dataFim;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valorTotal;
    @NotNull(message = "O objeto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "objeto", referencedColumnName = "id", nullable = false)
    private Objeto objeto;
    @NotNull(message = "O contratante deve ser informado")
    @ManyToOne
    @JoinColumn(name = "contratante", referencedColumnName = "id", nullable = false)
    private Contratante contratante;
    @NotNull(message = "O contratado deve ser informado")
    @ManyToOne
    @JoinColumn(name = "contratado", referencedColumnName = "id", nullable = false)
    private Contratado contratado;
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Aditivo> aditivos = new ArrayList<>();    
    
    public Contrato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(Calendar dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    public Contratado getContratado() {
        return contratado;
    }

    public void setContratado(Contratado contratado) {
        this.contratado = contratado;
    }

    public List<Aditivo> getAditivos() {
        return aditivos;
    }

    public void setAditivos(List<Aditivo> aditivos) {
        this.aditivos = aditivos;
    }
    
    public void adicionarAditivo(Aditivo obj){
        obj.setContrato(this);
        this.aditivos.add(obj);        
    }
    
    public void removerAditivo(int index){
        this.aditivos.remove(index);        
    }
    
    public void removerTodos(){
        this.aditivos.clear();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Contrato other = (Contrato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contrato{" + "numero=" + numero + ", objeto=" + objeto + ", contratante=" + contratante + ", contratado=" + contratado + '}';
    }
    
}
