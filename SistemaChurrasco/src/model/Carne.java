/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Notorius B.I.G
 */
@Entity
@Table(name = "carne", catalog = "db_churrasco", schema = "")
@NamedQueries({
    @NamedQuery(name = "Carne.findAll", query = "SELECT c FROM Carne c"),
    @NamedQuery(name = "Carne.findByIdcarne", query = "SELECT c FROM Carne c WHERE c.idcarne = :idcarne"),
    @NamedQuery(name = "Carne.findByNome", query = "SELECT c FROM Carne c WHERE c.nome = :nome"),
    @NamedQuery(name = "Carne.findByPreco", query = "SELECT c FROM Carne c WHERE c.preco = :preco")})
public class Carne implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarne")
    private Integer idcarne;
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;

    public Carne() {
    }

    public Carne(Integer idcarne) {
        this.idcarne = idcarne;
    }

    public Integer getIdcarne() {
        return idcarne;
    }

    public void setIdcarne(Integer idcarne) {
        Integer oldIdcarne = this.idcarne;
        this.idcarne = idcarne;
        changeSupport.firePropertyChange("idcarne", oldIdcarne, idcarne);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        BigDecimal oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarne != null ? idcarne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carne)) {
            return false;
        }
        Carne other = (Carne) object;
        if ((this.idcarne == null && other.idcarne != null) || (this.idcarne != null && !this.idcarne.equals(other.idcarne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Carne[ idcarne=" + idcarne + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
