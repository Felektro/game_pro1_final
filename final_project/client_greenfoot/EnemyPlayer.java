import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyPlayer extends Actor
{
    
    public int scrNum;
    private GreenfootImage image;
    public HeldCard card1;
    public HeldCard card2;
    
    private int xOffset = 130;
    private int yOffset = 130;
    private int xPos;
    private int yPos;
    private World world;
    
    public EnemyPlayer(int x, int y, World world, int num){
        setImage("player.png");
        image = getImage();
        image.scale((int)(image.getWidth()/4), (int)(image.getHeight()/4));
        image.setTransparency(255);
        
        setImage(image);
        
        xPos = x;
        yPos = y;
        
        this.world = world;
        scrNum = num;
        
        card1 = new HeldCard(HeldCard.CardType.UNK, 0.1f);
        card2 = new HeldCard(HeldCard.CardType.UNK, 0.1f);
        
        spawnCards();
        
    }
    
    private void spawnCards(){
        if(scrNum>4){
            xOffset = xOffset*-1;
        }else if(scrNum == 4){
            xOffset = 0;
        }
        
        if(scrNum == 1 || scrNum == 7){
            yOffset = yOffset*-1;
        }else if(scrNum == 2 || scrNum == 6){
            yOffset = 0;
        }
        
        world.addObject(card1, xPos + xOffset - 35, yPos + yOffset);
        world.addObject(card2, xPos + xOffset + 35, yPos + yOffset);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
