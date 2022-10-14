package com.usa.misiontic.ciclo3.controller;


import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getMachines(){
        return machineService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("id") int id){
        return machineService.getMachine(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine m){
        return machineService.save(m);
    }
}
