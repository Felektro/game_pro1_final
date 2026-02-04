import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class held_card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeldCard extends Actor
{   
    public enum CardType {
        AMB, ASS, CAP, CON, DUK, UNK
    }
    
    public CardType currentCard;
    public boolean isUI = false;

    public HeldCard(CardType cardType, float scale){
        currentCard = cardType;
        setImage(cardType, scale);
    }
    
    public HeldCard(CardType cardType){
        currentCard = cardType;
        setImage(cardType, 0.25f);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            OnClick();
            System.out.println("clicked card");
        }
    }
    public void OnClick(){
        if(isUI){
            getWorld().removeObject(this);
        }else{
            HeldCard uiCard = new HeldCard(currentCard, 1.1f);
            
            uiCard.isUI = true;
            getWorld().addObject(uiCard, 1600/2, 900/2);
        }
    }
    public void setImage(CardType cardToSet, float scale){
        
        currentCard = cardToSet;
        
        GreenfootImage img;
        
        switch(cardToSet) {
            case AMB:
                
                
                img = new GreenfootImage("coup_ambassador.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case ASS:
                
                
                img = new GreenfootImage("coup_assassin.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case CAP:
                
                
                img = new GreenfootImage("coup_captain.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case CON:
                
                
                img = new GreenfootImage("coup_contessa.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case DUK:
                
                
                img = new GreenfootImage("coup_duke.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case UNK:
                
                
                img = new GreenfootImage("coup_back.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
        }
    }
}
