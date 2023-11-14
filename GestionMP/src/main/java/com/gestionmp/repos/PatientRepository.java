package com.gestionmp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gestionmp.entities.Medecin;
import com.gestionmp.entities.Patient;
@RepositoryRestResource(path = "rest")
public interface PatientRepository extends JpaRepository<Patient, Long> {
	List<Patient> findByNomprenomP(String nom);
	 List<Patient> findByNomprenomPContains(String nom); 
	 @Query("select pat from Patient pat where pat.nomprenomP like %?1 and pat.Age > ?2")
	 List<Patient> findByNomAge (String nom, int age);
	 @Query("select p from Patient p where p.medecin = ?1")
	 List<Patient> findByMedecin(Medecin medecin);
	 List<Patient> findByMedecinIdMedecin(Long id);
	 List<Patient> findByOrderByNomprenomPAsc();
	 @Query("SELECT p FROM Patient p ORDER BY p.nomprenomP ASC, p.Age DESC")
	 List<Patient> trierPatientsNomsAge();
	 
}
