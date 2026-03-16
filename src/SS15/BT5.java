import java.util.*;

public class BT5 {
    public class TreatmentStep {
        public String description;
        public String time;

        public TreatmentStep(String description, String time) {
            this.description = description;
            this.time = time;
        }

        @Override
        public String toString() {
            return time + " = " + description;
        }
    }

    public class Patient {
        public String name;

        public Patient(String name) {
            this.name = name;
        }
    }

    public class EmergencyCase {
        Patient patient;
        Stack<TreatmentStep> treatmentSteps = new Stack<>();

        public EmergencyCase(Patient patient) {
            this.patient = patient;
        }

        public void addStep(TreatmentStep step) {
            treatmentSteps.push(step);
        }

        public TreatmentStep undoStep() {
            if (!treatmentSteps.isEmpty()) {
                return treatmentSteps.pop();
            } else {
                System.out.println("Khong co buoc dieu tri can huy!");
                return null;
            }
        }

        public void displaySteps() {
            System.out.println("Cac buoc dieu tri cho benh nhan " + patient.name + ":");
            for (TreatmentStep step : treatmentSteps) {
                System.out.println(step);
            }
        }
    }

    public class EmergencyCaseQueue {
        Queue<EmergencyCase> cases = new LinkedList<>();

        public void addCase(EmergencyCase c) {
            cases.add(c);
        }

        public EmergencyCase callNextCase() {
            if (!cases.isEmpty()) {
                return cases.poll();
            } else {
                System.out.println("Khong co ca cap cuu nao trong hang doi!");
                return null;
            }
        }
    }

    public static void main(String[] args) {
        BT5 bt = new BT5();
        EmergencyCaseQueue caseQueue = bt.new EmergencyCaseQueue();
        EmergencyCase case1 = bt.new EmergencyCase(bt.new Patient("Nguyen Van A"));
        EmergencyCase case2 = bt.new EmergencyCase(bt.new Patient("Le Thi B"));

        caseQueue.addCase(case1);
        caseQueue.addCase(case2);

        EmergencyCase currentCase = caseQueue.callNextCase();

        currentCase.addStep(bt.new TreatmentStep("Kiem tra mach", "08:30"));
        currentCase.addStep(bt.new TreatmentStep("Cho cap cuu", "08:45"));
        currentCase.addStep(bt.new TreatmentStep("Truyen dich", "09:00"));

        currentCase.displaySteps();

        System.out.println("\nHuy buoc dieu tri sai: " + currentCase.undoStep());

        currentCase.displaySteps();
    }
}
