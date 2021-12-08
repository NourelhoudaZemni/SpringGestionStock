package tn.esprit.firstapp.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.firstapp.DAO.entity.CategorieClient;
import tn.esprit.firstapp.DAO.entity.Client;
import tn.esprit.firstapp.DAO.entity.Role;
import tn.esprit.firstapp.DAO.repository.ClientRepository;
import tn.esprit.firstapp.service.interfaces.IClientService;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	ClientRepository clientrepository;

	@Override
	public List<Client> retrieveAllClients() {
		return (List<Client>) clientrepository.findAll();
	}
		
	@Override
	public Client addClient(Client c) {
		return clientrepository.save(c);
	}

	@Override
	public Client updateClient(Client c) {
		return clientrepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientrepository.findById(id).get();
	}

	@Override
	public void deleteClient(Long id) {
		clientrepository.deleteById(id);
	}

	@Override
	public List<Client> retrieveClientsByProfession(Role profession) {
		return clientrepository.retrieveClientsByProfession(profession);
	}

	@Override
	public int updateClientCategorieByProfession(CategorieClient categorieClient, Role profession) {
		return updateClientCategorieByProfession(categorieClient,profession);
	}

	@Override
	public int deleteClientByCategorieClientAndProfession(CategorieClient categorieClient, Role profession) {
		return deleteClientByCategorieClientAndProfession(categorieClient,profession);
	}

	@Override
	public void insertClient(Client client) {
		clientrepository.insertClient(client.getNom(), client.getPrenom(), client.getDateNaissance(), client.getEmail(), client.getPassword(), client.getProfession(), client.getCatClient());
	}


}
