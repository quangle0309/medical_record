package service.impl;

import models.NormalPatient;

import models.Patient;
import repositories.MedicalRecordRepo;
import service.IService;

public class NormalPatientService implements IService<NormalPatient> {
    private MedicalRecordRepo medicalRecordRepo = new MedicalRecordRepo();

    @Override
    public boolean add(NormalPatient normalPatient) {
        if (normalPatient.getName().isEmpty() || normalPatient.getName().contains(",")) {
            return false;
        }
        if (!normalPatient.getIdMedicalRecord().matches(REGEX_ID_MEDICAL_RECORD)) {
            return false;
        }
        if (!normalPatient.getIdPatient().matches(REGEX_ID_PATIENT)) {
            return false;
        }
        if (!normalPatient.getDayIn().matches(REGEX_DAY)) {
            return false;
        }
        if (!normalPatient.getDayOut().matches(REGEX_DAY)) {
            return false;
        }
        if (normalPatient.getChiefComplaint().isEmpty() || normalPatient.getChiefComplaint().contains(",")) {
            return false;
        }
        if (normalPatient.getHospitalFee() < 0 || normalPatient.getHospitalFee() > 1000000000) {
            return false;
        }
        for (Patient patient : medicalRecordRepo.getAll()) {
            if (patient.getIdPatient().equals(normalPatient.getIdPatient()) ||
                    patient.getIdMedicalRecord().equals(normalPatient.getIdMedicalRecord())) {
                return false;
            }
        }
        medicalRecordRepo.add(normalPatient);
        return true;
    }
}
