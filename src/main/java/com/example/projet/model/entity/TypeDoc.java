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
@Table(name = "TYPEDOC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeDoc implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Type id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_generator")
    @SequenceGenerator(name = "type_generator", sequenceName = "type_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idTypeDoc", updatable = false, nullable = false)
    private Long idTypeDoc ;

    @Column(name="libelle")
    private String libelle ;

    @OneToMany(mappedBy="typeDoc")
    private List<Document> documents;


}
