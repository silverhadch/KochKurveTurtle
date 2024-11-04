import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Recursive tree turtle a bit like a Christmas Tree
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class ChristmasTreeTurtle extends TreeTurtle
{
  public ChristmasTreeTurtle()
  {
    super();
    setLeftBranchHeight(0.25);
    setRightBranchHeight(0.2);
    setLeftBranchAngle(50);
    setRightBranchAngle(40);
    setLeftBranchLength(0.4);
    setRightBranchLength(0.5);
    setDepth(5);
  }   
}
