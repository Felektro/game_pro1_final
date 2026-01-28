import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1600, 900, 1); 

        addObject(new GameManager(this), 0, 0);

        HelpMenu helpMenu = new HelpMenu();
        addObject(helpMenu, getWidth()/2, getHeight()/2);

        addObject(new HelpButton(helpMenu),1550,50);
        
        addObject(new PokerTable(), getWidth()/2, getHeight()/2);
    }
}
