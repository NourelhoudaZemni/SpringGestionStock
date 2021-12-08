package tn.esprit.firstapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstapp.DAO.entity.Facture;
import tn.esprit.firstapp.service.interfaces.IFactureService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/facture")
public class FactureRestController {
    @Autowired
    IFactureService factureService;


    // http://localhost:8081/SpringMVC/servlet/facture/retrieve-active-factures
    @GetMapping("/retrieve-active-factures")
    public List<Facture> getFacturesActifs() {
        return factureService.retrieveFactureActif();
    }

    // http://localhost:8081/SpringMVC/servlet/facture/retrieve-not-active-factures
    @GetMapping("/retrieve-not-active-factures")
    public List<Facture> getFacturesNonActifs() {
        return factureService.retrieveNonActif();
    }

    @GetMapping("/retrieve-all-factures")
    public List<Facture> getFactures() {
        return factureService.retrieveAllFacture();
    }

    // http://localhost:8081/SpringMVC/servlet/facture/retrieve-facture/1
    @GetMapping("/retrieve-facture/{facture-id}")
    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }

    // http://localhost:8081/SpringMVC/servlet/facture/add-facture
    @PostMapping("/add-facture")
    public Facture addFacture(@RequestBody Facture f)
    {
        return factureService.addFacture(f);
    }

    // http://localhost:8081/SpringMVC/servlet/facture/modify-facture
    @PutMapping("/modify-facture")
    public Facture modifyClient(@RequestBody Facture facture) {
        return factureService.updateFacture(facture);
    }

    // http://localhost:8081/SpringMVC/servlet/facture/remove-facture/{facture-id}
    @DeleteMapping("/remove-facture/{facture-id}")
    public void removeFacture(@PathVariable("facture-id") Long factureId) {
        factureService.deleteFacture(factureId);
    }

    @GetMapping("/recherche-active-factures/{nom}")
    public List<Facture> rechercheFacturesActifs(@PathVariable("nom") String nom) {
        return factureService.rechercheFactureActifs(nom);
    }

    @GetMapping("/recherche-non-active-factures/{nom}")
    public List<Facture> rechercheFacturesNonActifs(@PathVariable("nom") String nom) {
        return factureService.rechercheFactureNonActifs(nom);
    }



}

