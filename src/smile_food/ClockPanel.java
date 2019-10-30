package smile_food;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import javax.swing.*;
public class ClockPanel  extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private int min,sec;
	double secChrono;
	private int nbMinCurrentChrono, nbMinInterChrono;
	double secInterChrono;
	private float hour;
	private float xCenterCircle,yCenterCircle, xCursor, yCursor;
	private double anglesec, anglemin, angleheure;
	private float angleCursorChrono, angleUpdateChrono;
	private float angleArc;
	private float nbMinSelectChrono;
	private Font font;
	String dateCurrent;
	DateFormat dateFormat;
	boolean mouseButtonClicked = false;

	
	/**
	 * Constructeur de la classe ClockPanel
	 * @param hour
	 * @param min
	 * @param sec
	
	 */
	public ClockPanel(int hour, int min, int sec) {
		super();
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		anglesec=0; anglemin=0; angleheure =0;
		secChrono=0; nbMinCurrentChrono=0;
		angleCursorChrono=(float) (-Math.PI/2);
		angleUpdateChrono=(float) (-Math.PI/2);
		angleArc=0;

		addMouseListener(this); addMouseMotionListener(this); 
		
		// initialisation du bouton
		
	}


	


	// Mise � jour de l'HORLOGE pour les minutes/heures/secondes
     public void upDateClock() {
	    sec=sec+1;
	    if(sec>59) { 	
		    min=min+1;
		    sec=0;
		    if(min>59) { 
			    min=0;
			    hour=hour+1;
			    if(hour>24) {
			    	hour=1;
			    }
		    }
	   }
    }
     
    
    // Calcul de l'angle et des minutes selectionnees dans le CHRONOMETRE
    public void calculPositionCursor(MouseEvent event) {
     	if (event.getX() == xCenterCircle) 
    		xCursor=0;
    	else if (event.getX() > xCenterCircle)
    		xCursor=event.getX()-xCenterCircle;
    	else if (event.getX() < xCenterCircle)
    		xCursor=-(xCenterCircle-event.getX());
    	
    	if (event.getY() == yCenterCircle) 
    		yCursor=0;
    	else if (event.getY() > yCenterCircle)
    		yCursor=-(event.getY()-yCenterCircle);
    	else if (event.getY() < yCenterCircle)
    		yCursor=yCenterCircle-event.getY();
       	
 		
    }
     
       
 	// Mise � jour du CHRONOMETRE pour le curseur des secondes et l'arc des minutes
    public void upDateCronometer() {
    	// Demarrage avec un temps selectionn� et appui sur le bouton
    	
 		}
    	//  Appui sur le bouton suite a une demande de chrono intermediaire
    	
    
    
    
    @Override
 	public void mouseClicked(MouseEvent event)  {  	}
 	public void mouseReleased(MouseEvent event) {	}
 	public void mouseMoved(MouseEvent event)    {	}
 	public void mouseEntered(MouseEvent event)  { 	}
 	public void mouseExited(MouseEvent event)   { 	}
 	
 	
 	@Override
	public void mouseDragged(MouseEvent event) {
		
		
	}
	
 	
	@Override
 	public void mousePressed(MouseEvent event) {
		
		}
  	

    
	// Construction graphique de l'horloge
	public void paintComponent (Graphics  g) {
	    super.paintComponent(g);
	    xCenterCircle=getWidth()/2;
	    yCenterCircle=getHeight()/2;
	    double rayon=Math.min(xCenterCircle,yCenterCircle)*0.75; // Calcul du rayon avec un coefficient
	    font= new Font("Times New Roman",0,15);
	    g.setFont(font);
	    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
       
	   
	    // Affichage des reperes des heures
	    double angleHr=(2*Math.PI)/12;
	    for(int i=1;i<=12;i++) {
		    int x0=(int)xCenterCircle+ (int)(0.85*rayon*Math.cos(i*angleHr-Math.PI/2));
		    int y0=(int)yCenterCircle+ (int)(0.85*rayon*Math.sin(i*angleHr-Math.PI/2));
		    int xCursorHr=(int)xCenterCircle+(int)(1.05*rayon*Math.cos(i*angleHr-Math.PI/2));
		    int yCursorHr=(int)yCenterCircle+(int)(1.05*rayon*Math.sin(i*angleHr-Math.PI/2));
		    ((Graphics2D) g).setStroke(new BasicStroke(3));
		    g.drawLine(x0, y0, xCursorHr, yCursorHr);
	    }
	    
	    // Affichage des reperes des minutes
	    double angleMn=(2*Math.PI)/60;
	    for(int i=1;i<=60;i++) {
		    int x0=(int)xCenterCircle+ (int)(0.85*rayon*Math.cos(i*angleMn-Math.PI/2));
		    int y0=(int)yCenterCircle+ (int)(0.85*rayon*Math.sin(i*angleMn-Math.PI/2));
		    int xCursorMn=(int)xCenterCircle+(int)(0.9*rayon*Math.cos(i*angleMn-Math.PI/2));
		    int yCursorMn=(int)yCenterCircle+(int)(0.9*rayon*Math.sin(i*angleMn-Math.PI/2));
		    ((Graphics2D) g).setStroke(new BasicStroke(1));
		    g.drawLine(x0, y0, xCursorMn, yCursorMn);
	    }
	    
	    // Affichage des chiffres horaires
	    double angle=(2*Math.PI)/12;
	    for(int i=1;i<=12;i++) {
		    int x0=(int)xCenterCircle+ (int)(0.75*rayon*Math.cos(i*angle-Math.PI/2));
		    int y0=(int)yCenterCircle+ (int)(0.75*rayon*Math.sin(i*angle-Math.PI/2));
		    FontMetrics fontMetrics=g.getFontMetrics();
		    int X= (int) x0-(fontMetrics.stringWidth(String.valueOf(i))/2); // Permet de decaler les chiffres pour les centrer par rapport a l'aiguille
			int Y= (int) y0+(fontMetrics.getHeight()/3);
			g.drawString(String.valueOf(i), X, Y);
	    }
	    
	    // gestion et affichage de aiguilles SECONDES
	    g.setColor(Color.black);
	    anglesec=(sec*((Math.PI)/30.0)-(Math.PI/2.0));
	    //System.out.println(anglesec);
	    int xCursorSec=(int)xCenterCircle+(int)(0.95*rayon*Math.cos(anglesec));
	    int yCursorSec=(int)yCenterCircle+(int)(0.95*rayon*Math.sin(anglesec));
	    ((Graphics2D) g).setStroke(new BasicStroke(2));
	    int [] xPointSec = { (int) xCenterCircle, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglesec+Math.PI/10)), xCursorSec, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglesec-Math.PI/10)) };
	    int [] yPointSec = { (int) yCenterCircle, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglesec+Math.PI/10)), yCursorSec, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglesec-Math.PI/10)) };
	    g.fillPolygon(xPointSec, yPointSec, 4);
	    int xCursorSecBehind=(int)xCenterCircle+(int)(0.15*rayon*Math.cos(anglesec+Math.PI));
	    int yCursorSecBehind=(int)yCenterCircle+(int)(0.15*rayon*Math.sin(anglesec+Math.PI));
	    int [] xPointSecBehind = { (int) xCenterCircle, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglesec+Math.PI+Math.PI/10)), xCursorSecBehind, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglesec+Math.PI-Math.PI/10)) };
	    int [] yPointSecBehind = { (int) yCenterCircle, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglesec+Math.PI+Math.PI/10)), yCursorSecBehind, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglesec+Math.PI-Math.PI/10)) };
	    g.fillPolygon(xPointSecBehind, yPointSecBehind, 4);
	
	    // gestion et affichage de aiguilles MINUTES
	    g.setColor(Color.BLACK);
	    anglemin=(min*((Math.PI)/30.0)-(Math.PI/2.0));
	    int xCursorMin=(int)xCenterCircle+(int)(0.9*rayon*Math.cos(anglemin));
	    int yCursorMin=(int)yCenterCircle+(int)(0.9*rayon*Math.sin(anglemin));
	    ((Graphics2D) g).setStroke(new BasicStroke(4));
	    int [] xPointMn = { (int) xCenterCircle, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglemin+Math.PI/10)), xCursorMin, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglemin-Math.PI/10)) };
	    int [] yPointMn = { (int) yCenterCircle, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglemin+Math.PI/10)), yCursorMin, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglemin-Math.PI/10)) };
	    g.fillPolygon(xPointMn, yPointMn, 4);
	    int xCursorMinBehind=(int)xCenterCircle+(int)(0.15*rayon*Math.cos(anglemin+Math.PI));
	    int yCursorMinBehind=(int)yCenterCircle+(int)(0.15*rayon*Math.sin(anglemin+Math.PI));
	    int [] xPointMnBehind = { (int) xCenterCircle, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglemin+Math.PI+Math.PI/10)), xCursorMinBehind, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(anglemin+Math.PI-Math.PI/10)) };
	    int [] yPointMnBehind = { (int) yCenterCircle, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglemin+Math.PI+Math.PI/10)), yCursorMinBehind, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(anglemin+Math.PI-Math.PI/10)) };
	    g.fillPolygon(xPointMnBehind, yPointMnBehind, 4);

	    // gestion et affichage de aiguilles HEURES
	    if (min>=0 && min<12)	// Calcul de la position de l'aiguille des heures suivants les minutes courantes
	    	 angleheure=(hour*((2*Math.PI)/12.0)-(Math.PI/2.0));	
	    if (min>=12 && min<23)
	    	angleheure=((hour+0.2)*((2*Math.PI)/12.0)-(Math.PI/2.0));   // on ajoute 1/5 soit une graduation
	    if (min>=23 && min<35)
	    	angleheure=((hour+0.4)*((2*Math.PI)/12.0)-(Math.PI/2.0));   // on ajoute 2/5 soit deux graduations
	    if (min>=35 && min<47)
	    	angleheure=((hour+0.6)*((2*Math.PI)/12.0)-(Math.PI/2.0));   // on ajoute 3/5 soit trois graduations
	    if (min>=47 && min<=59)
	    	angleheure=((hour+0.8)*((2*Math.PI)/12.0)-(Math.PI/2.0));   // on ajoute 4/5 soit quatre graduations
	
	    int xCursorHour=(int)xCenterCircle+(int)(0.7*rayon*Math.cos(angleheure));
	    int yCursorHour=(int)yCenterCircle+(int)(0.7*rayon*Math.sin(angleheure));
	    ((Graphics2D) g).setStroke(new BasicStroke(4));
	    int [] xPointHr = { (int) xCenterCircle, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(angleheure+Math.PI/10)), xCursorHour, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(angleheure-Math.PI/10)) };
	    int [] yPointHr = { (int) yCenterCircle, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(angleheure+Math.PI/10)), yCursorHour, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(angleheure-Math.PI/10)) };
	    g.fillPolygon(xPointHr, yPointHr, 4);
	    int xCursorHourBehind=(int)xCenterCircle+(int)(0.15*rayon*Math.cos(angleheure+Math.PI));
	    int yCursorHourBehind=(int)yCenterCircle+(int)(0.15*rayon*Math.sin(angleheure+Math.PI));
	    int [] xPointHrBehind = { (int) xCenterCircle, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(angleheure+Math.PI+Math.PI/10)), xCursorHourBehind, (int)xCenterCircle+(int)(0.1*rayon*Math.cos(angleheure+Math.PI-Math.PI/10)) };
	    int [] yPointHrBehind = { (int) yCenterCircle, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(angleheure+Math.PI+Math.PI/10)), yCursorHourBehind, (int)yCenterCircle+(int)(0.1*rayon*Math.sin(angleheure+Math.PI-Math.PI/10)) };
	    g.fillPolygon(xPointHrBehind, yPointHrBehind, 4);
	    
	    // Affichage du cercle au centre
	    g.setColor(Color.DARK_GRAY);
	    g.fillOval((int)xCenterCircle-(int)(rayon*0.05), (int)yCenterCircle-(int)(rayon*0.05), 2*(int)(rayon*0.05), 2*(int)(rayon*0.05));
	    
	   
		
	    // Gestion et affichage de l'arc de selection des MIN du CHRONOMETRE
	    g.setColor(Color.LIGHT_GRAY);
	    ((Graphics2D) g).setStroke(new BasicStroke(3));
	    // Transformation de l'angle du curseur de selection du CHRONOMETRE en angle pour dessiner l'arc 
	    if ((int)(Math.toDegrees(angleCursorChrono))<=0 && (int)(Math.toDegrees(angleCursorChrono))>=-90)
	    	angleArc= (float) (-Math.toDegrees(angleCursorChrono)-90);
	    if ((int)(Math.toDegrees(angleCursorChrono))<-90 && (int)(Math.toDegrees(angleCursorChrono))>=-180)
	    	angleArc= (float) (-Math.toDegrees(angleCursorChrono)-450);
	    if ((int)(Math.toDegrees(angleCursorChrono))>0 && (int)(Math.toDegrees(angleCursorChrono))<=180)
	    	angleArc= (float) (-Math.toDegrees(angleCursorChrono)-90);
	    //System.out.println("angle trotteuse: "+Math.toDegrees(angleCursorChrono)+" - angle arc: "+angleArc);
	    g.drawArc((int)xCenterCircle-(int)(0.9*rayon), (int)yCenterCircle-(int)(0.9*rayon), (int)(0.9*rayon)*2, (int)(0.9*rayon)*2, (int) Math.toDegrees((Math.PI/2)), (int)angleArc);
	    g.drawArc((int)xCenterCircle-(int)(0.85*rayon), (int)yCenterCircle-(int)(0.85*rayon), (int)(0.85*rayon)*2, (int)(0.85*rayon)*2, (int) Math.toDegrees((Math.PI/2)), (int)angleArc);
	    
	    // Affichage du CURSEUR du CHRONOMETRE
	   	angleUpdateChrono=(float) (secChrono*((Math.PI)/30.0)-(Math.PI/2.0));
	   	//System.out.println(angleUpdateChrono);
	    g.setColor(Color.black);
	    int x0 = (int)xCenterCircle+(int)(0.9*rayon*Math.cos(angleUpdateChrono));
	    int y0 = (int)yCenterCircle+(int)(0.9*rayon*Math.sin(angleUpdateChrono));
	    int [] xPoint = { x0, (int)xCenterCircle+(int)(0.95*rayon*Math.cos(angleUpdateChrono+Math.PI/90)), (int)xCenterCircle+(int)(0.95*rayon*Math.cos(angleUpdateChrono-Math.PI/90)) };
	    int [] yPoint = { y0, (int)yCenterCircle+(int)(0.95*rayon*Math.sin(angleUpdateChrono+Math.PI/90)), (int)yCenterCircle+(int)(0.95*rayon*Math.sin(angleUpdateChrono-Math.PI/90)) };
	    g.fillPolygon(xPoint, yPoint, 3);
	    
	    // Affichage de l'arc des MIN en cours du CHRONOMETRE
	    ((Graphics2D) g).setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.DST_OUT,0.5f ) ) ;
	    ((Graphics2D) g).setStroke(new BasicStroke(20,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
	    g.drawArc((int)xCenterCircle-(int)(0.875*rayon), (int)yCenterCircle-(int)(0.875*rayon), (int)(0.875*rayon)*2, (int)(0.875*rayon)*2, (int) Math.toDegrees((Math.PI/2)), (int)(nbMinCurrentChrono*(-Math.toDegrees(Math.PI)/30.0)));
        ((Graphics2D) g).setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER,1.0f));
	}


	/**
	 * @return the nbMinCurrentChrono
	 */
	public int getNbMinCurrentChrono() {
		return nbMinCurrentChrono;
	}


	/**
	 * @return the nbMinInterChrono
	 */
	public int getNbMinInterChrono() {
		return nbMinInterChrono;
	}


	/**
	 * @return the nbMinSelectChrono
	 */
	public float getNbMinSelectChrono() {
		return nbMinSelectChrono;
	}


	/**
	 * @return the chronoRazButton
	 */
	

}/* fin de classe ClockPanel */
