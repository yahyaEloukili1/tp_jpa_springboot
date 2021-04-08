package org.sid.tp_jpa_springBoot.dao;

import java.util.List;

import org.sid.tp_jpa_springBoot.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	public Page<Patient> findByNomContains(String name,Pageable pageable);
	
	public List<Patient> findByNomContainsAndMalade(String name,boolean b);
	public List<Patient> findByMalade(boolean b);
}
