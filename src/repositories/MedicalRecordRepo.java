package repositories;

import models.NormalPatient;
import models.Patient;
import models.VipPatient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordRepo {

    public void add(Patient patient) {
        List<Patient> patients = new ArrayList<>();
        patient.setId(countId());
        patients.add(patient);
        writeFile(patients, true);
    }

    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        File file = new File("src/data/patient.csv");
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            Patient patient;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 8) {
                    patient = new NormalPatient(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], Double.parseDouble(temp[7]));
                    patient.setId(Integer.parseInt(temp[0]));
                } else {
                    patient = new VipPatient(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], Integer.parseInt(temp[8]));
                    patient.setId(Integer.parseInt(temp[0]));
                }
                patients.add(patient);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khômng tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
        return patients;
    }

    public boolean checkId(int id) {
        List<Patient> patients = getAll();
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void removeById(int id) {
        List<Patient> patients = getAll();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.remove(i);
                break;
            }
        }
        writeFile(patients, false);
    }

    public int countId() {
        File file = new File("src/data/patient.csv");
        int count = 1;
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file!!!");
        } catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu!!!");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println("Lỗi đóng file!!!");
                }
            }
        }
        return count;
    }

    private void writeFile(List<Patient> Patients, boolean append) {
        File file = new File("src/data/patient.csv");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Patient element: Patients) {
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi ghi file");
            System.out.print("\n");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.err.println("Lỗi đóng file");
                    System.out.print("\n");
                }
            }
        }
    }
}
