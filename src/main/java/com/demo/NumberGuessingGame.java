package com.demo;

import java.util.Scanner;

/**
 * Created by spyarasani on 6/5/16.
 *
 * Number Guessing Game Rules:
 *  Yes - To quit the game
 *  Higher - It will generate higher number than the previous one.
 *  Lower - It will generate lower number than the previous one.
 */
public class NumberGuessingGame {

    public static void main(String args[]) {
        boolean result = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Number Guessing Game.");
        System.out.println("Select the Range for Today's Game.");
        HighLowLogic highLowLogic = new HighLowLogic(scan.nextInt());

        while(!result) {
            result = highLowLogic.guess(scan.next());
        }
    }
}
