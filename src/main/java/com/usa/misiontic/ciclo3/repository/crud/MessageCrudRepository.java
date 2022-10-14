package com.usa.misiontic.ciclo3.repository.crud;

import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository  extends CrudRepository<Message,Integer> {
}
