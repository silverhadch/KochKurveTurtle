import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Recursive tree turtle more like a shrub
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class PineTreeTurtle extends TreeTurtle
{
  public PineTreeTurtle()
  {
    super();
    setLeftBranchHeight(0.75);
    setRightBranchHeight(0.66);
    setLeftBranchAngle(135);
    setRightBranchAngle(120);
    setLeftBranchLength(0.4);
    setRightBranchLength(0.4);
    setDepth(6);
  }   
}
