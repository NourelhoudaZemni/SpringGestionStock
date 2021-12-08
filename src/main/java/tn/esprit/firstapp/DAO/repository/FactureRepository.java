package tn.esprit.firstapp.DAO.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.firstapp.DAO.entity.Client;
import tn.esprit.firstapp.DAO.entity.Facture;
import tn.esprit.firstapp.DAO.entity.Role;

import java.util.List;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {
    public List<Facture> findByActive(Boolean isActive);
    @Query("SELECT f FROM Facture f WHERE UPPER(f.client.nom) like %:nom% and f.active=true")
    List<Facture> rechercheFacturesActifs(@Param("nom") String nom);
    @Query("SELECT f FROM Facture f WHERE upper(f.client.nom) like %:nom% and f.active=false")
    List<Facture> rechercheFacturesNonActifs(@Param("nom") String nom);

}
