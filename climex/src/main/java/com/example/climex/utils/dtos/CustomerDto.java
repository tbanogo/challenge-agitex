package com.example.climex.utils.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSerialize
public class CustomerDto {

    private String nom;
    private String prenom;
    private int age;
    private String profession;
    private double salaire;

}
