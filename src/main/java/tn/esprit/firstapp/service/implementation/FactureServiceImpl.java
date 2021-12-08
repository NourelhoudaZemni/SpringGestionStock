package tn.esprit.firstapp.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.firstapp.DAO.entity.Facture;
import tn.esprit.firstapp.DAO.repository.DetailFactureRepository;
import tn.esprit.firstapp.DAO.repository.FactureRepository;
import tn.esprit.firstapp.service.interfaces.IFactureService;

@Service
public class FactureServiceImpl implements IFactureService {
	@Autowired
	FactureRepository facturerepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;



	@Override
	public Facture addFacture(Facture f) {
		f.setActive(true);
		f.setDateFacture(new Date());
		return facturerepository.save(f);
	}

	@Override
	public void deleteFacture(Long id) {
		facturerepository.deleteById(id);		
	}

	@Override
	public Facture updateFacture(Facture f) {
		return facturerepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		 return facturerepository.findById(id).get();
	}

    @Override
	public void cancelFacture(Long id) {
		Facture facture = facturerepository.findById(id).get();
		facture.setActive(false);
		facturerepository.save(facture);
	}

	@Override
	public List<Facture> retrieveAllFacture() {
		return (List<Facture> )facturerepository.findAll();
	}

	@Override
	public List<Facture> retrieveFactureActif() {
		return facturerepository.findByActive(true);
	}
	@Override
	public List<Facture> retrieveNonActif() {
		return facturerepository.findByActive(false);
	}
    @Override
    public List<Facture> rechercheFactureActifs(String nom) {
        return facturerepository.rechercheFacturesActifs(nom.toUpperCase());
    }

    @Override
    public List<Facture> rechercheFactureNonActifs(String nom) {
        return facturerepository.rechercheFacturesNonActifs(nom.toUpperCase());
    }
}
