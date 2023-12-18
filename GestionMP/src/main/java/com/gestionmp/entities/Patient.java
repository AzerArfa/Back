package com.gestionmp.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Patient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idPatient;
private String nomprenomP;
private String adresseP;
private int Age;
private String maladie;
@ManyToOne
private Medecin medecin;
/*@OneToOne
private Image image;*/
@OneToMany (mappedBy = "patient")
private List<Image> images;


public List<Image> getImages() {
	return images;
}
public void setImages(List<Image> images) {
	this.images = images;
}
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
public Patient(String nomprenomP, String adresseP, int Age, String maladie) {
	this.nomprenomP = nomprenomP;
	this.adresseP = adresseP;
	this.Age = Age;
	this.maladie = maladie;
}
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
public void setAge(int Age) {
	this.Age = Age;
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
@Override
public String toString() {
	return "Patient [idPatient=" + idPatient + ", nomprenomP=" + nomprenomP + ", adresseP=" + adresseP + ", Age="
			+ Age + ", maladie=" + maladie + "]";
}


}
