package service;

import models.Patient;

public interface IService<T extends Patient> {
    String REGEX_ID_MEDICAL_RECORD = "^BA-\\d{3}$";
    String REGEX_ID_PATIENT = "^BN-\\d{3}$";
    String REGEX_DAY = "^(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|1[012])[/](\\d{4})$";

    boolean add (T t);

}
