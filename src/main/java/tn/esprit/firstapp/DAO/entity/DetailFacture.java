package tn.esprit.firstapp.DAO.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "detailFacture")
public class DetailFacture implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private long idDetailFacture;
	private int qte;
	private float prixTotal;
	private float pourcentageRemise;
	private float montantRemise;
	
	 @ManyToOne
	 Facture  facture;

	 @ManyToOne
	 Produit produit;

	public DetailFacture() {
	}

	public DetailFacture(long idDetailFacture, int qte, float prixTotal, float pourcentageRemise, float montantRemise, Facture facture, Produit produit) {
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
		this.facture = facture;
		this.produit = produit;
	}

	public long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public float getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(float pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "DetailFacture{" +
				"idDetailFacture=" + idDetailFacture +
				", qte=" + qte +
				", prixTotal=" + prixTotal +
				", pourcentageRemise=" + pourcentageRemise +
				", montantRemise=" + montantRemise +
				", facture=" + facture +
				", produit=" + produit +
				'}';
	}
}
