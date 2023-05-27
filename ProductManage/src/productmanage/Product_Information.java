/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productmanage;

/**
 *
 * @author DuyKhanh
 */
public class Product_Information implements Comparable<Product_Information> {

    public String ProductID;
    public String ProductName;
    public double UnitPrice;
    public int Quanlity;
    public String Status;

    public Product_Information() {
    }

    public Product_Information(String ProductID, String ProductName, double UnitPrice, int Quanlity, String Status) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.Quanlity = Quanlity;
        this.Status = Status;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuanlity() {
        return Quanlity;
    }

    public void setQuanlity(int Quanlity) {
        this.Quanlity = Quanlity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String toString() {
        return "Product ID: " + ProductID + "," + "Product Name: " + ProductName + ", "
                + "Unit Price: " + UnitPrice + ", " + "Quantity: " + Quanlity + ", " + "Status :" + Status;
    }

    @Override
    /*public int compareTo(Product_Information obj) {
        int value = this.Quanlity - obj.Quanlity;
        if (value == 0) {
            return (int) (this.UnitPrice - obj.UnitPrice);
        }
        if (value < 0) {
            return -1;
        }
        if (value > 0) {
            return 1;
        }
        return value;
    }*/
public int compareTo(Product_Information obj) {
        int value=this.ProductName.compareToIgnoreCase(obj.ProductName);
        if (value < 0) {
            return 1;
        }
        if (value > 0) {
            return -10;
        }
        return value;
    }
}
