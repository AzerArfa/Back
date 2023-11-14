package com.gestionmp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestionmp.entities.Medecin;
import com.gestionmp.entities.Patient;
import com.gestionmp.repos.PatientRepository;

@SpringBootTest
class GestionMpApplicationTests {

	@Autowired
	private PatientRepository patientRepository;

	@Test
	public void testCreatePatient() {
		Patient pat = new Patient("Foulen Fouleni","Tunis, Ben Arous",25,"Fievre");
		patientRepository.save(pat);
		}

	@Test
	public void testFindPatient()
	{
		Patient pat = patientRepository.findById(1L).get();
	System.out.println(pat);
	}
	@Test
	public void testUpdatePatient()
	{
	Patient pat = patientRepository.findById(1L).get();
	pat.setAge(22);
	patientRepository.save(pat);
	}
	@Test
	public void testDeletePatient()
	{
		patientRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousPatients()
	{
	List<Patient> patients = patientRepository.findAll();
	for (Patient pat : patients)
	{
	System.out.println(pat);
	}
	}

	 @Test
	 public void testFindByNomPatient()
	 {
	 List<Patient> pats = patientRepository.findByNomprenomP("Foulen Fouleni");
	 for (Patient pat : pats)
	 {
	 System.out.println(pat);
	 }
	 }
	 @Test
	 public void testFindByNomContains ()
	 {
	 List<Patient> pats=patientRepository.findByNomprenomPContains("F");
	 for (Patient pat : pats)
	 {
	 System.out.println(pat);
	 } }
	 @Test
	 public void testfindByNomAge()
	 {
	 List<Patient> pats = patientRepository.findByNomAge("Foulen Fouleni", 22);
	 for (Patient pat : pats)
	 {
	 System.out.println(pat);
	 }
	 }

	 @Test
	 public void testfindByMedecin()
	 {
	Medecin med = new Medecin();
	med.setIdMedecin(1L);
	 List<Patient> pats = patientRepository.findByMedecin(med);
	 for (Patient pat : pats)
	 {
	 System.out.println(pat);
	 }
	 }
	 @Test
	 public void findByMedecinIdMedecin()
	 {
	 List<Patient> pats = patientRepository.findByMedecinIdMedecin(1L);
	 for (Patient pat : pats)
	 {
	 System.out.println(pat);
	 }
	  }
	 @Test
	 public void testfindByOrderByNomprenomPAsc()
	 {
	 List<Patient> pats = patientRepository.findByOrderByNomprenomPAsc();
	 for (Patient pat : pats)
	 {
	 System.out.println(pat);
	 }
	 }
	 @Test
	 public void testTrierPatientsNomsAge() {
	     List<Patient> patients = patientRepository.trierPatientsNomsAge();
	     for (Patient patient : patients) {
	         System.out.println(patient);
	     }
	 }
}
