import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class helpMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionMenu extends Actor
{
    /**
     * Act - do whatever the helpMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean visible = false;
    private GreenfootImage image;
    
    private int scrWidth = 1600;
    private int scrHeight = 900;
    
    public OptionMenu(){
        image = new GreenfootImage(scrWidth/2, scrHeight/3);
        
        //image.fill();
        image.setColor(Color.LIGHT_GRAY);
        image.fillRect(0, 0, scrWidth/2, scrHeight/3);
        
        image.setColor(Color.BLACK);
        
        for(int i = 0; i<5; i++){
            image.drawRect(i, i, scrWidth/2-i*2, scrHeight/3-i*2);
        }
        
        image.setTransparency(200);
        
        setImage(image);
    }
    
    public void addButtons(int num){
        GreenfootImage buttonImg;
        
        Button[] list = new Button[num];
        
        int len;
        int wid = 250;
        
        if(num == 2){
            len = 380;
        }else if(num == 3){
            len = 250;
        } else {
            len = 0;
        }
        
        for(int i = 0; i<num; i++){
            buttonImg = new GreenfootImage(len, wid);
            
            buttonImg.setColor(Color.GREEN);
            buttonImg.fillRect(0, 0, len, wid);
            
            buttonImg.setColor(Color.BLACK);
            
            for(int j = 0; j<5; j++){
                buttonImg.drawRect(j, j, len-j*2, wid-j*2);
            }
            
            buttonImg.setTransparency(255);
            
            Button button = new Button(buttonImg); 
            list[i] = button;
            getWorld().addObject(button, 0, 0);
        }
        
        System.out.println(getX() + "  " + getY());
        
        
        
    }
    boolean firsttime = true;
    public void act()
    {
        if(firsttime){
             addButtons(3);
             firsttime = false;
         }
    }
    
    public void showHelpMenu(){
        if(visible){
            image.setTransparency(0);
            visible = false;
        }
        else{
            image.setTransparency(255);
            visible = true;
        }
        
        setImage(image);
    }
}
