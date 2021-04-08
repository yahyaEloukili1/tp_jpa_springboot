package org.sid.tp_jpa_springBoot.web;

import java.util.List;

import org.sid.tp_jpa_springBoot.dao.PatientRepository;
import org.sid.tp_jpa_springBoot.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	
	@GetMapping("/patients")
	public List<Patient> listPatients(){
		return patientRepository.findAll();
	}
	@GetMapping("/patients/{id}")
	public Patient listPatientsById(@PathVariable Long id){
		return patientRepository.findById(id).get();
	}
}
