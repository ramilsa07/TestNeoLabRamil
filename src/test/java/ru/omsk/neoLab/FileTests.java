package ru.omsk.neoLab;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTests {
    @Test
    public void checkRightRules() {
        List<Integer> rightAnswer = new ArrayList<>();
        rightAnswer.add(4);
        rightAnswer.add(1);
        rightAnswer.add(1);
        rightAnswer.add(2);
        Assert.assertArrayEquals(AnimalRegistrationSystem.registration(
                new File("testFiles/rules/rules.txt"),
                new File("testFiles/animals/animalFile.txt")).toArray(), rightAnswer.toArray());
    }

    @Test
    public void checkAnotherRules() {
        List<Integer> rightAnswer = new ArrayList<>();
        rightAnswer.add(0);
        Assert.assertArrayEquals(AnimalRegistrationSystem.registration(
                new File("testFiles/rules/anotherRules.txt"),
                new File("testFiles/animals/animalFile.txt")).toArray(), rightAnswer.toArray());
    }

    @Test
    public void checkWithoutORRules() {
        List<Integer> rightAnswer = new ArrayList<>();
        rightAnswer.add(0);
        Assert.assertArrayEquals(AnimalRegistrationSystem.registration(
                new File("testFiles/rules/withoutOR.txt"),
                new File("testFiles/animals/animalFile.txt")).toArray(), rightAnswer.toArray());
    }

    @Test
    public void checkParanormalAnimal() {
        List<Integer> rightAnswer = new ArrayList<>();
        rightAnswer.add(0);
        rightAnswer.add(0);
        rightAnswer.add(0);
        rightAnswer.add(0);
        Assert.assertArrayEquals(AnimalRegistrationSystem.registration(
                new File("testFiles/rules/rules.txt"),
                new File("testFiles/animals/paranormalAnimals.txt")).toArray(), rightAnswer.toArray());
    }

    @Test(expected = Exception.class)
    public void checkWrongRules() {
        Assert.assertArrayEquals(AnimalRegistrationSystem.registration(
                new File("testFiles/rules/wrongRules.txt"),
                new File("testFiles/animals/animalFile.txt")).toArray(), new ArrayList<>().toArray());
    }

    @Test(expected = Exception.class)
    public void checkManyORRules() {
        Assert.assertArrayEquals(AnimalRegistrationSystem.registration(
                new File("testFiles/rules/manyOR.txt"),
                new File("testFiles/animals/animalFile.txt")).toArray(), new ArrayList<>().toArray());
    }
}
