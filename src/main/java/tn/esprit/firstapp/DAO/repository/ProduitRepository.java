package tn.esprit.firstapp.DAO.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstapp.DAO.entity.Produit;

@Repository
public interface ProduitRepository  extends CrudRepository<Produit, Long>{

}
