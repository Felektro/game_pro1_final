import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinPile extends Actor
{
    private GreenfootImage image;
    private OptionMenu optionMenu;
    
    public CoinPile(OptionMenu optionMenu){
        this.optionMenu = optionMenu;
        
        setImage("coins.png");
        image = getImage();
        image.scale((int)(image.getWidth()*0.3), (int)(image.getHeight()*0.3));
        
        setImage(image);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            System.out.println("pressed coins button");
            
            optionMenu.grabMoneySetup();
        }
    }
}
