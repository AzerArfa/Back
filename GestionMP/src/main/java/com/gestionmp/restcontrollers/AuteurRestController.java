package com.gestionmp.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionmp.entities.Auteur;
import com.gestionmp.repos.AuteurRepository;


@RestController
@RequestMapping("/listAll")
public class AuteurRestController {
	@Autowired
	AuteurRepository auteurRepository;
	@RequestMapping(method =RequestMethod.GET)
	public List<Auteur> getAllAuteurs()
	{
	return auteurRepository.findAll();
	}
}
