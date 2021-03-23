package tech.alexey.java.finance;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    public static double checkDouble() {
        Scanner to = new Scanner(System.in);
        double num;
        try {
            num = to.nextDouble();
            if (num < 0) {
                System.out.print("Введите положительное число: ");
                return checkDouble();
            } else {
                return num;
            }
        } catch (InputMismatchException e) {
            System.out.print("Введите число: ");
            return checkDouble();
        }
    }

    public static int checkInteger() {
        Scanner to = new Scanner(System.in);
        int num;
        try {
            num = to.nextInt();
            if (num < 0) {
                System.out.print("Введите положительное число: ");
                return checkInteger();
            } else {
                return num;
            }
        } catch (InputMismatchException e) {
            System.out.print("Введите число: ");
            return checkInteger();
        }
    }

    public static double interest(double interest) {
        return interest / 100;
    }
}
