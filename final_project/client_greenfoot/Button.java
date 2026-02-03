import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{   
    public enum ButtonAction {
        close, gg1, gg2, gg3
    }
    
    public ButtonAction action;
    
    public Button(GreenfootImage img){
        setImage(img);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            OnClick(action);
        }    
    }
    
    public void OnClick(ButtonAction act){
        switch (act) {
            case close:
                System.out.println("closed");
                break;
            
            case gg1:
                System.out.println("grabbed 1 coin");
                break;
        
            case gg2:
                System.out.println("grabbed 2 coin");
                break;
        
            case gg3:
                System.out.println("grabbed 3 coin");
                break;
        
            default:
                System.out.println("No such action");
                break;
        }
    }
}
