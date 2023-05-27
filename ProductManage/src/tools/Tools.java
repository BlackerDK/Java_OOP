/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author DuyKhanh
 */
public class Tools {

    public static Scanner sc = new Scanner(System.in);

    public static int readInt(String message, int min, int max) {
        int t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK;
        do {
            System.out.println(message + ": ");
            t = Integer.parseInt(sc.nextLine());
            OK = (t > min && t < max);
        } while (!OK);
        return t;
    }

    public static int readInt(String message, int min) {
        return readInt(message, min, Integer.MAX_VALUE);
    }

    public static double readDouble(String message, double min, double max) {
        double t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {
            System.out.println(message + ": ");
            t = Double.parseDouble(sc.nextLine());
            OK = (t > min && t < max);
        } while (!OK);
        return t;
    }

    public static double readDouble(String message, double min) {
        return readDouble(message, min, Double.MAX_VALUE);
    }

    public static String readNonBlankStr(String message) {
        String S;
        boolean OK = true;
        do {
            System.out.println(message + ": ");
            S = sc.nextLine().trim();
            if (S == null || S.isEmpty()) {
                OK = false;
            }
        } while (!OK);
        return S;
    }

    public static String readPattern(String message, String fomat) {
        String S;
        boolean OK;
        do {
            System.out.println(message + ":");
            S = sc.nextLine().trim();
            OK = S.matches(fomat);
            if (!OK) {
                System.out.println("Invaild input! ");
            }
        } while (!OK);
        return S;
    }

    public static boolean readBool(String message) {
        System.out.print(message + "[T/F ,Y/N, 1/0:] ");
        String S = sc.nextLine().trim().toUpperCase();
        char c = S.charAt(0);
        return (c == 'T' || c == 'Y' || c == '1');
    }

    public static String readUpdate(String message, String fomat, String old) {
        String S = null;
        boolean OK;
        do {
            System.out.println(message + ":");
            S = sc.nextLine().trim();
            if (S.isEmpty()) {
                S = old;
            }
            OK = S.matches(fomat);
            if (!OK) {
                System.out.println("Invaild input! ");
            }
        } while (!OK);
        return S;
    }
public static int oldInt(String message, int min, int max, int oldData) {
        String tmp;
        int value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    value = oldData;
                } else {
                    value = Integer.parseInt(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }
public static double oldDouble(String message, double min, double max, double oldData) {
        String tmp;
        double value = 0;
        boolean cont = true;
        do {
            try {
                System.out.print(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    value = oldData;
                } else {
                    value = Double.parseDouble(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }
}



