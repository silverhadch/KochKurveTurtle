import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
//import java.awt.Color;



/** 
 * A basic turtle.
 *
 * @author Poul Henriksen
 * @version 1.0.2
 */
public class Turtle extends Actor
{
    /** Whether the turtle should paint or not. */
    private boolean penDown;
    
    /** Colour of the pen. */
    private String color = "black";
    
    /** The direction the turtle is facing. */
    private double direction;
    
    /** The x location. */
    private double x;
    
    /** The y location. */
    private double y;
    
    /** The maximum value that the direction can have. */
    private final static double MAX_ANGLE = 360;
    
    /** Image used when the pen is up */
    private GreenfootImage penUpImage;
    
    /** Image used when the pen is down */
    private GreenfootImage penDownImage;
    
    public Turtle()
    {
        penUpImage = getImage();
        penDownImage = new GreenfootImage(penUpImage);
        drawPen(penDownImage);
        
    }

    /**
     * Turns the turtle.
     * 
     */
    public void turn(double degrees)
    {
        direction = direction + degrees;
        if (direction > MAX_ANGLE) {
            direction = direction % MAX_ANGLE;
        }
        setRotation((int)direction);
    }
    
    /**
     * Force override of Actor::turn(int) as well
     */
    public void turn(int degrees)
    {
        turn((double)degrees);
    }
    
    /**
     * Moves the turtle to the given position.
     */
    public void moveTo(double newX, double newY)
    {
        if (penDown) {
            drawLine(x, y, newX, newY);
        }
        x = newX;
        y = newY;
        setLocation(x, y);
    }

    /**
     * Moves the turtle the given distance.
     */
    public void move(double distance)
    {
        double directionRad = Math.toRadians(direction);
        double xDist = distance * Math.cos(directionRad);
        double yDist = distance * Math.sin(directionRad);
        moveTo(x + xDist, y + yDist);
    }
 
    /**
     * Force override of Actor::move(int) as well
     */
    public void move(int distance)
    {
        move((double)distance);
    }
    
    /**
     * Takes the pen up.
     */
    public void penUp()
    {
        penDown = false;
        setImage(penUpImage);
    }

    /**
     * Puts the pen down.
     */
    public void penDown()
    {
        penDown = true;
        setImage(penDownImage);
    }

    /** 
     * Set the color of the pen.
     * Accepted colours are: "red", "black", "blue", "yellow", "green", "magenta", "white"
     */
    public void setColor(String newColor)
    {
        color = newColor;
        drawPen(penDownImage);
    }
    
    private greenfoot.Color decode(String colorString) {
    if (colorString.equals("red"))
        return greenfoot.Color.RED;
    else if (colorString.equals("black"))
        return greenfoot.Color.BLACK;
    else if (colorString.equals("blue"))
        return greenfoot.Color.BLUE;
    else if (colorString.equals("yellow"))
        return greenfoot.Color.YELLOW;
    else if (colorString.equals("green"))
        return greenfoot.Color.GREEN;
    else if (colorString.equals("magenta"))
        return greenfoot.Color.MAGENTA;
    else if (colorString.equals("white"))
        return greenfoot.Color.WHITE;
    else
        return greenfoot.Color.BLACK;
}

    
    
    /**
     * We need to make sure that our own representaion of the location is the
     * same as the World's.
     */
    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }

    /**
     * Draw a line between to point with the current colour.
     */
    private void drawLine(double x1, double y1, double x2, double y2)
    {
        GreenfootImage image = getWorld().getBackground();
        Color awtColor = decode(color);
        image.setColor(awtColor);
        image.drawLine((int) Math.ceil(x1) , (int) Math.ceil(y1), (int) Math.ceil(x2), (int) Math.ceil(y2));
    }

    /** 
     * Draw the pen on the back of the turtle with the correct colour 
     */
    private void drawPen(GreenfootImage image)
    {
        double halfWidth = image.getWidth() / 2.;
        double halfHeight = image.getHeight() / 2.;
        int penWidth = (int) halfWidth / 2;
        int penHeight = (int) halfHeight / 2;
        int penX = (int) (halfWidth - penWidth / 2);
        int penY = (int) (halfHeight - penHeight / 2);
        Color awtColor = decode(color);
        image.setColor(awtColor);
        image.fillOval(penX - 3, penY - 1, penWidth, penHeight);
    }
    
    /**
     * Set the location of the turtle.
     */
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
        super.setLocation((int) Math.floor(x), (int) Math.floor(y));
    }
    
    /**
     * We need to override this method, so we can interactively move objects.
     * This method should not be used by subclasses. Use the 
     * setLocation(double x, double y) instead
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
        super.setLocation(x,y);
    }
}