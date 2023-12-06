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
import com.gestionmp.entities.Medecin;
import com.gestionmp.entities.Patient;
import com.gestionmp.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientRESTController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(path="all",method =RequestMethod.GET)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    //@GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatient(id);
    }
    @RequestMapping(value="/addpat",method = RequestMethod.POST)
    //@RequestMapping(method = RequestMethod.POST)
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
}
    @RequestMapping(value="/updatepat",method = RequestMethod.PUT)
    //@PutMapping
    public Patient updatePatient(@RequestBody Patient Patient) {
        return patientService.updatePatient(Patient);

    
    }
   
    @RequestMapping(value="/delpat/{id}",method = RequestMethod.DELETE)
    //@DeleteMapping("/{idPatient}")
    public void deletePatient(@PathVariable("idPatient") Long id) {
        patientService.deletePatientById(id);
    }
    @RequestMapping(value="/patsmed/{idMedecin}",method = RequestMethod.GET)
    public List<Patient> getPatientsByIdMedecin(@PathVariable("idMedecin") Long idMedecin) {
        return patientService.findByMedecinIdMedecin(idMedecin);
    }

    
    
    
    
}