package SS13;

import java.util.LinkedList;

public class BT4 {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        System.out.println("--- Quá trình tiếp nhận ---");
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        System.out.println("\n--- Bác sĩ bắt đầu xử lý ---");
        er.treatPatient(); // Xử lý C
        er.treatPatient(); // Xử lý A
        er.treatPatient(); // Xử lý B
    }
}

class EmergencyRoom {
    private LinkedList<String> patients = new LinkedList<>();
    public void patientCheckIn(String name) {
        patients.addLast("Đang khám: " + name);
        System.out.println("CheckIn " + name);
    }

    public void emergencyCheckIn(String name) {
        patients.addFirst("Đang cấp cứu: " + name);
        System.out.println("Emergency " + name);
    }

    public void treatPatient() {
        if (!patients.isEmpty()) {
            String patient = patients.removeFirst();
            System.out.println(patient);
        } else {
            System.out.println("Không còn bệnh nhân nào trong hàng đợi.");
        }
    }
}