package fr.studi.transport.ws;

import fr.studi.transport.pojo.Vehicule;
import fr.studi.transport.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.API + ApiRegistration.REST_VEHICULE)
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    /**
     * retourne tous les vehicules
     * @return une liste de vehicule
     */
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    /**
     * retourne un seul vehicule
     * @return un vehicule
     */
    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id){
        return vehiculeService.getVehiculeById(id);
    }

    @PostMapping
    public Vehicule createVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.createVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    public void deleteVehiculeById(@PathVariable Long id){
        vehiculeService.deleteVehiculeById(id);
    }

    @GetMapping(ApiRegistration.REST_IMMATRICULATION + "/{immatriculation}")
    public Vehicule getVoitureByImmatriculation(@PathVariable String immatriculation){
        return vehiculeService.getVehiculeByImmatriculation(immatriculation);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehiculeById(@PathVariable Long id, @RequestBody Vehicule vehicule){
        return vehiculeService.updateVehiculeById(id,vehicule);
    }



}
