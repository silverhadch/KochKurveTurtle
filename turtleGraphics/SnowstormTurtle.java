import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Turtle which generates a storm of random snowflakes
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class SnowstormTurtle extends SnowflakeTurtle
{
    public void act() 
    {
        // Random position
        World world = getWorld();
        int x = Greenfoot.getRandomNumber(world.getWidth());
        int y = Greenfoot.getRandomNumber(world.getHeight());
        setLocation(x,y);
        
        // Random size as well
        setSize(Greenfoot.getRandomNumber(100));
        
        // Let it snow!
        super.act();
    }      
}
