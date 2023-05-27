/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productmanage;

import java.util.List;

/**
 *
 * @author DuyKhanh
 */
public class ProductManage {

    public static void main(String[] args) throws Exception{
    Menu menu = new Menu();
    Product  products= new Product();
        List<String> option = Menu.menuOption();
        int choice = 0;
products.LoadFile("Product.dat");
System.out.println("*THE_MENU*");
        do {
            choice = menu.int_getChoice(option);
            switch (choice) {
                case 1:
                    products.Print();
                    break;
                case 2:
                    products.CheckValid();
                    break;

                case 3:
                    products.searchByName();
                    break;

                case 4:
                    products.Update();
                    break;
                case 5:
                    products.Delete();
                    break;

                case 6:
                products.PrintAll();
                    break;

                case 7:
                   products.Add();
                    break;

                case 8:
                    if (products.saveFile("Product.dat") == true) {
                    System.out.println("Save successfully!!");
                    }
                    break;
                default:
                    System.out.println("Goodbye");
                    break;
            }
        } while ((choice > 0) && choice <= 9);
    }

    }
   
