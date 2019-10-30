package smile_food;

import java.awt.BorderLayout;
import javax.swing.*;

import java.awt.event.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
    
 public class ClockApp  extends JFrame
 {  
    JFrame fenetre;
	int hour,min,sec;
	 ClockPanel clockPanel;
	 ClockThread clockThread;
	JButton btn;
	
	/**
	 * Constructeur ClockApp
	 * @param null
	 */
    public ClockApp() {
	    fenetre=new JFrame("Horloge");
	    fenetre.addWindowListener( new WindowAdapter() {
	       	public void windowClosing(WindowEvent e) {
	       		System.exit(0);
	       	}
	    });
	    
       
	    
	    clockPanel=new ClockPanel(hour, min, sec);	// creation de l'horloge et initialisation des aiguilles sur l'heure courante
	    btn=new JButton("Valider");
            
	    fenetre.getContentPane().add(clockPanel);
	    fenetre.setSize(500,500);
	    fenetre.setLocationRelativeTo(null);
            //fenetre.add(btn,BorderLayout.CENTER);
	    fenetre.setVisible(true);
	    
	    clockThread=new ClockThread(this); 	
	    clockThread.start();		      	// Mise a jour de l'horloge 
	   
	}/* Fin constructeur*/
    
}/* fin de classe ClockApp*/
    

 