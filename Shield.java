import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Shield extends Actor
{
    //GifImage gifImage = new GifImage("ShieldRing.gif");
    GifImage gishield = new GifImage("shield.gif");
    int counter = 0;
    int lives = 10;
    public void act() 
    {
        setImage(gishield.getCurrentImage());
        setLoc();
        if(checkCollision() == true)
        {
            lives--;
        }
        if(lives == 0)
        {
            //Actor[] actor = getWorld().getObjects(Shield.class)
            getWorld().removeObjects(getWorld().getObjects(Shield.class));
        }
    } 
    
    public boolean checkCollision()
    {
        Actor interobj;
        interobj = getOneIntersectingObject(Meteor.class);
        if(interobj != null)
        {
            //Explosion exp = new Explosion();
            //getWorld().addObject(exp, getX(), getY());
            getWorld().removeObject(interobj);
            return true;
        }
        return false;
    }
    
    public void setLoc()
    {
        MeteorWorld meteorW = (MeteorWorld)getWorld();
        int[] LocXY = meteorW.getRocLoc();
        setLocation(LocXY[0], LocXY[1]);
    }
}
