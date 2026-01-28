import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class helpMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpMenu extends Actor
{
    /**
     * Act - do whatever the helpMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean visible = false;
    private GreenfootImage image;
    
    public HelpMenu(){
        setImage("Coup-Cheat-Sheet.jpg");
        image = getImage();
        image.scale((int)(image.getWidth()/2.5), (int)(image.getHeight()/2.5));
        image.setTransparency(0);
        
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void showHelpMenu(){
        if(visible){
            image.setTransparency(0);
            visible = false;
        }
        else{
            image.setTransparency(255);
            visible = true;
        }
        
        setImage(image);
    }
}
