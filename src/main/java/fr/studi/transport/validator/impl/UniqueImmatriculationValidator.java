package fr.studi.transport.validator.impl;

import fr.studi.transport.repository.VehiculeRepository;
import fr.studi.transport.validator.UniqueImmatriculation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueImmatriculationValidator implements ConstraintValidator<UniqueImmatriculation, String> {


    private final VehiculeRepository vehiculeRepository;

    public UniqueImmatriculationValidator(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public boolean isValid(String immatriculation, ConstraintValidatorContext constraintValidatorContext) {
        if(immatriculation == null || immatriculation.isBlank()) {
            return true;
        }
        return !vehiculeRepository.existsByImmatriculation(immatriculation);
    }
}
