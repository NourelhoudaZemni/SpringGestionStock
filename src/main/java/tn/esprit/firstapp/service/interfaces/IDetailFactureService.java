package tn.esprit.firstapp.service.interfaces;

import java.util.List;

import tn.esprit.firstapp.DAO.entity.DetailFacture;

public interface IDetailFactureService  {
	List<DetailFacture> retrieveAllDetailFacture();
	List<DetailFacture> retrieveAllDetailFactureByFacture(long idFacture);
	 DetailFacture addDetailFacture(DetailFacture d);
	 void deleteDetailFacture(Long id);
	 DetailFacture updateDetailFacture(DetailFacture d);
	 DetailFacture retrieveDetailFacture(Long id);
}
