package tn.esprit.firstapp.service.interfaces;

import java.util.List;

import tn.esprit.firstapp.DAO.entity.DetailProduit;
import tn.esprit.firstapp.DAO.entity.Produit;

public interface IProduitService {
	 List<Produit> retrieveAllProduit();
     Produit addProduit(Produit p, Long idRayon, Long idStock);
	 void deleteProduit(Long id);
	 Produit updateProduit(Produit p);
	 Produit retrieveProduit(Long id);
	DetailProduit saveDetailProduit(Produit p);
}
