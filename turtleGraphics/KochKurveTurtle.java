import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KochKurveTurtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KochKurveTurtle extends Turtle
{
    
    public KochKurveTurtle () 
    {
         penDown();
         
    }
    
    /**
     * Act - do whatever the KochKurveTurtle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        drawKochSchneeflocke(200, 4); 
    }
    
    public void drawKochKurve(double länge, int tiefe) {
    if (tiefe == 0) {
        move(länge); // Basisfall: Linie zeichnen
    } else {
        länge /= 3.0; // Länge aufteilen
        drawKochKurve(länge, tiefe - 1);
        
        turn(-60); // 60° gegen Uhrzeigersinn für den "Höcker"
        drawKochKurve(länge, tiefe - 1);
        
        turn(120); // 120° im Uhrzeigersinn für das andere Segment des Höckers
        drawKochKurve(länge, tiefe - 1);
        
        turn(-60); // Zurück
        drawKochKurve(länge, tiefe - 1);
    }
}

public void drawKochSchneeflocke(double länge, int tiefe) {
    penDown(); // Stift nach unten setzen, damit die Turtle zeichnet
    for (int i = 0; i < 3; i++) {
        drawKochKurve(länge, tiefe);
        turn(120); // 120° für den nächsten "Arm" der Schneeflocke
    }
    penUp(); // Stift wieder hochnehmen
}


}
