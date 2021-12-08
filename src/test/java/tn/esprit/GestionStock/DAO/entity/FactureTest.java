package tn.esprit.firstapp.DAO.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.firstapp.service.interfaces.IClientService;
import tn.esprit.firstapp.service.interfaces.IFactureService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FactureTest {
    @Autowired
    IClientService clientService;
    @Autowired
    IFactureService factureService
            ;
    @Test
    public void addFactureTest(){
        int expectedSize = factureService.retrieveAllFacture().size();
        Client c = new Client();
        c.setNom("Nour");
        c.setPrenom("Zemni");
        c.setDateNaissance(new Date(1997,02,20));
        c.setPassword("laylaylay");
        c.setEmail("nourrrr@esprit.tn");
        c.setProfession(Role.INGENIEUR);
        c.setCatClient(CategorieClient.FIDELE);
        c = clientService.addClient(c);
        Facture f = new Facture();
        f.setClient(c);
        f.setDateFacture(new Date());
        f.setMontantFacture(200);
        f.setMontantRemise(12);
        Facture savedFacture =factureService.addFacture(f);
        assertEquals(expectedSize+1, factureService.retrieveAllFacture().size());
        assertNotNull(savedFacture.getDateFacture());
        assertTrue(savedFacture.isActive());
     //   factureService.deleteFacture(savedFacture.getIdFacture());
    }

}