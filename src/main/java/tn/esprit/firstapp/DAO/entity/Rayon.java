package tn.esprit.firstapp.DAO.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table( name = "rayon")
public class Rayon implements Serializable {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idRayon")
private Long idRayon;
private String codeRayon;
private String libelleRayon;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
private Set<Produit> produit;

    public Rayon() {
    }

    public Rayon(Long idRayon, String codeRayon, String libelleRayon, Set<Produit> produit) {
        this.idRayon = idRayon;
        this.codeRayon = codeRayon;
        this.libelleRayon = libelleRayon;
        this.produit = produit;
    }

    public Long getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(Long idRayon) {
        this.idRayon = idRayon;
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getLibelleRayon() {
        return libelleRayon;
    }

    public void setLibelleRayon(String libelleRayon) {
        this.libelleRayon = libelleRayon;
    }

    public Set<Produit> getProduit() {
        return produit;
    }

    public void setProduit(Set<Produit> produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "idRayon=" + idRayon +
                ", codeRayon='" + codeRayon + '\'' +
                ", libelleRayon='" + libelleRayon + '\'' +
                ", produit=" + produit +
                '}';
    }
}