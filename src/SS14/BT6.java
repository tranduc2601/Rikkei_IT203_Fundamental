package SS14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HospitalPatient {
    private String name;
    private String department; // Tên khoa

    public HospitalPatient(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Patient(" + name + ")";
    }
}

public class BT6 {
    public static void main(String[] args) {
        List<HospitalPatient> patients = new ArrayList<>();
        patients.add(new HospitalPatient("Lan", "Tim mạch"));
        patients.add(new HospitalPatient("Hùng", "Nội tiết"));
        patients.add(new HospitalPatient("Mai", "Tim mạch"));
        Map<String, List<HospitalPatient>> departmentMap = new HashMap<>();

        for (HospitalPatient p : patients) {
            String deptName = p.getDepartment();

            if (!departmentMap.containsKey(deptName)) {
                departmentMap.put(deptName, new ArrayList<>());
            }
            departmentMap.get(deptName).add(p);

        }

        System.out.println("Output Map Structure:");
        for (Map.Entry<String, List<HospitalPatient>> entry : departmentMap.entrySet()) {
            System.out.println("Key \"" + entry.getKey() + "\" -> Value " + entry.getValue());
        }

        String maxDept = "";
        int maxPatients = 0;

        for (Map.Entry<String, List<HospitalPatient>> entry : departmentMap.entrySet()) {
            int currentSize = entry.getValue().size();
            if (currentSize > maxPatients) {
                maxPatients = currentSize;
                maxDept = entry.getKey();
            }
        }

        System.out.println("\nOutput Analysis: \"Khoa " + maxDept + " đang đông nhất (" + maxPatients + " bệnh nhân)\".");
    }
}