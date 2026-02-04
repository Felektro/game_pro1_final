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
    
    int[][] allPlayerPos = {{300, 700}, {150, 450}, {300, 200}, {800, 100}, {1300, 200}, {1450, 450}, {1300, 700}};
    
    Random rand = new Random();
    
    public HeldCard.CardType hand1;
    public HeldCard.CardType hand2;
    
    public HeldCard card1;
    public HeldCard card2;
    
    public GameManager(){
        //make invisible
        GreenfootImage img = new GreenfootImage(1, 1);
        img.setTransparency(0);
        setImage(img);
        
        setDeck();
        
        card1 = MyWorld.card1;
        card2 = MyWorld.card2;
        
    }

    public void setPlayers(int numPlayers){
        
        int [][] customPlayerPos = new int[numPlayers-1][1];
        
        switch(numPlayers){
            case 3:
                customPlayerPos[0] = allPlayerPos[2];
                customPlayerPos[1] = allPlayerPos[4];
                break;
            
            case 4:
                customPlayerPos[0] = allPlayerPos[2];
                customPlayerPos[1] = allPlayerPos[4];
                customPlayerPos[2] = allPlayerPos[2];
                break;
                
            case 5:
                customPlayerPos[0] = allPlayerPos[2];
                customPlayerPos[1] = allPlayerPos[4];
                customPlayerPos[2] = allPlayerPos[2];
                customPlayerPos[3] = allPlayerPos[4];
                break;
                
            case 6:
                customPlayerPos[0] = allPlayerPos[2];
                customPlayerPos[1] = allPlayerPos[4];
                customPlayerPos[2] = allPlayerPos[2];
                customPlayerPos[3] = allPlayerPos[4];
                customPlayerPos[4] = allPlayerPos[2];
                break;
            
        }
        
        for(int i = 0; i < customPlayerPos.length; i++){
            
            EnemyPlayer player = new EnemyPlayer(customPlayerPos[i][0], customPlayerPos[i][1], getWorld(), i+1);
            
            
            getWorld().addObject(player, customPlayerPos[i][0], customPlayerPos[i][1]);
        }
    }
    
    public void setDeck(){
        for (HeldCard.CardType card : HeldCard.CardType.values()) {
            if(card != HeldCard.CardType.UNK){
                deckOfCards.add(card);
                deckOfCards.add(card);
                deckOfCards.add(card);
            }
        }
        
        //System.out.println(deckOfCards);

    }
    
    public HeldCard.CardType pullACard(){
        int selCard = rand.nextInt(deckOfCards.size());
        HeldCard.CardType pickedCard;
        
        pickedCard = deckOfCards.get(selCard);
        
        deckOfCards.remove(selCard);
        
        return pickedCard;
    }
    
    public void assignCard(boolean firstCard, HeldCard.CardType newCard){
        if(firstCard){
            hand1 = newCard;
            card1.setImage(hand1, 0.25f);
        }else{
            hand2 = newCard;
            card2.setImage(hand2, 0.25f);
        }
    }
    
    public void act()
    {
        if(firstTime){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username for the group chat: ");
            network = NetworkClientActor.startClient(scanner.nextLine());
            firstTime = false;
            
            assignCard(true, pullACard());
            assignCard(false, pullACard());
            
            setPlayers(3);
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
