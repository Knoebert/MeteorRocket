import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion_2 extends Actor
{
    int counter = 0;
    public void act()
    {
        if(counter == 30)
        {
            getWorld().removeObject(this);
        }
        counter++;
    }    
}
