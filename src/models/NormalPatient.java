package models;

public class NormalPatient extends Patient {
    private double hospitalFee;

    public NormalPatient() {
    }

    public NormalPatient(String idHealRecord,
                         String idPatient,
                         String name,
                         String dayIn,
                         String dayOut,
                         String chiefComplaint,
                         double hospitalFee) {
        super(idHealRecord,idPatient, name, dayIn, dayOut, chiefComplaint);
        this.hospitalFee = hospitalFee;
    }

    public double getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(double hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

    @Override
    public String toString() {
        return super.toString() + ", Viện Phí: " + hospitalFee;
    }

    public String toCsv() {
        return  super.toCsv() + "," + this.getHospitalFee();
    }
}
