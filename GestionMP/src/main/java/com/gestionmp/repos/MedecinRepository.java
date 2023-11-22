package com.gestionmp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionmp.entities.Medecin;
@RepositoryRestResource(path = "med")
@CrossOrigin("http://localhost:4200/")
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
