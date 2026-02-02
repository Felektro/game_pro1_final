import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class held_card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeldCard extends Actor
{
    /**
     * Act - do whatever the held_card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public enum CardType {
        AMB, ASS, CAP, CON, DUK, UNK
    }

    public HeldCard(CardType cardType){
        setImage(cardType, 0.25f);
    }

    public void act()
    {
        // Add your action code here.
    }
    
    public void setImage(CardType cardToSet, float scale){
        
        GreenfootImage img;
        
        switch(cardToSet) {
            case AMB:
                System.out.println("Seting to " + cardToSet);
                
                img = new GreenfootImage("coup_ambassador.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case ASS:
                System.out.println("Seting to " + cardToSet);
                
                img = new GreenfootImage("coup_assassin.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case CAP:
                System.out.println("Seting to " + cardToSet);
                
                img = new GreenfootImage("coup_captain.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case CON:
                System.out.println("Seting to " + cardToSet);
                
                img = new GreenfootImage("coup_contessa.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case DUK:
                System.out.println("Seting to " + cardToSet);
                
                img = new GreenfootImage("coup_duke.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
            case UNK:
                System.out.println("Seting to " + cardToSet);
                
                img = new GreenfootImage("coup_back.png");
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                setImage(img);
                
                break;
        }
    }
}
