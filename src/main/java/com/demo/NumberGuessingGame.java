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
        int range = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Number Guessing Game.\n");
        System.out.print("Enter the Range for Today's Game: ");
        range = scan.nextInt();
        System.out.print("Type ready whenever you want to start: ");
        HighLowLogic highLowLogic = new HighLowLogic(range, scan.next());

        while(!result) {
            result = highLowLogic.guess(scan.next());
        }
    }
}
