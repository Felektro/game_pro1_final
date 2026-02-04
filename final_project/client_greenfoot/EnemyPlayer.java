import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyPlayer extends Actor
{
    
    private GreenfootImage image;
    
    public EnemyPlayer(){
        setImage("player.png");
        image = getImage();
        image.scale((int)(image.getWidth()/4), (int)(image.getHeight()/4));
        image.setTransparency(255);
        
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
