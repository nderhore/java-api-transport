package fr.studi.transport.service;

import fr.studi.transport.pojo.Conducteur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ConducteurService {

    // declaration et initialisation d'une liste comportant des conducteurs
    private final List<Conducteur> conducteurList = new ArrayList<>();

    //mise en place d'un compteur qui sera utilisé pour positionner les id
    private final AtomicLong counter = new AtomicLong(1);

    public List<Conducteur> getAllConducteurs() {
        return conducteurList;
    }

    public Conducteur getConducteurById(Long id) {
        return conducteurList.stream()
                .filter(conducteur -> conducteur.getConducteurId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteConducteurById(Long id) {
        conducteurList.removeIf(conducteur -> conducteur.getConducteurId().equals(id));
    }

    public Conducteur createConducteur(Conducteur conducteur) {
        conducteur.setConducteurId(counter.getAndIncrement());
        conducteurList.add(conducteur);
        return conducteur;
    }



}
