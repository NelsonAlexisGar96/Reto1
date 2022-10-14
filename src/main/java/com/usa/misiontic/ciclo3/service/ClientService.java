package com.usa.misiontic.ciclo3.service;


import com.usa.misiontic.ciclo3.entities.Client;
import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.repository.ClientRepository;
import com.usa.misiontic.ciclo3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client l){
        if (l.getIdClient()==null){
            return clientRepository.save(l);
        }else{
            Optional<Client>laux=clientRepository.getClient(l.getIdClient());
            if (laux.isEmpty()){
                return clientRepository.save(l);
            }else{
                return l;
            }
        }
    }
}
