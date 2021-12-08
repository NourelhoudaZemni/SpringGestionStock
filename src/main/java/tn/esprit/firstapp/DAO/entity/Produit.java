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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prixUnitaire;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailFacture> detailFactures;
	
	@ManyToOne
	 Stock stock;
	@ManyToOne 
	Rayon rayon;
	
	@OneToOne
	 private DetailProduit detailproduit ;
	
	@ManyToMany (cascade=CascadeType.ALL)
	   private Set<Fournisseur>Fournissuers;

	public Produit() {
	}

	public Produit(long idProduit, String codeProduit, String libelleProduit, float prixUnitaire, Set<DetailFacture> detailFactures, Stock stock, Rayon rayon, DetailProduit detailproduit, Set<Fournisseur> fournissuers) {
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prixUnitaire = prixUnitaire;
		this.detailFactures = detailFactures;
		this.stock = stock;
		this.rayon = rayon;
		this.detailproduit = detailproduit;
		Fournissuers = fournissuers;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Set<DetailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public DetailProduit getDetailproduit() {
		return detailproduit;
	}

	public void setDetailproduit(DetailProduit detailproduit) {
		this.detailproduit = detailproduit;
	}

	public Set<Fournisseur> getFournissuers() {
		return Fournissuers;
	}

	public void setFournissuers(Set<Fournisseur> fournissuers) {
		Fournissuers = fournissuers;
	}

	@Override
	public String toString() {
		return "Produit{" +
				"idProduit=" + idProduit +
				", codeProduit='" + codeProduit + '\'' +
				", libelleProduit='" + libelleProduit + '\'' +
				", prixUnitaire=" + prixUnitaire +
				", detailFactures=" + detailFactures +
				", stock=" + stock +
				", rayon=" + rayon +
				", detailproduit=" + detailproduit +
				", Fournissuers=" + Fournissuers +
				'}';
	}
}
