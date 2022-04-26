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
@Table(name = "SECTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Section implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Niveau id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_generator")
    @SequenceGenerator(name = "sec_generator", sequenceName = "sec_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idSection", updatable = false, nullable = false)
    private Long idSection ;

    @Column(name="libelle")
    private String libelle ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIVEAU", nullable = false)
    private Niveau niveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPECIALITE", nullable = false)
    private Specialite specialite;

    @OneToMany(mappedBy="section")
    private List<Document> documents;

}
