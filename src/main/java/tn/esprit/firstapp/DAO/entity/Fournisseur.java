package tn.esprit.firstapp.DAO.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table( name = "fournisseur")
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFournisseur")
	private long  idFournisseur;
	private String codeFournisseur;
	private String libelleFournisseur;

	public Fournisseur() {
	}

	public Fournisseur(long idFournisseur, String codeFournisseur, String libelleFournisseur) {
		this.idFournisseur = idFournisseur;
		this.codeFournisseur = codeFournisseur;
		this.libelleFournisseur = libelleFournisseur;
	}

	public long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getCodeFournisseur() {
		return codeFournisseur;
	}

	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}

	public String getLibelleFournisseur() {
		return libelleFournisseur;
	}

	public void setLibelleFournisseur(String libelleFournisseur) {
		this.libelleFournisseur = libelleFournisseur;
	}

	@Override
	public String toString() {
		return "Fournisseur{" +
				"idFournisseur=" + idFournisseur +
				", codeFournisseur='" + codeFournisseur + '\'' +
				", libelleFournisseur='" + libelleFournisseur + '\'' +
				'}';
	}
}
