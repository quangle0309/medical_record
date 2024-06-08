package views;

import models.NormalPatient;
import models.Patient;
import models.VipPatient;

import java.util.List;
import java.util.Scanner;

public class MedicalRecordView {
    Scanner sc = new Scanner(System.in);
    String idHealRecord;
    String idPatient;
    String name;
    String dayIn;
    String dayOut;
    String chiefComplaint;

    public int mainMenuView() {
        System.out.println("------------------HỒ-SƠ-BỆNH-ÁN------------------");
        System.out.print("\n");
        System.out.println("1.\tTHÊM MỚI HỒ SƠ");
        System.out.println("2.\tXÓA HỒ SƠ");
        System.out.println("3.\tHIỂN THỊ DANH SÁCH BỆNH ÁN");
        System.out.println("0.\tTHOÁT");
        System.out.print("\n");

        int choice = -1;
        do {
            try {
                System.out.println("Nhập lựa chọn của bạn: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 3) {
                    System.err.println("Lựa chọn không hợp lệ!!!");
                    System.out.print("\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn phải là số nguyên!!!");
                System.out.print("\n");
            } catch (Exception e) {
                System.err.println("Thao tác thất bại!!! Lỗi chưa tìm ra nguyên nhân!!!");
            }
        } while (choice < 0 || choice > 3);
        return choice;
    }

    public int menuViewAdd() {
        System.out.println("-------------THÊM-HỒ-SƠ-------------");
        System.out.print("\n");
        System.out.println("1.\tBỆNH NHÂN THƯỜNG");
        System.out.println("2.\tBỆNH NHÂN VIP");
        System.out.println("0.\tTRỞ LẠI MENU CHÍNH");
        System.out.print("\n");
        int choice = -1;
        do {
            try {
                System.out.println("Nhập lựa chọn của bạn: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 2) {
                    System.err.println("Lựa chọn không hợp lệ!!!");
                    System.out.print("\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn phải là số nguyên!!!");
                System.out.print("\n");
            } catch (Exception e) {
                System.err.println("Thao tác thất bại!!! Lỗi chưa tìm ra nguyên nhân!!!");
            }
        } while (choice < 0 || choice > 2);
        return choice;
    }

    public void patientIn() {
        System.out.println("Nhập vào mã bệnh án (BA-XXX): ");
        idHealRecord = sc.nextLine();
        System.out.println("Nhập vào mã bệnh nhân (BN-XXX): ");
        idPatient = sc.nextLine();
        System.out.println("Nhập vào tên bệnh nhân: ");
        name = sc.nextLine();
        System.out.println("Nhập vào ngày nhập viện (dd/MM/yy): ");
        dayIn = sc.nextLine();
        System.out.println("Nhập vào ngày xuất viện (dd/MM/yy): ");
        dayOut = sc.nextLine();
        System.out.println("Nhập vào lý do nhập viện: ");
        chiefComplaint = sc.nextLine();
    }

    public NormalPatient viewNormalAdd() {
        patientIn();
        double hospitalFee = -1;
        while (hospitalFee == -1) {
            try {
                System.out.println("Nhập vào tiền viện phí: ");
                hospitalFee = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Tiền viện phí phải là số!!!");
            }
        }
        return new NormalPatient(idHealRecord, idPatient, name, dayIn, dayOut, chiefComplaint, hospitalFee);
    }

    public VipPatient viewVipAdd() {
        patientIn();
        System.out.println("Nhập vào loại VIP (VIP I, VIP II, VIP III): ");
        String typeVip = sc.nextLine();
        int dayVip = -1;
        while (dayVip == -1) {
            try {
                System.out.println("Nhập vào thời hạn VIP (ngày): ");
                dayVip = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Thời hạn vip phải là một số nguyên!!!");
            }
        }
        return new VipPatient(idHealRecord, idPatient, name, dayIn, dayOut, chiefComplaint, typeVip, dayVip);
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Tác vụ thành công!!!");
            System.out.print("\n");
        } else {
            System.err.println("Tác vụ thất bại!!!");
            System.out.print("\n");
        }
    }

    public void displayAllPatient(List<Patient> patients) {

        if (patients.isEmpty()) {
            System.out.println("Không có hồ sơ.");
            System.out.print("\n");
        } else {
            System.out.println("---------------DANH-SÁCH-BỆNH-NHÂN---------------");
            System.out.print("\n");
            for (Patient patient: patients) {
                System.out.println(patient.toString());
            }
        }
    }

    public int viewRemove() {
        do {
            System.out.println("Nhập số thứ tự bệnh án cần xóa: ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Số thứ tự là một số nguyên!!!");
                System.out.print("\n");
            }
        } while (true);
    }

    public boolean confirmRemove() {
        do {
            System.out.println("Xác nhận xóa nhấn 'Y', hủy bỏ nhấn 'N'!");
            String confirm = sc.nextLine();
            confirm = confirm.toUpperCase();
            if (confirm.equals("Y")) {
                return true;
            } else if (confirm.equals("N")) {
                return false;
            } else {
                System.err.println("Vui lòng nhập chính xác lựa chọn!!!");
                System.out.print("\n");
            }
        } while (true);
    }

    public void notFoundId() {
        System.err.println("Không tìm thấy hồ sơ cần xóa!!!");
        System.out.print("\n");
    }
}
