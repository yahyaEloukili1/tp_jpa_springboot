package org.sid.tp_jpa_springBoot;

import java.util.Date;
import java.util.List;

import org.sid.tp_jpa_springBoot.dao.PatientRepository;
import org.sid.tp_jpa_springBoot.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class TpJpaSpringBootApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"HASSAN",new Date(),3,false));
		patientRepository.save(new Patient(null,"anass",new Date(),2344,true));
		patientRepository.save(new Patient(null,"IMANE",new Date(),3444,false));
		patientRepository.save(new Patient(null,"AYMANE",new Date(),3443,true));
		patientRepository.save(new Patient(null,"YASIN",new Date(),35555,false));
		
		Page<Patient> patientsPage = patientRepository.findAll(PageRequest.of(0, 2));
		List<Patient> patients1 = patientsPage.getContent();
		patients1.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println(patientsPage.getTotalPages()+"ùùùùùùùùùùùùùùùùùùùùùùùùùùùùù");
		System.out.println("****************************");
		Patient patient = patientRepository.findById(1L).get();
		System.out.println(patient.toString());
		System.out.println("*************************");
		Page<Patient> patients2Page = patientRepository.findByNomContains("A",PageRequest.of(0, 5));
		
		patients2Page.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("malades *************************");
		List<Patient> patients2 = patientRepository.findByMalade(true);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});

		
		System.out.println("malades et contains *************************");
		List<Patient> patients3 = patientRepository.findByNomContainsAndMalade("A",true);
		patients3.forEach(p->{
			System.out.println(p.toString());
		});
		
		patientRepository.deleteById(5L);
		
		
		
		
		
		
	}

}
