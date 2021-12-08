package tn.esprit.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstapp.DAO.entity.Client;
import tn.esprit.firstapp.service.interfaces.IClientService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/client")
public class ClientRestController {
    @Autowired
    IClientService clientService;


    // http://localhost:8081/SpringMVC/servlet/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    // http://localhost:8081/SpringMVC/servlet/client/retrieve-client/1
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    // http://localhost:8081/SpringMVC/servlet/client/add-client
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c)
    {
        return clientService.addClient(c);
    }

    // http://localhost:8081/SpringMVC/servlet/client/modify-client
    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    // http://localhost:8081/SpringMVC/servlet/client/remove-client/{client-id}
    @DeleteMapping("/remove-client/{client-id}")

    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.deleteClient(clientId);
    }


}
