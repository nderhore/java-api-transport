package fr.studi.transport.pojo;

import fr.studi.transport.validator.UniqueImmatriculation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "immatriculation")
        }
)
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculeId;

    private String marque;
    private String modele;
    private Integer annee;

    @Column(unique = true,nullable = false)
    @UniqueImmatriculation
    private String immatriculation;
}
