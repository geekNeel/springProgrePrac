package com.example.spd.springpostgredocker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spd.springpostgredocker.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
}
