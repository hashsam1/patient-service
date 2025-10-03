package com.example.patient_service.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;
@Service
public class PatientService {

    private PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create a new patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        existingPatient.setName(patientDetails.getName());

        existingPatient.setGender(patientDetails.getGender());
        existingPatient.setPhoneNumber(patientDetails.getPhoneNumber());
        existingPatient.setAge(patientDetails.getAge());
        return patientRepository.save(existingPatient);
    }

    public void deletePatient(Long id) {

        patientRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return patientRepository.findById(id).isPresent(); // returns true if patient exists, false if not
    }


}

