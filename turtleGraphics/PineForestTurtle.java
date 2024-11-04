import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Turtle which plants a lot of random trees
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class PineForestTurtle extends PineTreeTurtle
{
    public void act() 
    {
        // Move about randomly
        int dx = Greenfoot.getRandomNumber(200)-100;
        int dy = Greenfoot.getRandomNumber(200)-100;
        setLocation(getX()+dx, getY()+dy);
        
        // Make them smaller at the back
        setSize(getY()/2);
        
        // Plant a tree!
        super.act();
    }      
}
