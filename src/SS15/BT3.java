import java.util.Stack;

public class BT3 {
    public class MedicationProcessChecker {
        private final Stack<String> stack = new Stack<>();

        public boolean checkProcess(String[] actions) {
            reset();

            for (String action : actions) {
                if (action.equalsIgnoreCase("PUSH")) {
                    stack.push("MEDICATION");
                }
                else if (action.equalsIgnoreCase("POP")) {
                    if (stack.isEmpty()) {
                        System.out.println("Error: No medication to pop.");
                        return false; 
                    }
                    stack.pop();
                }
                else {
                    System.out.println("Error: Invalid action '" + action + "'.");
                    return false; 
                }
            }
            if (!stack.isEmpty()) {
                System.out.println("Error: Unmatched PUSH actions remaining.");
                return false; 
            }

            System.out.println("Medication process is valid.");
            return true;
        }

        private void reset() {
            stack.clear();
        }
    }

    public static void main(String[] args) {
        BT3 bt3 = new BT3();
        MedicationProcessChecker checker = bt3.new MedicationProcessChecker();

        String[] actions1 = {"PUSH", "PUSH", "POP", "POP"};
        System.out.println("Test Case 1:");
        checker.checkProcess(actions1);

        String[] actions2 = {"PUSH", "POP", "POP"};
        System.out.println("\nTest Case 2:");
        checker.checkProcess(actions2);

        String[] actions3 = {"PUSH", "PUSH", "POP"};
        System.out.println("\nTest Case 3:");
        checker.checkProcess(actions3);

        String[] actions4 = {"PUSH", "INVALID_ACTION"};
        System.out.println("\nTest Case 4:");
        checker.checkProcess(actions4);
    }
}
