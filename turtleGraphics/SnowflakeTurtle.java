import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Recursive snowflake turtle, using 6 trees
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class SnowflakeTurtle extends TreeTurtle
{
    public SnowflakeTurtle()
    {
        super();
        setLeftBranchHeight(0.33);
        setRightBranchHeight(0.33);
        setLeftBranchAngle(45);
        setRightBranchAngle(45);
        setLeftBranchLength(0.33);
        setRightBranchLength(0.33);
        setDepth(4);
    }  

    /**
     * Overridden act() which draws 6 trees at 60 degree rotation
     */
    public void act()
    {
        for(int i=0; i<6; i++)
        {
            super.act();
            turn(60);
        }
    }
}
