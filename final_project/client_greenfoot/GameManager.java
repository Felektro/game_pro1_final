import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Scanner;

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager extends Actor
{
    /**
     * Act - do whatever the GameManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private String username;
    public NetworkClientActor network;
    private boolean firstTime = true;

    public GameManager(World world){
        //make invisible
        GreenfootImage img = new GreenfootImage(1, 1);
        img.setTransparency(0);
        setImage(img);
    }

    public void act()
    {
        if(firstTime){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username for the group chat: ");
            network = NetworkClientActor.startClient(scanner.nextLine());
            firstTime = false;
        }
        
        String pressedKey = Greenfoot.getKey();
        
        if(pressedKey != null){
            network.sendMessage(pressedKey);
        }
    }
}
