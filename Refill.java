import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Refill extends Actor
{
    public void act() 
    {
        this.setLocation(getX() - 3, getY());
        if(getX() < 1)
        {
            getWorld().removeObject(this);
        }
    }    
}
