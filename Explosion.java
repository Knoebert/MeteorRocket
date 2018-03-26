import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor
{
    GifImage explosion = new GifImage("explosion.gif");
    GreenfootImage imageOne;
    boolean notImageOne;
      
    public Explosion()
    {
        List<GreenfootImage> images = explosion.getImages(); // get list of images
        imageOne = images.get(0); // get reference to first image
        setImage(explosion.getCurrentImage()); // set initial image
    }
  
    public void act() 
    {
        setImage(explosion.getCurrentImage()); // animate
        if ((getImage() != imageOne) != notImageOne) // was there a change involving first image
        {
            notImageOne = ! notImageOne; // record change
            if (! notImageOne) {
                getWorld().removeObject(this);
                Greenfoot.stop();
            }// if setting first image, remove explosion from world
        }
    }
}
