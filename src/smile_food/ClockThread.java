package smile_food;


public class ClockThread extends Thread {
	
	private ClockApp horloge;
	
	public ClockThread(ClockApp horloge) {
		this.horloge=horloge;
	}

    public void run() {
	    while(true) {
		    horloge.clockPanel.upDateClock();

		    horloge.clockPanel.repaint();
		    try {
		    	sleep(1000);		// Permet d'avoir une maj des aiguilles lissee dans le temps
		    }
		    catch(InterruptedException e) {
		    }
	    }
    }
}
