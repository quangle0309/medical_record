package service;

import models.Patient;
import repositories.MedicalRecordRepo;

import java.util.List;

public class MedicalRecordService {
    private MedicalRecordRepo medicalRecordRepo = new MedicalRecordRepo();

    public void removeById(int id) {
        medicalRecordRepo.removeById(id);
    }

    public List<Patient> getAll() {
        return medicalRecordRepo.getAll();
    }
}
