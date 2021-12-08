package tn.esprit.firstapp.service.interfaces;

import java.util.List;

import tn.esprit.firstapp.DAO.entity.CategorieClient;
import tn.esprit.firstapp.DAO.entity.Client;
import tn.esprit.firstapp.DAO.entity.Role;

public interface IClientService  {
	List<Client> retrieveAllClients();
	Client addClient(Client c);
	Client updateClient(Client c);
	Client retrieveClient(Long id);
	void deleteClient(Long id);
	List<Client> retrieveClientsByProfession( Role profession);
	int updateClientCategorieByProfession(CategorieClient categorieClient, Role profession);
	int deleteClientByCategorieClientAndProfession( CategorieClient categorieClient, Role profession);
	public void insertClient(Client client);
}
