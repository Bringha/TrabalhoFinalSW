package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Jorge Luis Boeira Bavaresco jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "aditivo")
public class Aditivo implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_aditivo", sequenceName = "seq_aditivo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_aditivo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty(message = "A descrição deve ser informada")
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(name = "descricao", nullable = false)
    @Lob
    private String descricao;
    @Column(name = "valor_reajuste", columnDefinition = "decimal(12,2)")
    private Double valorReajuste;
    @Column(name = "dias", columnDefinition = "decimal(12,2)")    
    private Integer dias;
    @ManyToOne
    @JoinColumn(name = "contrato", referencedColumnName = "id")
    private Contrato contrato;

    public Aditivo() {
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

    public Double getValorReajuste() {
        return valorReajuste;
    }

    public void setValorReajuste(Double valorReajuste) {
        this.valorReajuste = valorReajuste;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Aditivo other = (Aditivo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aditivo{" + "descricao=" + descricao + '}';
    }

}
