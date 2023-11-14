package com.gestionmp.entities;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomprenomP", types = { Patient.class })
public interface PatientProjection {
	public String getNomprenomP();
}
