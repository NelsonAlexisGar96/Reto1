package com.usa.misiontic.ciclo3.controller;


import com.usa.misiontic.ciclo3.entities.Client;
import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.service.ClientService;
import com.usa.misiontic.ciclo3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {



    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClient(){
        return clientService.getAll();
    }
    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable("idClient") int idClient){
        return clientService.getClient(idClient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client l){
        return clientService.save(l);
    }
}
