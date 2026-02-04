import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Actor
{
    
    
    /**
     * Act - do whatever the HelpButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage image;
    
    public boolean openMenu = false;
    private HelpMenu helpMenu;
    
    public HelpButton(){
        image = getImage();
        image.scale((int)(image.getWidth()/10), (int)(image.getHeight()/10));
        
        setImage(image);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            onClick();
        }
    }
    
    private void onClick(){
        if(!openMenu){
            helpMenu = new HelpMenu(this);
            getWorld().addObject(helpMenu, 1600/2, 900/2);
        }else{
            getWorld().removeObject(helpMenu);
        }
        
        openMenu = !openMenu;
    }
}
