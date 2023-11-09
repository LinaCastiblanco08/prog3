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
    public boolean parar=false;
    public javax.swing.JLabel jlabel = new javax.swing.JLabel();
    
    public Persona3(int milisegundos, javax.swing.JLabel jlabel) {
        this.tiempo = milisegundos;
        this.jlabel = jlabel;
        this.jlabel.setEnabled(false);
    }
    
    public void paro(){
        this.parar=true;
    }
    
    public void run() {
        while (!parar) {
            int numero = (int) (Math.random() * (8) + 1);
            String ruta = "src\\Imagenes\\" + numero + ".png";
            ImageIcon imageIcon = new ImageIcon(ruta);
            jlabel.setIcon(imageIcon);
            jlabel.setEnabled(true);
            //Vistas.Tragamonedas.Persona3.setIcon(imageIcon);
            try {
                Thread.sleep(this.tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
