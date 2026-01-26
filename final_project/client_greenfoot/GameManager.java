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

    public GameManager(World world){
        //make invisible
        GreenfootImage img = new GreenfootImage(1, 1);
        img.setTransparency(0);
        setImage(img);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");

        //getClass().NetworkClientActor().username = scanner.nextLine();
        
        NetworkClientActor.startClient(scanner.nextLine());
        
        System.out.println(world.getObjects(NetworkClientActor.class));
        
        //network = (NetworkClientActor) world.getObjects(NetworkClientActor.class).get(0);
    }

    public void act()
    {
        String pressedKey = Greenfoot.getKey();
        
        if(pressedKey != null){
            System.out.println(pressedKey + " just got pressed");
            network.sendToServer(pressedKey);
        }
    }
}
