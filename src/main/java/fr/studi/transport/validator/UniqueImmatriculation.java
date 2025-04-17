package fr.studi.transport.validator;

import fr.studi.transport.validator.impl.UniqueImmatriculationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueImmatriculationValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueImmatriculation {

    String message() default "L'immatriculation est deja utilisée.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
