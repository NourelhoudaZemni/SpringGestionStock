package tn.esprit.firstapp.service.interfaces;

import java.util.List;

import tn.esprit.firstapp.DAO.entity.Facture;


public interface IFactureService {
	List<Facture> retrieveAllFacture();
	List<Facture> retrieveFactureActif();
	List<Facture> retrieveNonActif();
	 Facture addFacture(Facture f);
	 void deleteFacture(Long id);
	 void cancelFacture(Long id);
	 Facture updateFacture(Facture f);
	 Facture retrieveFacture(Long id);
	List<Facture> rechercheFactureActifs(String nom);
	List<Facture> rechercheFactureNonActifs(String nom);

}
