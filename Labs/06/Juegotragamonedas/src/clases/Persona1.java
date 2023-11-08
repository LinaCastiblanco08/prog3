/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Persona1 extends Thread {
    private int tiempo;
    public Persona1(int milisegundos) {
        this.tiempo = milisegundos;
    }
     public void run(){
         while(true){
             int numero = (int) (Math.random() * (8) + 1);
             String ruta = "src\\Imagenes\\" + numero + ".png";
             ImageIcon imageIcon = new ImageIcon (ruta);
             Vistas.Tragamonedas.lb1Persona1.setIcon(imageIcon);
             //Vistas.Tragamonedas.Persona1.setIcon(imageIcon);
             try {
                 Thread.sleep(this.tiempo);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Persona1.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }  
}
