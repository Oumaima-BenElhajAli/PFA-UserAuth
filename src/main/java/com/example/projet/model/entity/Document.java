package com.example.projet.model.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "DOCUMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Document implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
    private String id;
    @Column(name="nom")
    private String nom;
    @Column(name="type")
    private String type;
    @Column(name="dateCreation")
    private Date dateCreation;
    @Column(name="taille")
    private double taille;

    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_typedoc")
    private TypeDoc typeDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_section")
    private Section section;

    public Document(String nom, String type, byte[] data, Date dateCreation,double taille) {
        this.nom = nom;
        this.type = type;
        this.data = data;
        this.dateCreation=dateCreation;
        this.taille=taille;
    }

}
