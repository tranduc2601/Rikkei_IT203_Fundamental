import java.util.*;

public class BT4 {
    public class EmergencyPatient {
        private final String id;
        private final String name;
        private final int priority;

        public EmergencyPatient(String id, String name, int priority) {
            this.id = id;
            this.name = name;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return id + " - " + name + (priority == 1 ? " (High)" : " (Low)");
        }
    }

    public class EmergencyQueue {
        private final Queue<EmergencyPatient> emergencyQueue = new LinkedList<>();
        private final Queue<EmergencyPatient> normalQueue = new LinkedList<>();

        public void addPatient(EmergencyPatient p) {
            if (p.getPriority() == 1) {
                emergencyQueue.offer(p);
            } else {
                normalQueue.offer(p);
            }
        }

        public EmergencyPatient callNextPatient() {
            if (!emergencyQueue.isEmpty()) {
                return emergencyQueue.poll();
            } else if (!normalQueue.isEmpty()) {
                return normalQueue.poll();
            } else {
                System.out.println("No patients in the queue.");
                return null;
            }
        }

        public void displayQueue() {
            System.out.println("Cap cuu:");
            for (EmergencyPatient p : emergencyQueue) {
                System.out.println(p);
            }
            System.out.println("Binh thuong:");
            for (EmergencyPatient p : normalQueue) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        BT4 bt4 = new BT4();
        EmergencyQueue queue = bt4.new EmergencyQueue();

        queue.addPatient(bt4.new EmergencyPatient("P001", "Alice", 1));
        queue.addPatient(bt4.new EmergencyPatient("P002", "Bob", 2));
        queue.addPatient(bt4.new EmergencyPatient("P003", "Charlie", 1));
        queue.addPatient(bt4.new EmergencyPatient("P004", "David", 2));

        System.out.println("Thu tu kham:");
        queue.displayQueue();

        System.out.println("\nGoi benh nhan tiep theo:");
        System.out.println(queue.callNextPatient());

        System.out.println("\nHang doi sau khi goi benh nhan:");
        queue.displayQueue();
    }
}
