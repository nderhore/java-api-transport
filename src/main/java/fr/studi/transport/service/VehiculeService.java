package fr.studi.transport.service;

import fr.studi.transport.pojo.Vehicule;
import fr.studi.transport.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAllVehicules(){
        return vehiculeRepository.findAll();
    }

    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).stream()
                .filter(vehicule -> vehicule.getVehiculeId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Vehicule createVehicule(Vehicule vehicule) {
        if(vehicule.getVehiculeId() == null){
            return vehiculeRepository.save(vehicule);
        } else {
            return null;
        }
    }

    public void deleteVehiculeById(Long id) {
        vehiculeRepository.deleteById(id);
    }


    public Vehicule getVehiculeByImmatriculation(String immatriculation) {
        return vehiculeRepository.findByImmatriculation(immatriculation);
    }

    public Vehicule updateVehiculeById(Long id, Vehicule vehicule) {
        //1. recuperer le vehicule
        Vehicule oldVehicule = this.getVehiculeById(id);
        if(oldVehicule != null){
            oldVehicule.setAnnee(vehicule.getAnnee());
            oldVehicule.setImmatriculation(vehicule.getImmatriculation());
            oldVehicule.setModele(vehicule.getModele());
            oldVehicule.setMarque(vehicule.getMarque());
            this.vehiculeRepository.save(oldVehicule);
        }
        return oldVehicule;
    }
}
