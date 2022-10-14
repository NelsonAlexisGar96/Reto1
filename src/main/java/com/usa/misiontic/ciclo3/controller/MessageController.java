package com.usa.misiontic.ciclo3.controller;


import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.entities.Message;
import com.usa.misiontic.ciclo3.service.MachineService;
import com.usa.misiontic.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {


    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageService.getAll();
    }
    @GetMapping("/{idMessage}")
    public Optional<Message> getMessage(@PathVariable("idMessage") int idMessage){
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message e){
        return messageService.save(e);
    }
}
