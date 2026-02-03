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
        
        image.setTransparency(0);
        
        setImage(image);
    }

    public void closeMenu(){
        image.setTransparency(0);
        setImage(image);
    }
    
    public Button[] addButtons(int num){
        GreenfootImage buttonImg;
        GreenfootImage closeImg = new GreenfootImage(scrWidth, scrHeight);
        closeImg.setColor(new Color(178,178,178,200));
        closeImg.fill();

        Button[] buttonList = new Button[num+1];
        
        int wid;
        int heg = 250;
        
        int offsetX = scrWidth/4;
        int offsetY = scrHeight/3;
        
        if(num == 2){
            wid = 380;
        }else if(num == 3){
            wid = 250;
        } else {
            wid = 100;
        }
        
        Button closeButton = new Button(closeImg); 
        buttonList[0] = closeButton;
        getWorld().addObject(closeButton, scrWidth/2, scrHeight/2);
        
        for(int i = 0; i<num; i++){
            buttonImg = new GreenfootImage(wid, heg);
            
            buttonImg.setColor(Color.LIGHT_GRAY);
            buttonImg.fillRect(0, 0, wid, heg);
            
            buttonImg.setColor(Color.BLACK);
            
            for(int j = 0; j<5; j++){
                buttonImg.drawRect(j, j, wid-j*2, heg-j*2);
            }
            
            buttonImg.setTransparency(255);
            
            Button button = new Button(buttonImg); 
            buttonList[i+1] = button;
            getWorld().addObject(button, (15 + wid/2 + (10 + wid)*i) + offsetX, (25 + heg/2) + offsetY);
        }
        
        return buttonList;
        
    }
    
    public void grabMoneySetup(){
        
        image.setTransparency(200);
        setImage(image);
        
        Button[] buttonList = addButtons(3);
        
        buttonList[0].action = Button.ButtonAction.close;
        buttonList[1].action = Button.ButtonAction.gg1;
        buttonList[2].action = Button.ButtonAction.gg2;
        buttonList[3].action = Button.ButtonAction.gg3;
    }
    
    boolean firsttime = true;
    public void act()
    {
        if(firsttime){
             grabMoneySetup();
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
