package com.usa.misiontic.ciclo3.service;


import com.usa.misiontic.ciclo3.entities.Machine;
import com.usa.misiontic.ciclo3.entities.Reservation;
import com.usa.misiontic.ciclo3.repository.CountClient;
import com.usa.misiontic.ciclo3.repository.MachineRepository;
import com.usa.misiontic.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {



    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if (r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation>raux=reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> old = reservationRepository.getReservation(r.getIdReservation());
            if (old.isPresent()) {
                Reservation k = old.get();

                if (r.getStartDate() != null) {
                    k.setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    k.setDevolutionDate(r.getDevolutionDate());
                }

                if (r.getStatus() != null) {
                    k.setStatus(r.getStatus());
                }

                return reservationRepository.save(k);

            }
        }
        return r;
    }

    public boolean delete(int id) {
        Optional<Reservation> cp = reservationRepository.getReservation(id);
        if (cp.isPresent()) {
            reservationRepository.delete(cp.get());
            return true;
        }
        return false;
    }

    public Status getReservationStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationByStatus("cancelled");
        return new Status (completed.size(),cancelled.size());
    }

    public List<Reservation> informePeriodoTiempoReservas(String dataA, String dataB){
        SimpleDateFormat parser =new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(dataA);
            b = parser.parse(dataB);
        } catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.informePeriodoTiempoReservas(a, b);
        }else{
            return new ArrayList<>();
        }
    }

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClient();
    }

}
