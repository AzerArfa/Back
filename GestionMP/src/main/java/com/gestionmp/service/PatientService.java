package com.gestionmp.service;
import java.util.List;

import com.gestionmp.dto.PatientDTO;
import com.gestionmp.entities.Medecin;
import com.gestionmp.entities.Patient;

public interface PatientService {
    PatientDTO savePatient(PatientDTO p);
    PatientDTO updatePatient(PatientDTO p);
    void deletePatient(Patient p);
    void deletePatientById(Long id);
    PatientDTO getPatient(Long id);
    List<PatientDTO> getAllPatients();
    List<Patient> findByNomprenomP(String nom);
    List<Patient> findByNomprenomPContains(String nom);
    List<Patient> findByNomAge(String nom, int age);
    List<Patient> findByMedecin(Medecin medecin);
    List<Patient> findByMedecinIdMedecin(Long id);
    List<Patient> findByOrderByNomprenomPAsc();
    List<Patient> trierPatientsNomsAge();
    PatientDTO convertEntityToDto (Patient patient);
    Patient convertDtoToEntity(PatientDTO patientDTO);
}
