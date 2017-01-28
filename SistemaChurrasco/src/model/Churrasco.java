/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Notorius B.I.G
 */
@Entity
@Table(name = "churrasco", catalog = "db_churrasco", schema = "")
@NamedQueries({
    @NamedQuery(name = "Churrasco.findAll", query = "SELECT c FROM Churrasco c"),
    @NamedQuery(name = "Churrasco.findByIdchurrasco", query = "SELECT c FROM Churrasco c WHERE c.idchurrasco = :idchurrasco"),
    @NamedQuery(name = "Churrasco.findByData", query = "SELECT c FROM Churrasco c WHERE c.data = :data"),
    @NamedQuery(name = "Churrasco.findByHora", query = "SELECT c FROM Churrasco c WHERE c.hora = :hora"),
    @NamedQuery(name = "Churrasco.findByLocal", query = "SELECT c FROM Churrasco c WHERE c.local = :local")})
public class Churrasco implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchurrasco")
    private Integer idchurrasco;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "local")
    private String local;

    public Churrasco() {
    }

    public Churrasco(Integer idchurrasco) {
        this.idchurrasco = idchurrasco;
    }

    public Integer getIdchurrasco() {
        return idchurrasco;
    }

    public void setIdchurrasco(Integer idchurrasco) {
        Integer oldIdchurrasco = this.idchurrasco;
        this.idchurrasco = idchurrasco;
        changeSupport.firePropertyChange("idchurrasco", oldIdchurrasco, idchurrasco);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        changeSupport.firePropertyChange("local", oldLocal, local);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchurrasco != null ? idchurrasco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Churrasco)) {
            return false;
        }
        Churrasco other = (Churrasco) object;
        if ((this.idchurrasco == null && other.idchurrasco != null) || (this.idchurrasco != null && !this.idchurrasco.equals(other.idchurrasco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Churrasco[ idchurrasco=" + idchurrasco + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
