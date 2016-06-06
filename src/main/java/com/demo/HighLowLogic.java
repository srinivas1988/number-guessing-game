package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by spyarasani on 6/5/16.
 *
 * High Low Logic used for Number Guessing Logic.
 *
 * Rules:
 *  Yes - To quit the game
 *  Higher - It will generate higher number than the previous one.
 *  Lower - It will generate lower number than the previous one.
 */
public class HighLowLogic {

    /**
     * Random Number
     */
    private int randomNumber = 0;

    /**
     * Minimum Number for Random Generator
     */
    private int minNumber = 0;

    /**
     * Maximum Number for Random Generator
     */
    private int maxNumber;

    /**
     * List of Random Numbers so far generated
     */
    private List randomNumbers = new ArrayList();

    /**
     * Default Constructor
     */
    public HighLowLogic(int maxNumber) {
        this.maxNumber = maxNumber;
        generateRandomNumber(minNumber, maxNumber);
    }

    /**
     * This method generates the random number and also checks
     * if duplicates found will generate new number which is not present in list
     * @param min minimum number
     * @param max maximum number
     */
    private void generateRandomNumber(int min, int max) {
        Random random = new Random();
        randomNumber = (int) (Math.random() * ((max - min) + 1) + min);
        if (isDuplicate(randomNumber)) {
            randomNumber = (int) (Math.random() * ((max - min) + 1) + min);
        } else {
            randomNumbers.add(randomNumber);
        }
        System.out.println("Computer: Is the number " + this.randomNumber + "?");
    }

    /**
     * This method checks the logic for user answers (lower/higher/yes)
     *  Yes - To quit the game
     *  Higher - It will generate higher number than the previous one.
     *  Lower - It will generate lower number than the previous one.
     *
     * @param answer can be lower/higher/yes
     * @return true if answer is yes
     */
    public boolean guess(String answer) {
        System.out.println("Answer: " + answer);
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Congratulations You have Won The Game!!!!");
            return true;
        } else if (answer.equalsIgnoreCase("higher")) {
            if (randomNumber == maxNumber - 1) {
                System.out.println("You have reached maximum range. So please enter lower!!!");
            } else {
                minNumber = randomNumber;
                generateRandomNumber(minNumber, maxNumber);
            }
            return false;
        } else if (answer.equalsIgnoreCase("lower")) {
            if (randomNumber == 0) {
                System.out.println("You have reached Minimum range. So please enter higher!!!");
            } else {
                maxNumber = randomNumber;
                generateRandomNumber(minNumber, maxNumber);
            }
            return false;
        } else {
            System.out.println("Wrong Answer Please Try Again...");
            return false;
        }
    }

    /**
     * Checks whether the generate number is duplicate or not.
     * @param number random number
     * @return true if generated number is already present in the list.
     */
    private boolean isDuplicate(int number) {
        if (randomNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}