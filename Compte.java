/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetrmi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fanta Diakité
 */
@Entity
@Table(name = "compte", catalog = "projetrim", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numerocpt"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c"),
    @NamedQuery(name = "Compte.findById", query = "SELECT c FROM Compte c WHERE c.id = :id"),
    @NamedQuery(name = "Compte.findByNumerocpt", query = "SELECT c FROM Compte c WHERE c.numerocpt = :numerocpt"),
    @NamedQuery(name = "Compte.findBySolde", query = "SELECT c FROM Compte c WHERE c.solde = :solde")})
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numerocpt", nullable = false, length = 255)
    private String numerocpt;
    @Basic(optional = false)
    @Column(name = "solde", nullable = false)
    private double solde;
    @JoinColumn(name = "client", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Client client;

    public Compte() {
    }

    public Compte(Integer id) {
        this.id = id;
    }

    public Compte(Integer id, String numerocpt, double solde) {
        this.id = id;
        this.numerocpt = numerocpt;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumerocpt() {
        return numerocpt;
    }

    public void setNumerocpt(String numerocpt) {
        this.numerocpt = numerocpt;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projetrmi.Compte[ id=" + id + " ]";
    }
    
}
