package ru.omsk.neoLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringProcessor {
    /**
     * Метод преобразует строку с правилами в массив условий
     * @param rule
     * @return
     */
    public static List<String> stringsRuleToList(final String rule) {
        List<String> partsRule;
        List<String> allParts = new ArrayList<>();
        try {
            partsRule = Arrays.asList(rule.split(", ")); // делим правило на части
            if (partsRule.size() != 3) {
                throw new Exception();
            }
            for (String s : partsRule) {
                if (s.contains("OR")) {
                    if (s.split(" OR ").length != 2) {
                        throw new Exception();
                    }
                    allParts.add(s.split(" OR ")[0]);
                    allParts.add(s.split(" OR ")[1]);
                } else if (s.equals("")) {
                    allParts.add("");
                    allParts.add("");
                } else {
                    allParts.add(s);
                    allParts.add("ANY");
                }
            }
        } catch (Exception e) {
            System.out.println("Not a standard string");
        }
        return allParts;
    }
}
