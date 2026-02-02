import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{   
    public Button(GreenfootImage img){
        setImage(img);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            OnClick();
        }    
    }
    
    public void OnClick(){
        
    }
}
