package models;

public class VipPatient extends Patient {
    private String typeVip;
    private int dayVip;

    public VipPatient(){
    }

    public VipPatient(String idMedicalRecord,
                      String idPatient,
                      String name,
                      String dayIn,
                      String dayOut,
                      String chiefComplaint,
                      String typeVip,
                      int dayVip) {
        super(idMedicalRecord, idPatient, name, dayIn, dayOut, chiefComplaint);
        this.typeVip = typeVip;
        this.dayVip = dayVip;
    }

    public String getTypeVip() {
        return typeVip;
    }

    public void setTypeVip(String typeVip) {
        this.typeVip = typeVip;
    }

    public int getDayVip() {
        return dayVip;
    }

    public void setDayVip(int dayVip) {
        this.dayVip = dayVip;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loại VIP: " + this.typeVip + ", Thời Hạn VIP: " + this.dayVip + " ngày";
    }

    public String toCsv() {
        return super.toCsv() + "," + this.getTypeVip() + "," + this.getDayVip();
    }
}
