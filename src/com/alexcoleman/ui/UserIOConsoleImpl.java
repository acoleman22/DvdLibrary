package com.alexcoleman.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    Scanner myScanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int intInput = myScanner.nextInt();
        myScanner.nextLine();
        return intInput;
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        System.out.println(prompt);
        String stringNumber = myScanner.nextLine();
        int number = Integer.parseInt(stringNumber);

        while (number < min || number > max) {
            System.out.println("please enter a number in the correct range ");
            stringNumber = myScanner.nextLine();
            number = Integer.parseInt(stringNumber);
        }
        return number;

    }

    @Override
    public double readDouble(String prompt) {

        System.out.println(prompt);
        String stringDouble = myScanner.nextLine();
        double doubleNumber = Double.parseDouble(stringDouble);

        return doubleNumber;

    }

    @Override
    public double readDouble(String prompt, double min, double max) {

        System.out.println(prompt);
        String stringDouble = myScanner.nextLine();
        double doubleNumber = Double.parseDouble(stringDouble);

        while (doubleNumber < min || doubleNumber > max) {
            System.out.println("Enter in the correct number range");
            stringDouble = myScanner.nextLine();
            doubleNumber = Double.parseDouble(stringDouble);

        }

        return doubleNumber;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String stringFloat = myScanner.nextLine();
        float decimalNumber = Float.parseFloat(stringFloat);

        return decimalNumber;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        String stringFloat = myScanner.nextLine();
        float decimalNumber = Float.parseFloat(stringFloat);

        while (decimalNumber < min || decimalNumber > max) {
            System.out.println("Enter in the correct number range");
            stringFloat = myScanner.nextLine();
            decimalNumber = Float.parseFloat(stringFloat);
        }
        return decimalNumber;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String stringLong = myScanner.nextLine();
        long longNumber = Long.parseLong(stringLong);

        return longNumber;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String stringLong = myScanner.nextLine();
        long longNumber = Long.parseLong(stringLong);

        while (longNumber < min || longNumber > max) {
            System.out.println("Enter in the correct number range");
            stringLong = myScanner.nextLine();
            longNumber = Long.parseLong(stringLong);

        }
        return longNumber;
    }
}
