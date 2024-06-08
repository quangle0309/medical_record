package service.impl;

import models.Patient;
import models.VipPatient;
import repositories.MedicalRecordRepo;
import service.IService;

public class VipPatientService implements IService<VipPatient> {

    private MedicalRecordRepo medicalRecordRepo = new MedicalRecordRepo();

    @Override
    public boolean add(VipPatient vipPatient) {
        if (vipPatient.getName().isEmpty() || vipPatient.getName().contains(",")) {
            return false;
        }
        if (!vipPatient.getIdMedicalRecord().matches(REGEX_ID_MEDICAL_RECORD)) {
            return false;
        }
        if (!vipPatient.getIdPatient().matches(REGEX_ID_PATIENT)) {
            return false;
        }
        if (!vipPatient.getDayIn().matches(REGEX_DAY)) {
            return false;
        }
        if (!vipPatient.getDayOut().matches(REGEX_DAY)) {
            return false;
        }
        if (vipPatient.getChiefComplaint().isEmpty() || vipPatient.getChiefComplaint().contains(",")) {
            return false;
        }
        if (!vipPatient.getTypeVip().matches("^VIP (I|II|III)$")) {
            return false;
        }
        for (Patient patient : medicalRecordRepo.getAll()) {
            if (patient.getIdPatient().equals(vipPatient.getIdPatient()) ||
                    patient.getIdMedicalRecord().equals(vipPatient.getIdMedicalRecord())) {
                return false;
            }
        }
        medicalRecordRepo.add(vipPatient);
        return true;
    }
}
