import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class held_card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeldCard extends Actor
{   
    private float scale = 0.25f;
    private boolean isEnlarged = false;
    
    public enum CardType {
        AMB, ASS, CAP, CON, DUK, UNK
    }

    public HeldCard(CardType cardType){
        setImage(cardType);
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
        GreenfootImage img = getImage(); 
        
        int width = getImage().getWidth();
        int height = getImage().getHeight(); 
        
        if(isEnlarged){
            img.scale(37, 56);
            setImage(img);
        } else{
            img.scale(300, 450);
            setImage(img);
        }
        
        isEnlarged = !isEnlarged;
        
    }
    public void setImage(CardType cardToSet){
        
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
