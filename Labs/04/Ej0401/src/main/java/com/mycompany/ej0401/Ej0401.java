/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej0401;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Estudiante
 */
public class Ej0401 {

   Timer timer;
   public Ej0401(int segundos) {
       timer = new Timer();
       timer.schedule(new Recordatorio(),segundos*1000);//Programa la tarea
   }
   class Recordatorio extends TimerTask {
       @Override
       public void run() {
           System.out.println("Tiene un recordatorio!");
           timer.cancel(); //Termina el hilo del timer
       }
   }
   public static void main(String args[]) {
       System.out.println("Inicio del programa");
       new Ej0401(5);
 }
}

