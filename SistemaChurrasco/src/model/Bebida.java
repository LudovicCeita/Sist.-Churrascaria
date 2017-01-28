/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "bebida", catalog = "db_churrasco", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bebida.findAll", query = "SELECT b FROM Bebida b"),
    @NamedQuery(name = "Bebida.findByIdbebida", query = "SELECT b FROM Bebida b WHERE b.idbebida = :idbebida"),
    @NamedQuery(name = "Bebida.findByNome", query = "SELECT b FROM Bebida b WHERE b.nome = :nome"),
    @NamedQuery(name = "Bebida.findByPreco", query = "SELECT b FROM Bebida b WHERE b.preco = :preco")})
public class Bebida implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbebida")
    private Integer idbebida;
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private String preco;

    public Bebida() {
    }

    public Bebida(Integer idbebida) {
        this.idbebida = idbebida;
    }

    public Integer getIdbebida() {
        return idbebida;
    }

    public void setIdbebida(Integer idbebida) {
        Integer oldIdbebida = this.idbebida;
        this.idbebida = idbebida;
        changeSupport.firePropertyChange("idbebida", oldIdbebida, idbebida);
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        String oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbebida != null ? idbebida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bebida)) {
            return false;
        }
        Bebida other = (Bebida) object;
        if ((this.idbebida == null && other.idbebida != null) || (this.idbebida != null && !this.idbebida.equals(other.idbebida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Bebida[ idbebida=" + idbebida + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
