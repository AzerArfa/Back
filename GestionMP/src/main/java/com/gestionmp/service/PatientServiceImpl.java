package com.gestionmp.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionmp.dto.PatientDTO;
import com.gestionmp.entities.Medecin;
import com.gestionmp.entities.Patient;
import com.gestionmp.repos.ImageRepository;
import com.gestionmp.repos.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
	ImageRepository imageRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Patient updatePatient(Patient p) {
    /*Long oldProdImageId =
    this.getPatient(p.getIdPatient()).getImage().getIdImage();
    Long newPatImageId = p.getImage().getIdImage();*/
    Patient patUpdated = patientRepository.save(p);
   /* if (oldPatImageId != newPatImageId) //si l'image a été modifiée
    imageRepository.deleteById(oldPatImageId);*/
    return patUpdated;
    }

    @Override
    public void deletePatient(Patient p) {
        patientRepository.delete(p);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient getPatient(Long id) {
    	return  patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> getAllPatients() {
    	return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByNomprenomP(String nom) {
        return patientRepository.findByNomprenomP(nom);
    }

    @Override
    public List<Patient> findByNomprenomPContains(String nom) {
        return patientRepository.findByNomprenomPContains(nom);
    }

    @Override
    public List<Patient> findByNomAge(String nom, int age) {
        return patientRepository.findByNomAge(nom, age);
    }

    @Override
    public List<Patient> findByMedecin(Medecin medecin) {
        return patientRepository.findByMedecin(medecin);
    }

    @Override
    public List<Patient> findByOrderByNomprenomPAsc() {
        return patientRepository.findByOrderByNomprenomPAsc();
    }

    @Override
    public List<Patient> trierPatientsNomsAge() {
        return patientRepository.trierPatientsNomsAge();
    }
    @Override
	public List<Patient> findByMedecinIdMedecin(Long id) {
		return patientRepository.findByMedecinIdMedecin(id);
	}
    

}
