package SS14;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class BT3 {
    public static void main(String[] args) {
        Set<String> medicineIngredients = new LinkedHashSet<>(Arrays.asList("Aspirin", "Caffeine", "Paracetamol"));
        Set<String> patientAllergies = new LinkedHashSet<>(Arrays.asList("Penicillin", "Aspirin"));
        Set<String> warningSet = new LinkedHashSet<>(medicineIngredients);
        warningSet.retainAll(patientAllergies);

        System.out.println("Cảnh báo dị ứng: " + warningSet);
        Set<String> safeSet = new LinkedHashSet<>(medicineIngredients);
        safeSet.removeAll(patientAllergies);
        System.out.println("Thành phần an toàn: " + safeSet);
    }
}