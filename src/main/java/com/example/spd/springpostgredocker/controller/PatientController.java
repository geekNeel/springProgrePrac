package com.example.spd.springpostgredocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spd.springpostgredocker.exception.ResouceNotFoundException;
import com.example.spd.springpostgredocker.model.Patient;
import com.example.spd.springpostgredocker.repo.PatientRepository;

@RestController
@RequestMapping("/healthcare")
public class PatientController {

	@Autowired
	private PatientRepository patientrepo;
	
	
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientrepo.save(patient);
    }


    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientrepo.findAll());
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable(value = "id") Integer patientId) {
        Patient Patient = patientrepo.findById(patientId).orElseThrow(
                () -> new ResouceNotFoundException("Patient not found" + patientId));
        return ResponseEntity.ok().body(Patient);
    }

    @PutMapping("patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Integer patientId,
                                                   @RequestBody Patient patientDetails) {
        Patient patient = patientrepo.findById(patientId)
                .orElseThrow(() -> new ResouceNotFoundException("Patient not found for this id :: " + patientId));
        patient.setName(patientDetails.getName());
        final Patient updatedPatient = patientrepo.save(patient);
        return ResponseEntity.ok(updatedPatient);

    }

    @DeleteMapping("patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable(value = "id") Integer patientId) {
        Patient patient = patientrepo.findById(patientId).orElseThrow(
                () -> new ResouceNotFoundException("Patient not found" + patientId));
        patientrepo.delete(patient);
        return ResponseEntity.ok().build();
    }
    
	
}
