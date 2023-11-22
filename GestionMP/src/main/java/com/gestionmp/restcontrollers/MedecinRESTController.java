package com.gestionmp.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionmp.entities.Medecin;
import com.gestionmp.repos.MedecinRepository;

@RestController
@RequestMapping("/api/med")
@CrossOrigin("*")
public class MedecinRESTController {
	@Autowired
	MedecinRepository medecinRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Medecin> getAllMedecins()
	{
	return medecinRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Medecin getMedecinById(@PathVariable("id") Long id) {
	return medecinRepository.findById(id).get();
	}

}
