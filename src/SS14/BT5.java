package SS14;

import java.util.Comparator;
import java.util.TreeSet;

class Patient {
    private String name;
    private int severity;
    private String arrivalTime;

    public Patient(String name, int severity, String arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    public String getName() { return name; }
    public int getSeverity() { return severity; }
    public String getArrivalTime() { return arrivalTime; }

    @Override
    public String toString() {
        String severityText = (severity == 1) ? "Nguy kịch" : (severity == 2 ? "Nặng" : "Nhẹ");
        return "Bệnh nhân " + name + " (Mức " + severity + " - " + severityText + ", đến lúc " + arrivalTime + ")";
    }
}

public class BT5 {
    public static void main(String[] args) {

        TreeSet<Patient> emergencyQueue = new TreeSet<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                int severityCompare = Integer.compare(p1.getSeverity(), p2.getSeverity());
                if (severityCompare != 0) {
                    return severityCompare;
                }

                int timeCompare = p1.getArrivalTime().compareTo(p2.getArrivalTime());
                if (timeCompare != 0) {
                    return timeCompare;
                }

                return p1.getName().compareTo(p2.getName());
            }
        });

        emergencyQueue.add(new Patient("A", 3, "08:00"));
        emergencyQueue.add(new Patient("B", 1, "08:15"));
        emergencyQueue.add(new Patient("C", 1, "08:05"));

        System.out.println("Output (Thứ tự xử lý):");
        for (Patient p : emergencyQueue) {
            System.out.println(p.toString());
        }
    }
}