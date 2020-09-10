package ru.omsk.neoLab;

import java.io.*;
import java.util.List;

public class AnimalCounter {
    public static int answer(final File animalFile, final List<String> rule) {
        int count = 0;
        try (BufferedReader animalReader = new BufferedReader(new FileReader(animalFile))) {
            String animal;
            while ((animal = animalReader.readLine()) != null) {
                if ((animal.contains(rule.get(0)) || animal.contains(rule.get(1))) && // первая часть правила
                        (animal.contains(rule.get(2)) || animal.contains(rule.get(3))) && // вторая часть
                        (animal.contains(rule.get(4)) || animal.contains(rule.get(5)))) { // третья часть
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
