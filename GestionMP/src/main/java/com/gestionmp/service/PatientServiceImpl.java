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
import com.gestionmp.repos.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public PatientDTO savePatient(PatientDTO p) {
        return convertEntityToDto(patientRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public PatientDTO updatePatient(PatientDTO p) {
    	return convertEntityToDto(patientRepository.save(convertDtoToEntity(p)));
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
    public PatientDTO getPatient(Long id) {
    	return convertEntityToDto( patientRepository.findById(id).get());
    }

    @Override
    public List<PatientDTO> getAllPatients() {
    	return patientRepository.findAll().stream()
    			.map(this::convertEntityToDto)
    			.collect(Collectors.toList());
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
    @Override
    public PatientDTO convertEntityToDto(Patient patient) {
     /*PatientDTO PatientDTO = new PatientDTO();
     PatientDTO.setIdPatient(patient.getIdPatient());
     PatientDTO.setNomprenomP(patient.getNomprenomP());
     PatientDTO.setAdresseP(patient.getAdresseP());
     //PatientDTO.setAge(patient.getAge());
     PatientDTO.setMaladie(patient.getMaladie());
     //PatientDTO.setMedecin(patient.getMedecin());
     return PatientDTO;*/
     
     /*return PatientDTO.builder()
     .idPatient(patient.getIdPatient())
     .nomprenomP(patient.getNomprenomP())
     .adresseP(patient.getAdresseP())
     .Age(patient.getAge())
     .maladie(patient.getMaladie())
     .medecin(patient.getMedecin())
     .nommedecin(patient.getMedecin().getNomprenomM())
     .build();*/
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
        if (patient.getMedecin() != null) {
            patientDTO.setNommedecin(patient.getMedecin().getNomprenomM());
        }
        return patientDTO;
    
    }
    @Override
    public Patient convertDtoToEntity(PatientDTO patientDto) {
    	Patient patient = new Patient();
    	patient = modelMapper.map(patientDto, Patient.class);
    	patient.setIdPatient(patientDto.getIdPatient());
    	patient.setAdresseP(patientDto.getAdresseP());
    	patient.setMaladie(patientDto.getMaladie());
    	patient.setMedecin(patientDto.getMedecin());
    	patient.setAge(patientDto.getAge());
     return patient;
    }

}
