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
    private GreenfootImage image;
    
    private HelpButton button;
    
    public HelpMenu(HelpButton button){
        setImage("Coup-Cheat-Sheet.jpg");
        image = getImage();
        image.scale((int)(image.getWidth()/2.5), (int)(image.getHeight()/2.5));
        image.setTransparency(255);
        
        setImage(image);
        
        this.button = button;
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            button.openMenu = false;
            getWorld().removeObject(this);
        }
    }
}
