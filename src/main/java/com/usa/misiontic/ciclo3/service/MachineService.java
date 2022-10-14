package com.usa.misiontic.ciclo3.service;


import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine m){
        if (m.getId()==null){
            return machineRepository.save(m);
        }else{
            Optional<Machine>maux=machineRepository.getMachine(m.getId());
            if (maux.isEmpty()){
                return machineRepository.save(m);
            }else{
                return m;
            }
        }
    }
}
