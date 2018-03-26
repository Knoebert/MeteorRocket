import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 
public class MeteorWorld extends World
{
    int _Mcount = 0;
    int _Rcount = 0;
    Counter counter = new Counter();
    Rocket rocket = new Rocket();
    public void act()
    {
        if(_Mcount == 15)
        {
            Meteor meteor = new Meteor();
            addObject(meteor, 1000, Greenfoot.getRandomNumber(800));
            _Mcount = 0;
            _Rcount++;
        }
        _Mcount++;
        if(_Rcount > 9)
        {
            Refill refill = new Refill();
            addObject(refill, 1000, Greenfoot.getRandomNumber(800));
            _Rcount = 0;
        }
    }

    public MeteorWorld()
    {    
        super(1000, 800, 1); 
        fillWorld();
    }

    public void fillWorld()
    {
        addObject(rocket, 10, 400);
        addObject(counter,70,10);
    }
    public Counter getCounter()
    {
        return counter;
    }
    public int[] getRocLoc()
    {
        int[] temp = {rocket.getX(), rocket.getY()};
        return temp;
    }
}
