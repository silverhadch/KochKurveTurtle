import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Turtle using recursion to draw a fractal tree
 * 
 * @author Paul Clark
 * @version 0.2
 */
public class TreeTurtle extends Turtle
{
    private int depth;
    private double size;              // in pixels
    private double leftBranchAngle;
    private double rightBranchAngle;
    private double leftBranchHeight;  // as a proportion of total
    private double rightBranchHeight;
    private double leftBranchLength;  // ditto
    private double rightBranchLength;
    
    public TreeTurtle()
    {
        // Default parameters, bit like an Ash tree
        depth = 4;
        size = 300;
        leftBranchAngle = 30;
        rightBranchAngle = 45;
        leftBranchHeight = 0.5;
        rightBranchHeight = 0.66;
        leftBranchLength = 0.5;
        rightBranchLength = 0.33;
        
        // Face upwards
        turn(-90);
    }

    public void setDepth(int recursion_depth)
    {
        depth = recursion_depth;
    }

    public void setSize(double pixels)
    {
        size = pixels;
    }

    public void setLeftBranchAngle(double degrees)
    {
        leftBranchAngle = degrees;
    }

    public void setRightBranchAngle(double degrees)
    {
        rightBranchAngle = degrees;
    }

    public void setLeftBranchHeight(double proportion)
    {
        leftBranchHeight = proportion;
    }

    public void setRightBranchHeight(double proportion)
    {
        rightBranchHeight = proportion;
    }

        public void setLeftBranchLength(double proportion)
    {
        leftBranchLength = proportion;
    }

    public void setRightBranchLength(double proportion)
    {
        rightBranchLength = proportion;
    }

    /**
     * Action:  Draw one tree and return to start position
     */
    public void act()
    {
        // Draw tree
        penDown();
        draw(depth, size);
        
        // Go back to base
        penUp();
        move(-size);
    }

    /**
     * Recursive draw method - recurses to 'depth' further levels
     */
    public void draw(int depth, double size) 
    {
        // Bottom out
        if (depth == 0) 
        {
            // Just a plain twig
            move(size);
        }
        else
        {
            // Draw two-branched tree in five parts, all recursive
            
            // First bottom part of trunk 
            draw(depth-1, size * leftBranchHeight);
            
            // Left branch
            turn(-leftBranchAngle);
            draw(depth-1, size * leftBranchLength);
            move(-size * leftBranchLength);  // Back to trunk again
            turn(leftBranchAngle);
            
            // Inter-branch space
            draw(depth-1, size * (rightBranchHeight - leftBranchHeight));
            
            // Right branch
            turn(rightBranchAngle);
            draw(depth-1, size * rightBranchLength);
            move(-size * rightBranchLength);  // Back again
            turn(-rightBranchAngle);
            
            // Top part of trunk
            draw(depth-1, size * (1-rightBranchHeight));
        }
    }
}
