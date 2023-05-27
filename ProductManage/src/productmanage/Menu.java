/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productmanage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DuyKhanh
 */
public class Menu extends ProductManage {

    private static Scanner sc = new Scanner(System.in);

    public static List<String> menuOption() {

        List<String> list = new ArrayList<>();
        
        list.add("Print");

        list.add("Check exits product ");

        list.add("Search Product by Name");

        list.add("Update Product");

        list.add("Delete Product");

        list.add("Print list Product from the file ");

        list.add("Add product ");

        list.add("Save Product");

        list.add("Out Program !!");

        return list;
    }

    public static int int_getChoice(List<String> options) {
        int response;
        for (int i = 0; i < options.size(); i++) {
            //System.out.println((i + 1) + "-" + options.get(i));
            System.out.printf("%-2d  -  %s\n", (i + 1), (options.get(i)));
        }

        while (true)
           try {
            System.out.print("Please choose an option 1..." + options.size() + ": ");
            response = Integer.parseInt(sc.nextLine());
            break;
        } catch (NumberFormatException e) {
            System.out.println("Option is number. Please enter again!!");
        }
        return response;
    }
}
