import java.util.LinkedList;
import java.util.Queue;

public class BT2 {
    static class Patient {
        private String id;
        private String name;
        private int age;

        public Patient(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setId(String id) {
            this.id = id;
        }   

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + age;
        }
    }

    static class PatientQueue {
        private final Queue<Patient> queue = new LinkedList<>();

        public void addPatient(Patient patient) {
            queue.add(patient);
        }

        public Patient callNextPatient() {
            return queue.isEmpty() ? null : queue.poll();
        }

        public Patient peekNextPatient() {
            return queue.isEmpty() ? null : queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void displayQueue() {
            if (queue.isEmpty()) {
                System.out.println("Khong co benh nhan nao dang cho kham.");
            } else {
                System.out.println("Danh sach benh nhan dang cho kham:");
                for (Patient patient : queue) {
                    System.out.println(patient);
                }
            }
        }
    }

    public static void main(String[] args) {
        PatientQueue patientQueue = new PatientQueue();
        patientQueue.addPatient(new Patient("P001", "Nguyen Van A", 30));
        patientQueue.addPatient(new Patient("P002", "Le Thi B", 25));
        patientQueue.addPatient(new Patient("P003", "Tran Van C", 40));

        patientQueue.displayQueue();

        System.out.println("Goi benh nhan tiep theo: " + patientQueue.callNextPatient());
        System.out.println("Benh nhan tiep theo trong queue: " + patientQueue.peekNextPatient());

        patientQueue.displayQueue();
    }
}
