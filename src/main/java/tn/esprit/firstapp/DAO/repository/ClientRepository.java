package tn.esprit.firstapp.DAO.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstapp.DAO.entity.CategorieClient;
import tn.esprit.firstapp.DAO.entity.Client;
import tn.esprit.firstapp.DAO.entity.Role;

import java.util.Date;
import java.util.List;


@Repository
public interface ClientRepository  extends CrudRepository<Client, Long>{
    @Query("SELECT c FROM Client c WHERE c.profession= :profession")
    List<Client> retrieveClientsByProfession(@Param("profession") Role profession);

    @Modifying
    @Query("update Client c set c.catClient = :categorie where c.profession = :profession")
    int updateClientCategorieByProfession(@Param("categorie") CategorieClient categorieClient, @Param("profession") Role profession);

    @Modifying
    @Query("DELETE FROM Client c WHERE c.catClient= :categorie AND c.profession = :profession")
    int deleteClientByCategorieClientAndProfession(@Param("categorie") CategorieClient categorieClient, @Param("profession") Role profession);

    @Modifying
    @Query(value = "INSERT INTO Client (nom, prenom, dateNaissance,email,password,profession,categorieClient) VALUES (:nom,:prenom, :dateN, :email, :password, :profession, :categorieClient)", nativeQuery = true)
    void insertClient(@Param("nom") String nom, @Param("prenom") String prenom,
                      @Param("dateN") Date dateNaissance, @Param("email") String email,
                      @Param("password") String password, @Param("profession") Role
                              profession, @Param("categorieClient") CategorieClient categorieClient);


}
