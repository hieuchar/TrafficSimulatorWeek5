package exercise1;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Explosion extends Actor{
	private static int numImages = 3;
	private static int NUM_EXPLOSION_TICK = 15;
    private static GreenfootImage[] images = new GreenfootImage[numImages];   
    private int counter = 0;
    public Explosion() {
        initialiseImages();
        this.setImage(images[0]);        
    }       
    public static void initialiseImages() {
    	images[0] = new GreenfootImage("images/explosion1.png");
		images[1] = new GreenfootImage("images/explosion2.png");
		images[2] = new GreenfootImage("images/explosion3.png");
    }
    public void act()
    { 
    	 if(counter > NUM_EXPLOSION_TICK) {
             setImage(images[1]);
         }
         if(counter > NUM_EXPLOSION_TICK * 2) {
            setImage(images[2]);
         }
         if(counter > NUM_EXPLOSION_TICK * 3) {
             this.getWorld().removeObject(this);
         }
         counter++;
    }
}
