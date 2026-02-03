import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static HeldCard card1 = new HeldCard(HeldCard.CardType.UNK);
    public static HeldCard card2 = new HeldCard(HeldCard.CardType.UNK);

    public MyWorld()
    {    
        super(1600, 900, 1); 
        
        setPaintOrder( Button.class,CoinPile.class, OptionMenu.class, HeldCard.class, HelpButton.class,HelpMenu.class);

        addObject(new GameManager(), 0, 0);

        HelpMenu helpMenu = new HelpMenu();
        addObject(helpMenu, getWidth()/2, getHeight()/2);

        addObject(new HelpButton(helpMenu),1550,50);
        
        OptionMenu optionMenu = new OptionMenu();
        
        addObject(optionMenu, getWidth()/2, getHeight()/2);
        
        addObject(new PokerTable(), getWidth()/2, getHeight()/2);
        
        addObject(new CoinPile(optionMenu), getWidth()/2, getHeight()/2);

        addObject(card1, 850, 800);
        addObject(card2, 1010, 800);
        
        
        
    }
}
