package com.usa.misiontic.ciclo3.repository.crud;

import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository  extends CrudRepository<Reservation,Integer> {
}
