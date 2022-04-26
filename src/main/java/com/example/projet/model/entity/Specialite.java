package com.example.projet.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "SPECIALITE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Specialite implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Niveau id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spe_generator")
    @SequenceGenerator(name = "spe_generator", sequenceName = "spe_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idSpec", updatable = false, nullable = false)
    private Long idSpec ;

    @Column(name="libelle")
    private String libelle ;

    @OneToMany(mappedBy="specialite")
    private List<Section> sections;

}
