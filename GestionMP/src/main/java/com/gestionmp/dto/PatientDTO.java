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
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public String getNomprenomP() {
		return nomprenomP;
	}
	public void setNomprenomP(String nomprenomP) {
		this.nomprenomP = nomprenomP;
	}
	public String getAdresseP() {
		return adresseP;
	}
	public void setAdresseP(String adresseP) {
		this.adresseP = adresseP;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getMaladie() {
		return maladie;
	}
	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public String getNommedecin() {
		return nommedecin;
	}
	public void setNommedecin(String nommedecin) {
		this.nommedecin = nommedecin;
	}
	
}
