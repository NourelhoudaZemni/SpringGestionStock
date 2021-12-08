package tn.esprit.firstapp.DAO.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.firstapp.service.interfaces.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DetailFactureTest {
    @Autowired
    IStockService  stockService ;
    @Autowired
    IRayonService rayonService ;
    @Autowired
    IDetailProduitService detailProduitService ;
    @Autowired
    IProduitService produitService ;
    @Autowired
    IFactureService factureService ;
    @Autowired
    IDetailFactureService detailFactureService ;
    @Autowired
    IClientService clientService ;

    @Test
    public void addDetailFactureTest(){
        Client c = new Client();
        c.setNom("nour");
        c.setPrenom("zmni");
        c.setDateNaissance(new Date(1998,06,20));
        c.setPassword("nour");
        c.setEmail("nour@esprit.tn");
        c.setProfession(Role.INGENIEUR);
        c.setCatClient(CategorieClient.FIDELE);
        c = clientService.addClient(c);
        Facture f = new Facture();
        f.setClient(c);
        f.setDateFacture(new Date());
        f.setMontantFacture(200);
        f.setMontantRemise(12);
        f = factureService.addFacture(f);

        Rayon r = new Rayon();
        r.setCodeRayon("R72");
        r.setLibelleRayon("Rayon 72");
        r =rayonService.addRayon(r);
        Stock s = new Stock();
        s.setLibelleStock("Stock 1 test Razors");
        s.setQteMin(5);
        s.setQteStock(200);
        s = stockService.addStock(s);

        DetailProduit dp = new DetailProduit();
        dp.setCategorieProduit(CategorieProduit.ELECTROMENAGER);
        dp.setDatecreation(new Date());
        dp.setDateDernierModification(new Date());
        dp = detailProduitService.addDetailProduit(dp);

        Produit p = new Produit();
        p.setRayon(r);
        p.setStock(s);
        p.setCodeProduit("nour");
        p.setLibelleProduit("Test");
        p.setPrixUnitaire(10);
        p.setDetailproduit(dp);
        p = produitService.addProduit(p,r.getIdRayon(),s.getIdStock());

        int expectedSize = detailFactureService.retrieveAllDetailFacture().size();
        DetailFacture df = new DetailFacture();
        df.setFacture(f);
        df.setProduit(p);
        df.setQte(10);
        df.setPourcentageRemise(10);
        df.setMontantRemise(df.getProduit().getPrixUnitaire()*df.getQte()*df.getPourcentageRemise()/100);
        System.out.println(df.getMontantRemise());
        df.setPrixTotal(df.getProduit().getPrixUnitaire()*df.getQte()-df.getMontantRemise());
        df = detailFactureService.addDetailFacture(df);
        assertEquals(expectedSize+1, detailFactureService.retrieveAllDetailFacture().size());
        assertNotNull(df.getFacture().getIdFacture());
        assertNotNull(df.getFacture().getClient().getIdClient());
        assertNotNull(df.getProduit().getIdProduit());
        assertNotNull(df.getProduit().getRayon().getIdRayon());
        assertNotNull(df.getProduit().getStock().getIdStock());
        assertNotNull(df.getProduit().getDetailproduit().getIdDetailProduit());
    }



}