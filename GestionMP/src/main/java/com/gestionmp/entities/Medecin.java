package com.gestionmp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedecin;
	private String nomprenomM;
	private String adresseM;
	

	@JsonIgnore
	@OneToMany(mappedBy = "medecin")
	private List<Patient> patients;


	public Long getIdMedecin() {
		return idMedecin;
	}


	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}


	public String getNomprenomM() {
		return nomprenomM;
	}


	public void setNomprenomM(String nomprenomM) {
		this.nomprenomM = nomprenomM;
	}


	public String getAdresseM() {
		return adresseM;
	}


	public void setAdresseM(String adresseM) {
		this.adresseM = adresseM;
	}


	public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
