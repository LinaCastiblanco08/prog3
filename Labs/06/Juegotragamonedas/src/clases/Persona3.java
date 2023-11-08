/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Persona3 extends Thread {
    private int tiempo;
    public Persona3(int milisegundos) {
        this.tiempo = milisegundos;
    }
     public void run(){
         while(true){
             int numero = (int) (Math.random() * (8) + 1);
             String ruta = "src\\Imagenes\\" + numero + ".png";
             ImageIcon imageIcon = new ImageIcon (ruta);
             Vistas.Tragamonedas.lb3Persona3.setIcon(imageIcon);
             //Vistas.Tragamonedas.Persona3.setIcon(imageIcon);
             try {
                 Thread.sleep(this.tiempo);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Persona3.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }  
}
