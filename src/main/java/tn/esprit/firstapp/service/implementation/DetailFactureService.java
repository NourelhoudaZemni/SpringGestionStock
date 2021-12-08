package tn.esprit.firstapp.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.firstapp.DAO.entity.DetailFacture;
import tn.esprit.firstapp.DAO.entity.Facture;
import tn.esprit.firstapp.DAO.entity.Produit;
import tn.esprit.firstapp.DAO.repository.DetailFactureRepository;
import tn.esprit.firstapp.DAO.repository.FactureRepository;
import tn.esprit.firstapp.DAO.repository.ProduitRepository;
import tn.esprit.firstapp.service.interfaces.IDetailFactureService;

import javax.transaction.Transactional;

@Service
public class DetailFactureService implements IDetailFactureService {
	@Autowired
	DetailFactureRepository detailfacture;
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<DetailFacture> retrieveAllDetailFacture() {
		return (List<DetailFacture> )detailfacture.findAll();
	}

	@Override
	public List<DetailFacture> retrieveAllDetailFactureByFacture(long idFacture) {
		return (List<DetailFacture> )detailfacture.findDetailFacturesByFactureIdFacture(idFacture);
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture d) {
		Produit p = produitRepository.findById(d.getProduit().getIdProduit()).get();
		float montantRemise =p.getPrixUnitaire()*d.getQte()*d.getPourcentageRemise()/100 ;
		float prixTotal = p.getPrixUnitaire()*d.getQte() - montantRemise ;
		d.setMontantRemise(montantRemise);
		d.setPrixTotal(prixTotal);
		d= detailfacture.save(d);
		calculerFacture(d.getFacture().getIdFacture());
		return d ;
	}
	/** Recalculation de la Facture **/
	public void calculerFacture(Long factureId){
		Facture f = factureRepository.findById(factureId).get();
		List<DetailFacture> dfs = retrieveAllDetailFactureByFacture(factureId);
		float montantTotal = 0 ;
		float montantRemise = 0 ;
		for (DetailFacture d:dfs){
			montantTotal+= d.getPrixTotal();
			montantRemise += d.getMontantRemise();
		}
		f.setMontantFacture(montantTotal+montantRemise);
		f.setMontantRemise(montantRemise);
		f.setMontantTotal(montantTotal);
		factureRepository.save(f);
	}

	@Override
	public void deleteDetailFacture(Long id) {
		DetailFacture df  = detailfacture.findById(id).get();
		detailfacture.deleteById(id);
		calculerFacture(df.getFacture().getIdFacture());
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture d) {
		Produit p = produitRepository.findById(d.getProduit().getIdProduit()).get();
		float montantRemise =p.getPrixUnitaire()*d.getQte()*d.getPourcentageRemise()/100 ;
		float prixTotal = p.getPrixUnitaire()*d.getQte() - montantRemise ;
		d.setMontantRemise(montantRemise);
		d.setPrixTotal(prixTotal);
		d= detailfacture.save(d);
		calculerFacture(d.getFacture().getIdFacture());
		return d ;	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		 return detailfacture.findById(id).get();
	}

}
