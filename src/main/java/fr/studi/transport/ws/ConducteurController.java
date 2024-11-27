package fr.studi.transport.ws;

import fr.studi.transport.pojo.Conducteur;
import fr.studi.transport.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.API + ApiRegistration.REST_CONDUCTEUR)
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @GetMapping
    public List<Conducteur> getConducteurs() {
        return conducteurService.getAllConducteurs();
    }

    @GetMapping("/{id}")
    public Conducteur getConducteurById(@PathVariable Long id) {
        return conducteurService.getConducteurById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConducteurById(@PathVariable Long id) {
        conducteurService.deleteConducteurById(id);
    }

    @PostMapping
    public Conducteur createConducteur(@RequestBody Conducteur conducteur) {
        return conducteurService.createConducteur(conducteur);
    }

    @PutMapping("/{id}")
    public Conducteur updateConducteurById(@PathVariable Long id, @RequestBody Conducteur conducteur) {
        return conducteurService.updateConducteurById(id,conducteur);
    }
}
