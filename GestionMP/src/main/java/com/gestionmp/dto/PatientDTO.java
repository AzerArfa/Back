package com.gestionmp.dto;

import com.gestionmp.entities.Medecin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
	private Long idPatient;
	private String nomprenomP;
	private String adresseP;
	private int Age;
	private String maladie;
	private Medecin medecin;
	private String nommedecin;
}
