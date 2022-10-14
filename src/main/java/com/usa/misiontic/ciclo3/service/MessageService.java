package com.usa.misiontic.ciclo3.service;


import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.entities.Message;
import com.usa.misiontic.ciclo3.repository.MachineRepository;
import com.usa.misiontic.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {



    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message e){
        if (e.getIdMessage()==null){
            return messageRepository.save(e);
        }else{
            Optional<Message>maux=messageRepository.getMessage(e.getIdMessage());
            if (maux.isEmpty()){
                return messageRepository.save(e);
            }else{
                return e;
            }
        }
    }
}


