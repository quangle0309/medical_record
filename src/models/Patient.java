package models;

public class Patient {
    private int id;
    private String idMedicalRecord;
    private String idPatient;
    private String name;
    private String dayIn;
    private String dayOut;
    private String chiefComplaint;

    public Patient() {
    }

    public Patient(String idMedicalRecord,String idPatient, String name, String dayIn,
                   String dayOut, String chiefComplaint) {
        this.idMedicalRecord = idMedicalRecord;
        this.idPatient = idPatient;
        this.name = name;
        this.dayIn = dayIn;
        this.dayOut = dayOut;
        this.chiefComplaint = chiefComplaint;
    }

    public int getId() {
        return id;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdMedicalRecord() {
        return idMedicalRecord;
    }

    public void setIdMedicalRecord(String idMedicalRecord) {
        this.idMedicalRecord = idMedicalRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    public String getDayOut() {
        return dayOut;
    }

    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    @Override
    public String toString() {
        return  "STT: " + this.getId() +
                ", ID Bệnh Án: " + this.getIdMedicalRecord() +
                ", ID Bệnh Nhân: " + this.getIdPatient() +
                ", Tên Bệnh Nhân: " + this.getName() +
                ", Ngày Nhập Viện: " + this.getDayIn() +
                ", Ngày Xuất Viện: " + this.getDayOut() +
                ", Lý Do Nhập Viện: " + this.getChiefComplaint();
    }

    public String toCsv() {
        return this.getId() + "," +
                this.getIdMedicalRecord() + "," +
                this.getIdPatient() + "," +
                this.getName() + "," +
                this.getDayIn() + "," +
                this.getDayOut() + "," +
                this.getChiefComplaint();
    }
}
