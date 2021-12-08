package tn.esprit.firstapp.DAO.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column; import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table( name = "client") // pour modifier nom de la table
public class Client implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient") // tbadel esm l column
private Long idClient; // Clé primaire
private String nom;
private String prenom;
private String email;
private String password;
@Temporal(TemporalType.DATE) // indiquer que le champs est de type date n'importiw java.utile
private Date dateNaissance;
@Enumerated(EnumType.STRING)
private Role profession;
@Enumerated(EnumType.STRING)
private CategorieClient catClient;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
private Set<Facture> factures;

    public Client() {
    }

    public Client(Long idClient, String nom, String prenom, String email, String password, Date dateNaissance, Role profession, CategorieClient catClient, Set<Facture> factures) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.profession = profession;
        this.catClient = catClient;
        this.factures = factures;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Role getProfession() {
        return profession;
    }

    public void setProfession(Role profession) {
        this.profession = profession;
    }

    public CategorieClient getCatClient() {
        return catClient;
    }

    public void setCatClient(CategorieClient catClient) {
        this.catClient = catClient;
    }

    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", profession=" + profession +
                ", catClient=" + catClient +
                ", factures=" + factures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(idClient, client.idClient) && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(dateNaissance, client.dateNaissance) && profession == client.profession && catClient == client.catClient && Objects.equals(factures, client.factures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, nom, prenom, email, password, dateNaissance, profession, catClient, factures);
    }
}
