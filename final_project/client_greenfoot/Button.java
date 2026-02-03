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
        close, gg1, gg2, gg3, blCon, lInf
    }
    
    public ButtonAction action;
    public GreenfootImage ogImg;
    private OptionMenu parentMenu;
    
    public Button(GreenfootImage img, OptionMenu parent){
        setImage(img);
        parentMenu = parent;
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
            
            case blCon:
                System.out.println("blocked assassin w contessa");
                break;
                
            case lInf:
                System.out.println("lost influence");
                break;
        
            default:
                System.out.println("No such action");
                break;
        }
        
        parentMenu.closeMenu();
    }
    
    public void setText(GreenfootImage textImg){
        if(textImg != null){
            getImage().drawImage(textImg, getImage().getWidth()/2 - textImg.getWidth()/2, getImage().getHeight()/2 - textImg.getHeight()/2);
        }
    }
}
