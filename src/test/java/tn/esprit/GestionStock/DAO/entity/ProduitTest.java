package tn.esprit.firstapp.DAO.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.firstapp.service.interfaces.IDetailProduitService;
import tn.esprit.firstapp.service.interfaces.IProduitService;
import tn.esprit.firstapp.service.interfaces.IRayonService;
import tn.esprit.firstapp.service.interfaces.IStockService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProduitTest {

    @Autowired
    IStockService stockService ;
    @Autowired
    IRayonService rayonService ;
    @Autowired
    IDetailProduitService detailProduitService;
    @Autowired
    IProduitService produitService ;

    @Test
    public void addProduitTest(){
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

        int expectedSize = produitService.retrieveAllProduit().size();
        Produit p = new Produit();
        p.setRayon(r);
        p.setStock(s);
        p.setCodeProduit("nour");
        p.setLibelleProduit("Test");
        p.setPrixUnitaire(10);
        p.setDetailproduit(dp);
        p = produitService.addProduit(p,r.getIdRayon(),s.getIdStock());
        assertEquals(expectedSize+1, produitService.retrieveAllProduit().size());
        assertNotNull(p.getIdProduit());
        produitService.deleteProduit(p.getIdProduit());
        detailProduitService.deleteDetailProduit(dp.getIdDetailProduit());
        stockService.deleteStock(s.getIdStock());
        rayonService.deleteRayon(r.getIdRayon());
    }

}