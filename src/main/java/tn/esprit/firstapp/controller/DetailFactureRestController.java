package tn.esprit.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstapp.DAO.entity.DetailFacture;
import tn.esprit.firstapp.service.interfaces.IDetailFactureService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/detailfacture")
public class DetailFactureRestController {
    @Autowired
    IDetailFactureService detailFactureService ;

    //  http://localhost:8081/SpringMVC/servlet/detailfacture/retrieve-all-detailfacture
    @GetMapping("/retrieve-all-detailfacture")
    public List<DetailFacture> getDetailFactures() {
        return detailFactureService.retrieveAllDetailFacture();
    }

    // http://localhost:8081/SpringMVC/servlet/detailfacture/retrieve-detailfacture/1
    @GetMapping("/retrieve-detailfacture/{detailFacture-id}")
    public DetailFacture retrieveDetailFacture(@PathVariable("detailFacture-id") Long idDetailFacture) {
        return detailFactureService.retrieveDetailFacture(idDetailFacture);
    }
    // http://localhost:8081/SpringMVC/servlet//retrieve-detailfactureByFactureId/1
    @GetMapping("/retrieve-detailfactureByFactureId/{Facture-id}")
    public List<DetailFacture> retrieveDetailFactureByFacture(@PathVariable("Facture-id") Long idFacture) {
        return detailFactureService.retrieveAllDetailFactureByFacture(idFacture);
    }

    // http://localhost:8081/SpringMVC/servlet/detailfacture/add-detailfacture
    @PostMapping("/add-detailfacture")
    public DetailFacture addDetailFacture(@RequestBody DetailFacture d)
    {
        return detailFactureService.addDetailFacture(d);
    }

    // http://localhost:8081/SpringMVC/servlet/detailfacture/modify-detailfacture
    @PutMapping("/modify-detailfacture")
    public DetailFacture modifyDetailFacture(@RequestBody DetailFacture detailfacture) {
        return detailFactureService.updateDetailFacture(detailfacture);
    }

    // http://localhost:8081/SpringMVC/servlet/detailfacture/remove-detailfacture/{detailfacture-id}
    @DeleteMapping("/remove-detailfacture/{detailfacture-id}")
    public void removeDetailFacture(@PathVariable("detailfacture-id") Long DetailFactureId) {
        detailFactureService.deleteDetailFacture(DetailFactureId);
    }
    /*************************/


    /*
    IMPORTANT !
For testing.. to see instructions or start testing you'll find an example in the ClientRestController

    {
    "qte": 2,
    "prixTotal":15,
    "pourcentageRemise": 15,
    "montantRemise": 15,
    "facture": {
        "idFacture":1
    },
    "produit":{
        "idProduit":1

    }
}
     */

}
