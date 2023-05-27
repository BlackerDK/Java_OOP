/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productmanage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import tools.Tools;
import static tools.Tools.sc;

/**
 *
 * @author DuyKhanh
 */
public class Product extends ArrayList<Product_Information> implements productmanage.I_Product {

    static Scanner sc = Tools.sc;
    ArrayList<Product_Information> checks = new ArrayList();

    public Product() {
        super();
    }

    public boolean LoadFile(String filename) {
        String ID, Name, Status;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String[] arr;
            String test = br.readLine();
            while (test != null) {
                arr = test.split("\\,");
                ID = arr[0].trim();
                Name = arr[1].trim();
                double Price = Double.parseDouble(arr[2].trim());
                int Quantity = Integer.parseInt(arr[3].trim());
                Status = arr[4].trim();
                this.add(new Product_Information(ID, Name, Price, Quantity, Status));
                checks.add(new Product_Information(ID, Name, Price, Quantity, Status));
                test = br.readLine();
            }
            br.close();
            fr.close();
            System.out.println("File exits");
        } catch (IOException ex) {
            System.out.println("File " + filename + "not exist !!");
        }
        return false;
    }

    public void Add() {
        int check;
        do {
            String newID = Tools.readPattern("Enter the new ID Product( File Character):", "\\w{5,10}$");
            check = searchID(newID);
            if (check >= 1) {
                System.out.println("The ID is Dupplicate !");
            }
        } while (check >= 1);
        do {
            System.out.println("Enter the new Name: ");
            String newName = sc.nextLine();
            check = searchName(newName);
            if (check >= 1) {
                System.out.println("The new Name is Dupplicate !");
            }
            if (newName.isEmpty()) {
                System.out.println("The name is Empty");
            }
        } while (check >= 1);
        double newPrice = Tools.readDouble("Inter the Price From 0 -> 10000", 0.0, 10000.0);
        int newQuantity = Tools.readInt("Enter the new Quantity from 0-> 1000:", 0, 1000);
        String newStatus = Tools.readPattern("Enter the Status: Available or Not Available:", "Available||Not Available");
        this.add(new Product_Information(newStatus, newStatus, newPrice, newQuantity, newStatus));
        try {
            if (GoBack("DO you want to continue create :") == true) {
                Add();
            } else {
                System.out.println("Done!!");
            }
        } catch (Exception e) {
        }

    }

    public int searchName(String name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getProductName().contains(name)) {
                return i;
            }
        }
        return -1;
    }
public Product_Information searchExits(String name) {
        for (int i = 0; i < checks.size(); i++) {
            if (checks.get(i).getProductName().contains(name)) {
                return checks.get(i);
            }
        }
        return null;
    }

    public int searchID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getProductID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void searchByName() {
        int count = 0;
        System.out.print("enter the Name: ");
        String Name = sc.nextLine().toLowerCase();
        for (Product_Information x : this) {
            if (x.getProductName().toLowerCase().contains(Name)) {
                System.out.println(x);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not Found");
        }

        try {
            if (GoBack("DO you want to continue sreach :") == true) {
                searchByName();
            } else {
                System.out.println("Done !");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void PrintAll() {
        if (this.isEmpty()) {
            System.out.println("Empty the list");

        } else {
            Collections.sort(this);

            for (Product_Information s : this) {
                System.out.println(s);
            }
        }
    }

    public void Update() {
        String IdUpdate;
        System.out.println("Enter the Id need Update:");
        IdUpdate = sc.nextLine();
        int count = searchID(IdUpdate);
        if (count <= 0) {
            System.out.println("The ID does not exist!");
        } else {
            String old = this.get(count).getProductName();
            String newName = Tools.readUpdate("Enter the new Name: ", "\\w{5,10}$", old);
            double newPrice = Tools.oldDouble("Enter the new Price:", 0.0, 10000.0, get(count).getUnitPrice());
            this.get(count).setUnitPrice(newPrice);
            int newQuantity = Tools.oldInt("Enter the new Quantity:", 0, 1000, get(count).getQuanlity());
            this.get(count).setQuanlity(newQuantity);
            String newStatus = Tools.readPattern("Enter the Status: Available or Not Available:", "Available||Not Available");
            this.get(count).setStatus(newStatus);
            System.out.println("Successfully !");
            if (GoBack("Do you want to continue Update:") == true) {
                Update();
            } else {
                System.out.println("DONE !");
            }
        }
    }

    public boolean Delete() {
        String IdRemove;
        System.out.println("Enter the Id need Remove:");
        IdRemove = sc.nextLine().toUpperCase();
        int count = searchID(IdRemove);
        if (count <= 0) {
            System.out.println("Not found");
            return false;
        } else {
            if (GoBack("Do you want to Delete:") == true) {
                System.out.println("Successfully Delete");
                remove(count);
            } else {
                System.out.println("No Successfully Delete !");
            }
        }
        if (GoBack("Do you want go to Menu:") == false) {
            Delete();
        }
        return true;
    }

    public boolean saveFile(String filename) {
        if (this.isEmpty()) {
            System.out.println("Empty list");
            return true;
        }
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f); // Write()
            PrintWriter pw = new PrintWriter(fw); // Print()
            for (Product_Information x : this) {
                pw.println(x.getProductID() + "," + x.ProductName + "," + x.getUnitPrice()
                        + "," + x.getQuanlity() + "," + x.getStatus());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
        }
        return true;
    }

    public void Print() {
        if (this.isEmpty()) {
            System.out.println("Empty the list");
            return;
        }
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i) + "\n");
        }
    }

    public boolean GoBack(String message) {
        System.out.print(message + "Y/N :");
        String S = sc.nextLine().trim().toUpperCase();
        if (S.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void CheckValid() {
        String Name = Tools.readNonBlankStr("Enter the Name Product:").trim();
        if (checks.isEmpty()) {
            System.out.println("Not Found");
        } else {
Product_Information checkE=searchExits(Name);
            if(checkE==null){System.out.println("Not Exits"); 
        }
else{System.out.println("Product Exits ");}
        try {
            if (GoBack("DO you want to continue sreach :") == true) {
                CheckValid();
            } else {
                System.out.println("Done !");
            }
        } catch (Exception e) {
        }
    }
}
}
