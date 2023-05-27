package lesson_6;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class NoteBook {
    String brand;
    String model;
    LinkedHashMap<String, String> spec;

    public NoteBook(String brand, String model, LinkedHashMap<String, String> spec) {
        this.brand = brand;
        this.model = model;
        this.spec = spec;
    }

    public NoteBook(String brand, String model, String specStr) {
        String[] specs = specStr.split(",");
        LinkedHashMap<String, String> resSpec = new LinkedHashMap<>();
        for (String spec : specs) {
            String[] splittedSpec = spec.split(":");
            resSpec.put(splittedSpec[0].trim(), splittedSpec[1].trim());
        }
        this.brand = brand;
        this.model = model;
        this.spec = resSpec;
    }

    public String printSpec() {
        StringBuilder result = new StringBuilder();
        result.append("(");
        for (String key : this.spec.keySet()) {
            result.append(key).append(": ").append(this.spec.get(key)).append(", ");
        }
        return result.delete(result.length() - 2, result.length()).append(");").toString();
    }

    public boolean filterEquality(HashMap<String, String> filter) {
        for (String field : filter.keySet()) {
            if (filter.get(field).chars().allMatch(Character::isDigit)) {
                if (!(Integer.parseInt(this.spec.get(field)) >= Integer.parseInt(filter.get(field))))
                    return false;
            }else{
                if (!this.spec.get(field).equals(filter.get(field))) return false;
            }

        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", brand, model, printSpec());
    }


}