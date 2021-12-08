package tn.esprit.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstapp.DAO.entity.Produit;
import tn.esprit.firstapp.service.interfaces.IProduitService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produit")
public class ProduitRestController {
    @Autowired
    IProduitService produitService;

    // http://localhost:8081/SpringMVC/servlet/produit/retrieve-all-produits
    @GetMapping("/retrieve-all-produits")
    public List<Produit> getProduits() {
        return produitService.retrieveAllProduit();
    }

    // http://localhost:8081/SpringMVC/servlet/produit/retrieve-produit/1
    @GetMapping("/retrieve-produit/{produit-id}")
    public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
        return produitService.retrieveProduit(produitId);
    }

    // http://localhost:8081/SpringMVC/servlet/produit/add-produit
    @PostMapping("/add-produit")
    public Produit addProduit(@RequestBody Produit p)
    {
        return produitService.addProduit(p,p.getRayon().getIdRayon(),p.getStock().getIdStock());
    }

    // http://localhost:8081/SpringMVC/servlet/produit/modify-produit
    @PutMapping("/modify-produit")
    public Produit modifyProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    // http://localhost:8081/SpringMVC/servlet/produit/remove-produit/{produit-id}
    @DeleteMapping("/remove-produit/{produit-id}")
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    /************************/
    /*
IMPORTANT !
For testing.. to see instructions or start testing you'll find an example in the ClientRestController

   {
    "codeProduit": "test",
    "libelleProduit":"test",
    "prixUnitaire": 15,
    "stock": {
        "idStock":1
    },
    "rayon": {
        "idRayon":1
    },
    "detailproduit":{
        "idDetailProduit":1

    }
}
     */
}