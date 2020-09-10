package ru.omsk.neoLab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalRegistrationSystem {

    public static List<Integer> registration(final File rules, final File animal) {
        List<Integer> answer = new ArrayList<>();
        try (BufferedReader rulesReader = new BufferedReader(new FileReader(rules))) {
            String rule;
            List<String> partsRule;
            int countRules = 1;
            while ((rule = rulesReader.readLine()) != null) {
                partsRule = StringProcessor.stringsRuleToList(rule);
                answer.add(AnimalCounter.answer(animal, partsRule));
                System.out.println(answer.get(countRules - 1) +
                        " animals found by " + countRules + " rule");
                countRules++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
