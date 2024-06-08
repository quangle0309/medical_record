package controllers;

import models.NormalPatient;
import models.VipPatient;
import repositories.MedicalRecordRepo;
import service.MedicalRecordService;
import service.impl.NormalPatientService;
import service.impl.VipPatientService;
import views.MedicalRecordView;

public class MainController {
    public static void main(String[] args) {
        MedicalRecordView medicalRecordView = new MedicalRecordView();
        NormalPatientService normalPatientService = new NormalPatientService();
        VipPatientService vipPatientService = new VipPatientService();
        MedicalRecordRepo medicalRecordRepo = new MedicalRecordRepo();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        NormalPatient normalPatient;
        VipPatient vipPatient;
        boolean result;
        int choice;

        while (true) {
            choice = medicalRecordView.mainMenuView();
            switch (choice) {
                case 1:
                    choice = medicalRecordView.menuViewAdd();
                    if (choice == 1) {
                        normalPatient = medicalRecordView.viewNormalAdd();
                        result = normalPatientService.add(normalPatient);
                        medicalRecordView.viewMessage(result);
                    } else if (choice == 2) {
                       vipPatient = medicalRecordView.viewVipAdd();
                       result = vipPatientService.add(vipPatient);
                        medicalRecordView.viewMessage(result);
                    } else {
                        break;
                    }
                    break;
                case 2:
                    int id = medicalRecordView.viewRemove();
                    if(medicalRecordRepo.checkId(id)) {
                        result = medicalRecordView.confirmRemove();
                        if (result) {
                            medicalRecordService.removeById(id);
                            medicalRecordView.viewMessage(true);
                        } else {
                            break;
                        }
                    } else {
                        medicalRecordView.notFoundId();
                    }
                    break;
                case 3:
                    medicalRecordView.displayAllPatient(medicalRecordService.getAll());
                    break;
                case 0:
                    return;
            }
        }
    }
}
