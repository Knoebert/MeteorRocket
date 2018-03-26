import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bullet extends Actor
{
    public void act() 
    {
        setLocation(getX() + 5, getY());
        if(getX() >= 995)
        {
            getWorld().removeObject(this);
            return;
        }
        Dest();
    }
    
    public void Dest()
    {
        Actor obj;
        obj = getOneIntersectingObject(Meteor.class);
        if(obj != null)
        {
            getWorld().addObject(new Explosion_2(), getX(), getY());
            getWorld().removeObject(obj);
            getWorld().removeObject(this);
        }
    }
}
