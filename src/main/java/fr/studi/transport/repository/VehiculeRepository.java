package fr.studi.transport.repository;

import fr.studi.transport.pojo.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    Vehicule findByImmatriculation(String immatriculation);

    boolean existsByImmatriculation(String immatriculation);
}
