package tn.esprit.firstapp.service.implementation;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.firstapp.DAO.entity.DetailProduit;
import tn.esprit.firstapp.DAO.entity.Produit;
import tn.esprit.firstapp.DAO.entity.Rayon;
import tn.esprit.firstapp.DAO.entity.Stock;
import tn.esprit.firstapp.DAO.repository.DetailProduitRepository;
import tn.esprit.firstapp.DAO.repository.ProduitRepository;
import tn.esprit.firstapp.DAO.repository.RayonRepository;
import tn.esprit.firstapp.DAO.repository.StockRepository;
import tn.esprit.firstapp.service.interfaces.IProduitService;

import javax.transaction.Transactional;


@Service
public class ProduitServiceImpl implements IProduitService {
	
@Autowired
		ProduitRepository produitRepository;
@Autowired
		StockRepository stockRepository;
@Autowired
		RayonRepository rayonRepository;
@Autowired
		DetailProduitRepository detailrepository;


@Override
public List<Produit> retrieveAllProduit() {
	return (List<Produit> )produitRepository.findAll();
}

@Transactional
@Override
public Produit addProduit(Produit p, Long idRayon, Long idStock) {
	Stock stock=stockRepository.findById(idStock).orElse(null);// set men child lel parent
	Rayon rayon=rayonRepository.findById(idRayon).orElse(null) ;
	p.setRayon(rayon);
	p.setStock(stock);
	return produitRepository.save(p);

}

@Override
public void deleteProduit(Long id) {
	produitRepository.deleteById(id);
	
}

@Override
public Produit updateProduit(Produit p) {
	produitRepository.save(p);
	return p;

}

@Override
public Produit retrieveProduit(Long id) {
	Optional<Produit> p = produitRepository.findById(id) ;
	if ( p.isPresent())
	 return p.get(); // nzidha get pour renfonrcer l'objet dima ma findbyId nzid get
	else return null ;
}

	@Override
	@Transactional
	public DetailProduit saveDetailProduit(Produit p){
		if(p.getDetailproduit().getDatecreation()==null){
			p.getDetailproduit().setDatecreation(new Date());
			p.getDetailproduit().setDateDernierModification(new Date());
		}else{
			p.getDetailproduit().setDateDernierModification(new Date());
		}
		DetailProduit dp = detailrepository.save(p.getDetailproduit());
		return dp;
	}

	
	
	
	
}
