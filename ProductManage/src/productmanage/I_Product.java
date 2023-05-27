/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package productmanage;

/**
 *
 * @author DuyKhanh
 */
public interface I_Product {
public void Print();
public void Add();
public void searchByName();
public void Update();
public boolean Delete();
public boolean saveFile(String filename);
public void PrintAll();

}
