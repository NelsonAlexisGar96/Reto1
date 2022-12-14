package com.usa.misiontic.ciclo3.repository;


import com.usa.misiontic.ciclo3.entities.Client;
import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.repository.crud.ClientCrudRepository;
import com.usa.misiontic.ciclo3.repository.crud.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {


    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client l){
        return clientCrudRepository.save(l);
    }
    public void delete(Client l){
        clientCrudRepository.delete(l);
    }

}
