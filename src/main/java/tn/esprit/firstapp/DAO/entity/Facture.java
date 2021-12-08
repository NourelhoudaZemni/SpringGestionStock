package tn.esprit.firstapp.DAO.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "facture")
public class Facture implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private long idFacture;
	private float montantRemise;
	private float montantFacture;
	private float montantTotal;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private boolean active;
	
	@ManyToOne
	Client client;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> detailFactures;

	public Facture() {
	}

	public Facture(long idFacture, float montantRemise, float montantFacture, float montantTotal, Date dateFacture, boolean active, Client client, Set<DetailFacture> detailFactures) {
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.montantTotal = montantTotal;
		this.dateFacture = dateFacture;
		this.active = active;
		this.client = client;
		this.detailFactures = detailFactures;
	}

	public Facture(long idFacture, float montantRemise, float montantFacture, Date dateFacture, boolean active, Client client, Set<DetailFacture> detailFactures) {
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
		this.client = client;
		this.detailFactures = detailFactures;
	}

	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	public float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<DetailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public float getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}

	@Override
	public String toString() {
		return "Facture{" +
				"idFacture=" + idFacture +
				", montantRemise=" + montantRemise +
				", montantFacture=" + montantFacture +
				", montantTotal=" + montantTotal +
				", dateFacture=" + dateFacture +
				", active=" + active +
				", client=" + client +
				", detailFactures=" + detailFactures +
				'}';
	}
}
