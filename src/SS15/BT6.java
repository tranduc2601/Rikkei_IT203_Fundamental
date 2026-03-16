import java.util.*;

public class BT6 {
    public static class Patient {
        public String id;
        public String name;
        public int age;
        public String gender;

        public Patient(String id, String name, int age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class PatientWaitingQueue {
        Queue<Patient> waitingQueue = new LinkedList<>();
        int totalPatients = 0;

        void addPatient(Patient p) {
            waitingQueue.add(p);
            totalPatients++;
        }

        Patient nextPatient() {
            if (!waitingQueue.isEmpty()) {
                totalPatients--;
                return waitingQueue.poll();
            }
            return null;
        }
    }

    public static class EditAction {
        String description;
        String editedBy;
        String editTime;

        public EditAction(String description, String editedBy, String editTime) {
            this.description = description;
            this.editedBy = editedBy;
            this.editTime = editTime;
        }

        @Override
        public String toString() {
            return editTime + " - " + description + " (" + editedBy + ")";
        }
    }

    public static class MedicalRecordHistory {
        public String recordId;
        Stack<EditAction> editStack = new Stack<>();

        public MedicalRecordHistory(String recordId) {
            this.recordId = recordId;
        }

        void addEdit(EditAction e) {
            editStack.push(e);
        }

        EditAction undoEdit() {
            return editStack.isEmpty() ? null : editStack.pop();
        }
    }

    public static class Ticket {
        int ticketNumber;
        String issuedTime;

        public Ticket(int ticketNumber, String issuedTime) {
            this.ticketNumber = ticketNumber;
            this.issuedTime = issuedTime;
        }

        @Override
        public String toString() {
            return "So " + ticketNumber + " (" + issuedTime + ")";
        }
    }

    public static class TicketSystem {
        Queue<Ticket> ticketQueue = new LinkedList<>();
        int currentNumber = 0;

        public Ticket issueTicket(String time) {
            currentNumber++;
            Ticket t = new Ticket(currentNumber, time);
            ticketQueue.add(t);
            return t;
        }

        public Ticket callNext() {
            return ticketQueue.poll();
        }
    }

    public static class InputAction {
        String fieldName;
        String oldValue;
        String newValue;
        String actionTime;

        public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
            this.fieldName = fieldName;
            this.oldValue = oldValue;
            this.newValue = newValue;
            this.actionTime = actionTime;
        }

        @Override
        public String toString() {
            return actionTime + " - " + fieldName + ": " + oldValue + " -> " + newValue;
        }
    }

    public static class UndoManager {
        Stack<InputAction> undoStack = new Stack<>();
        int maxUndoSteps;

        public UndoManager(int maxUndoSteps) {
            this.maxUndoSteps = maxUndoSteps;
        }

        void addAction(InputAction a) {
            if (undoStack.size() == maxUndoSteps) {
                undoStack.remove(0); 
            }
            undoStack.push(a);
        }

        InputAction undo() {
            return undoStack.isEmpty() ? null : undoStack.pop();
        }
    }

        public static void main(String[] args) {
            PatientWaitingQueue waitingQueue = new PatientWaitingQueue();
            waitingQueue.addPatient(new Patient("P1", "Lan", 30, "Nu"));
            waitingQueue.addPatient(new Patient("P2", "Duy", 45, "Nam"));

            System.out.println("Benh nhan tiep theo: " + waitingQueue.nextPatient());

            MedicalRecordHistory history = new MedicalRecordHistory("HS001");
            history.addEdit(new EditAction("Cap nhat chuan doan", "Bac Si A", "08:10"));
            history.addEdit(new EditAction("Them thuoc", "Bac Si B", "08:20"));

            System.out.println("Undo chinh sua hanh dong: " + history.undoEdit());

            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.issueTicket("08:00");
            ticketSystem.issueTicket("08:25");

            System.out.println("Goi nguoi tiep theo: " + ticketSystem.callNext());

            UndoManager undoManager = new UndoManager(3);
            undoManager.addAction(new InputAction("Tuoi", "29", "30", "08:30"));
            undoManager.addAction(new InputAction("Dia chi", "HN", "HCM", "08:35"));

            System.out.println("Undo nhap lieu: " + undoManager.undo());
    }
}
