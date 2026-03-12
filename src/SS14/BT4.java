package SS14;

import java.util.LinkedList;

public class BT4 {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        System.out.println("CheckIn A");
        er.patientCheckIn("A");

        System.out.println("CheckIn B");
        er.patientCheckIn("B");

        System.out.println("Emergency C");
        er.emergencyCheckIn("C");

        System.out.println("treatPatient() x3");
        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}

class EmergencyRoom {
    private LinkedList<String> patients = new LinkedList<>();

    public void patientCheckIn(String name) {
        patients.addLast("Đang khám: " + name);
    }

    public void emergencyCheckIn(String name) {
        patients.addFirst("Đang cấp cứu: " + name);
    }

    public void treatPatient() {
        if (!patients.isEmpty()) {
            System.out.println(patients.removeFirst());
        } else {
            System.out.println("Hàng đợi trống.");
        }
    }
}