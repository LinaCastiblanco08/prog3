/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Carrera;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lina Castiblanco
 */
public class carrera extends Thread{
    
    //creación variables
    private JLabel etiqueta;
    private fmrCarrera auto;

    //Constructor
    public carrera(JLabel etiqueta, fmrCarrera auto) {
        this.etiqueta = etiqueta;
        this.auto = auto;
    }
    
    @Override
    public void run(){
        
        int Auto1 = 0;
        int Auto2 = 0;
        int Auto3 = 0;
        int Auto4 = 0;
        
        while(true){
            try{
                
                sleep((int)(Math.random() * 1000));
                Auto1 = auto.getPrimerAuto().getLocation().x;
                Auto2 = auto.getSegundoAuto().getLocation().x;
                Auto3 = auto.getTercerAuto().getLocation().x;
                Auto4 = auto.getCuartoAuto().getLocation().x;
                
                if(Auto1 < auto.getMeta().getLocation().x - 125 && Auto2 < auto.getMeta().getLocation().x - 125 && Auto3 < auto.getMeta().getLocation().x - 125 && Auto4 < auto.getMeta().getLocation().x - 125){
                    etiqueta.setLocation(etiqueta.getLocation().x + 10,etiqueta.getLocation().y);
                    auto.repaint();  
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            if(etiqueta.getLocation().x >= auto.getMeta().getLocation().x - 125){
                if(Auto1 > Auto2){
                    JOptionPane.showMessageDialog(null,"Gano el primer auto");
                }
                else if(Auto2 > Auto3){
                    JOptionPane.showMessageDialog(null,"Gano el segundo auto"); 
                }
                else if(Auto3 > Auto4){
                    JOptionPane.showMessageDialog(null,"Gano el tercer auto"); 
            }
                else if(Auto4 > Auto1){
                    JOptionPane.showMessageDialog(null,"Gano el cuarto auto"); 
        }
                else{
                    JOptionPane.showMessageDialog(null,"Empate"); 
                }
            }
        }
    }
}
