package tn.esprit.firstapp.DAO.entity;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.firstapp.service.interfaces.IClientService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClientTest {
    @Autowired
    IClientService clientService;

    @Test
    public Client testAddClient(){
        int expectedSize = clientService.retrieveAllClients().size();
        Client c = new Client();
        c.setNom("nour");
        c.setPrenom("nour");
        c.setDateNaissance(new Date(1998,06,20));
        c.setPassword("azerty");
        c.setEmail("nour@esprit.tn");
        c.setProfession(Role.INGENIEUR);
        c.setCatClient(CategorieClient.FIDELE);
        Client savedClient = clientService.addClient(c);
        assertEquals(expectedSize+1, clientService.retrieveAllClients().size());
        assertNotNull(savedClient.getNom());
        //clientService.deleteClient(savedClient.getIdClient());
        return savedClient;
    }
    @Test
    public void testupdateClient(){
        Client savedClient = this.testAddClient();
        Client c = savedClient ;
        c.setNom("nour Has Changed");
        Client savedClient2 = clientService.updateClient(c);
        assertNotNull(savedClient2.getNom());
        //assertNotEquals(savedClient.getNom().length(),savedClient2.getNom().length());
        //clientService.deleteClient(savedClient.getIdClient());
    }


}