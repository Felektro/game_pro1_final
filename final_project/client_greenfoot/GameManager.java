import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Scanner;
import java.util.*;

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
    
    public int money = 2;

    private String username;
    public NetworkClientActor network;
    private boolean firstTime = true;
    
    ArrayList<HeldCard.CardType> deckOfCards = new ArrayList<HeldCard.CardType>(); 
    
    Random rand = new Random();


    public GameManager(){
        //make invisible
        GreenfootImage img = new GreenfootImage(1, 1);
        img.setTransparency(0);
        setImage(img);
        
        setDeck();
    }

    public void setDeck(){
        for (HeldCard.CardType card : HeldCard.CardType.values()) {
            if(card != HeldCard.CardType.UNK){
                deckOfCards.add(card);
                deckOfCards.add(card);
                deckOfCards.add(card);
            }
        }
        
        System.out.println(deckOfCards);

    }
    
    public HeldCard.CardType pullACard(){
        int selCard = rand.nextInt(deckOfCards.size());
        HeldCard.CardType pickedCard;
        
        pickedCard = deckOfCards.get(selCard);
        
        System.out.println(selCard);
        System.out.println(pickedCard);
        System.out.println(deckOfCards);
        
        deckOfCards.remove(selCard);
        
        System.out.println(deckOfCards);
        
        return pickedCard;
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
            
            System.out.println(pressedKey);
            
            if(network != null){
                network.sendMessage(pressedKey);    
            }
            
            if(pressedKey == "1"){
                grabCoin(1);
            }
            if(pressedKey == "2"){
                grabCoin(2);
            }
            if(pressedKey == "3"){
                grabCoin(3);
            }
        }
    }

    public void grabCoin(int amount){
        switch (amount) {
            case 1:
                System.out.println("grabbed 1 coin");
                money++;
                break;
        
            case 2:
                System.out.println("grabbed 2 coin");
                money = money + 2;
                //blocking logic
                break;
        
            case 3:
                System.out.println("grabbed 3 coin");
                money = money + 3;
                //duke logic
                break;
        
            default:
                System.out.println("Too many coins requested");
                break;
        }
        
        System.out.println(username + " has " + money + " coins!");
    }
}
