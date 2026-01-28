import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PokerTable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokerTable extends Actor
{
    private GreenfootImage image;
    public PokerTable(){
        setImage("poker_table.png");
        image = getImage();
        image.scale((int)(image.getWidth()*2.5), (int)(image.getHeight()*2.5));
        
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
