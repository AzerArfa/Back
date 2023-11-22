package com.gestionmp.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionmp.dto.PatientDTO;
import com.gestionmp.entities.Medecin;
import com.gestionmp.entities.Patient;
import com.gestionmp.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientRESTController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }
    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatient(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.savePatient(patientDTO);
}
    @PutMapping
    public PatientDTO updatePatient(@RequestBody PatientDTO patientDTO) {
        return patientService.updatePatient(patientDTO);

    
    }
    @RequestMapping(value="/patsByName/{nomprenomP}",method = RequestMethod.GET)
    public List<Patient> findByNomPatientContains(@PathVariable("nomprenomP") String nom) {
    return patientService.findByNomprenomPContains(nom);
    }
    
    @DeleteMapping("/{idPatient}")
    public void deletePatient(@PathVariable("idPatient") Long id) {
        patientService.deletePatientById(id);
    }
    @RequestMapping(value="/patsmed/{idMedecin}",method = RequestMethod.GET)
    public List<Patient> getPatientsByIdMedecin(@PathVariable("idMedecin") Long idMedecin) {
        return patientService.findByMedecinIdMedecin(idMedecin);
    }

    
    
    
    
}