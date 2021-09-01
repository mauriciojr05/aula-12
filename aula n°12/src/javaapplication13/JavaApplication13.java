/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author mauricio.junior1
 */
public class JavaApplication13 {
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Dados a = new Dados();
        a.name = "mauricio";
        a.idade = 16;
        String arq = "infor.dat";
        try{
        ObjectOutputStream oS = new ObjectOutputStream (new FileOutputStream(arq));
        oS.writeObject(a);
        oS.close();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());    
        }
        
        try{
        ObjectInputStream iS = new ObjectInputStream (new FileInputStream(arq));
        Dados resp = (Dados)iS.readObject();
        System.out.println("Recebendo dados = nome: " + resp.name + " e idade: " + resp.idade);
        iS.close();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());    
        }
    }
    
}           
