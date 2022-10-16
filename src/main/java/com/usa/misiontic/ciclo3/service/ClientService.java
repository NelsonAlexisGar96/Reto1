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
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> old= clientRepository.getClient(c.getIdClient());
            if(old.isPresent()){
                Client k=old.get();

                if(c.getAge()!=null){
                    k.setAge(c.getAge());
                }
                if(c.getPassword()!=null){
                    k.setPassword(c.getPassword());
                }

                if(c.getEmail()!=null){
                    k.setEmail(c.getEmail());
                }
                if(c.getName()!=null){
                    k.setName(c.getName());
                }

                return clientRepository.save(k);
            }
        }
        return c;
    }

    public boolean delete(int id) {
        Optional<Client> cOp = clientRepository.getClient(id);
        if (cOp.isPresent()) {
            clientRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
}
