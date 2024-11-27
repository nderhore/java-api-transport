package fr.studi.transport.service;

import fr.studi.transport.pojo.Conducteur;
import fr.studi.transport.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    public List<Conducteur> getAllConducteurs() {
        return conducteurRepository.findAll();
    }

    public Conducteur getConducteurById(Long id) {
        return conducteurRepository.findById(id).stream()
                .filter(conducteur -> conducteur.getConducteurId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteConducteurById(Long id) {
        conducteurRepository.deleteById(id);
    }

    public Conducteur createConducteur(Conducteur conducteur) {
        if((conducteur.getConducteurId()) == null) {
            return conducteurRepository.save(conducteur);
        } else{
         return null;
        }
    }


    public Conducteur updateConducteurById(Long id, Conducteur conducteur) {
        Conducteur oldConducteur = getConducteurById(id);
        if(oldConducteur != null) {
            oldConducteur.setNom(conducteur.getNom());
            oldConducteur.setPrenom(conducteur.getPrenom());
            oldConducteur.setVehiculeId(conducteur.getVehiculeId());
            return conducteurRepository.save(oldConducteur);
        }
        return oldConducteur;
    }
}
