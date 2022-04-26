package com.example.projet.rest.dto;

import com.example.projet.model.entity.Section;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecialiteDto {

    private Long idSpec ;
    private String libelle ;
    private List<Section> sections;
}
