import java.util.*;

public class BT1 {
    static class EditAction {
        private String description;
        private String time;

        public EditAction(String description, String time) {
            this.description = description;
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public String getTime() {
            return time;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return time + " - " + description;
        }
    }

    static class MedicalRecordHistory {
        private final Stack<EditAction> history = new Stack<>();

        public void addEdit(EditAction action) {
            history.push(action);
        }

        public EditAction undoEdit() {
            if (!history.isEmpty()) {
                return history.pop();
            }
            return null;
        }

        public EditAction getLastestEdit() {
            if (!history.isEmpty()) {
                return history.peek();
            }
            return null;
        }

        public boolean isEmpty() {
            return history.isEmpty();
        }

        public void displayHistory() {
            if (history.isEmpty()) {
                System.out.println("Khong co lich su chinh sua nao!");
            } else {
                System.out.println("Lich su chinh sua:");
                for (EditAction action : history) {
                    System.out.println(action);
                }
            }
        }
    }

    public static void main(String[] args) {
        MedicalRecordHistory recordHistory = new MedicalRecordHistory();
        recordHistory.addEdit(new EditAction("Thay doi dia chi", "2024-06-01 10:00"));
        recordHistory.addEdit(new EditAction("Cap nhat so dien thoai", "2024-06-01 11:00"));
        System.out.println("Chinh sua gan nhat la: " + recordHistory.getLastestEdit());
        System.out.println("Undo chinh sua: " + recordHistory.undoEdit());
        recordHistory.displayHistory();
    }
}