import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Recursive tree turtle with a modernist tendency
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class ModernistTreeTurtle extends TreeTurtle
{
  public ModernistTreeTurtle()
  {
    super();
    setLeftBranchHeight(0.33);
    setRightBranchHeight(0.66);
    setLeftBranchAngle(90);
    setRightBranchAngle(90);
    setLeftBranchLength(0.66);
    setRightBranchLength(0.66);
    setDepth(5);
  }   
}
