import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rocket extends Actor
{
    int _MoveFactor = 5;
    
    double xAccel = 0;
    double yAccel = 0;
    
    int ammo = 10;
    boolean shieldActive = false;

    public void act() 
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            this.moveRocket("right");
        } 

        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            this.moveRocket("left");
        }

        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            this.moveRocket("up");
        }

        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            this.moveRocket("down");
        }

        if(Greenfoot.isKeyDown("space"))
        {
            shoot();
        }
        if(Greenfoot.isKeyDown("o"))
        {
            shield();
        }
        if(isAtEdge())
        {
            explosion();
            return;
        }
        
        MeteorWorld meteorW = (MeteorWorld)getWorld();
        Counter counter = meteorW.getCounter();
        counter.addToScore();
        
        if(checkCollision())
        {
            return;
        }
        
        executeMovement();
        
        if(checkRefill())
        {
            ammo = ammo + 10;
        }
    }    

    public void moveRocket(String dir)
    {
        if(dir == "right")
        {
            //setLocation(getX() + _MoveFactor, getY());
            xAccel = xAccel+0.3;
        }
        else if(dir == "left")
        {
            //setLocation(getX() - _MoveFactor, getY());
            xAccel = xAccel-0.3;
        }
        else if(dir == "up")
        {
            //setLocation(getX(), getY() - _MoveFactor);
            yAccel = yAccel-0.3;
        }
        else if(dir == "down")
        {
            //setLocation(getX(), getY() + _MoveFactor);
            yAccel = yAccel+0.3;
        }
        
    }
    
    public void executeMovement()
    {
        int xTemp = (int)xAccel;
        int yTemp = (int)yAccel;
        setLocation(getX() + xTemp, getY() + yTemp);
        
        if(xAccel < 0)
        {
            xAccel = xAccel + 0.05;
        }
        if(xAccel > 0)
        {
            xAccel = xAccel - 0.05;
        }
        if(yAccel < 0)
        {
            yAccel = yAccel + 0.05;
        }
        if(yAccel > 0)
        {
            yAccel = yAccel - 0.05;
        }
    }

    public boolean checkCollision()
    {
        Actor interobj;
        interobj = getOneIntersectingObject(Meteor.class);
        if(interobj != null)
        {
            explosion();
            return true;
        }
        return false;
    }
    
    public boolean checkRefill()
    {
        Actor interobj;
        interobj = getOneIntersectingObject(Refill.class);
        if(interobj != null)
        {
            getWorld().removeObject(interobj);
            return true;
        }
        return false;
    }

    public void shoot()
    {
        if(ammo > 0)
        {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX() + 60, getY());
            ammo--;
        }
    }
    
    public void shield()
    {
        if(getWorld().getObjects(Shield.class) != null)
        {
            Shield sh = new Shield();
            getWorld().addObject(sh, getX(), getY());
            shieldActive = true;
        }
    }
    
    public void explosion()
    {   
        SimpleTimer timer = new SimpleTimer();
        Explosion exp = new Explosion();
        getWorld().addObject(exp, getX(), getY());
        Greenfoot.playSound("Explosion.wav");
        getWorld().removeObject(this);
        
    }
}
