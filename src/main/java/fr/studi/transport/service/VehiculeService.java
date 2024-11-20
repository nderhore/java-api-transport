package fr.studi.transport.service;

import fr.studi.transport.pojo.Vehicule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VehiculeService {

    // declaration et initialisation d'une liste comportant des vehicules
    private final List<Vehicule> vehiculeList = new ArrayList<>();

    //mise en place d'un compteur qui sera utilisé pour positionner les id
    private final AtomicLong counter = new AtomicLong(1);

    public List<Vehicule> getAllVehicules(){
        return vehiculeList;
    }

    public Vehicule getVehiculeById(Long id) {
        return vehiculeList.stream()
                .filter(vehicule -> vehicule.getVehiculeId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Vehicule createVehicule(Vehicule vehicule) {
        vehicule.setVehiculeId(counter.getAndIncrement()); // id = 1 , le suivant , aura 2
        vehiculeList.add(vehicule);
        return vehicule;
    }

    public void deleteVehiculeById(Long id) {
        vehiculeList.removeIf(vehicule -> vehicule.getVehiculeId().equals(id));
    }


}
