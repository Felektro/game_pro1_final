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
    
    public Button[] buttonList = new Button[4];
    
    public OptionMenu(){
        image = new GreenfootImage(scrWidth/2, scrHeight/3);

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
        
        for (Button button : buttonList) {
            getWorld().removeObject(button);
            button = null;
        }
    }
    
    public Button[] addButtons(int num){
        GreenfootImage buttonImg;
        GreenfootImage closeImg = new GreenfootImage(scrWidth, scrHeight);
        closeImg.setColor(new Color(178,178,178,200));
        closeImg.fill();
        
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
        
        Button closeButton = new Button(closeImg, this); 
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
            
            Button button = new Button(buttonImg, this); 
            buttonList[i+1] = button;
            getWorld().addObject(button, (15 + wid/2 + (10 + wid)*i) + offsetX, (25 + heg/2) + offsetY);
        }
        
        return buttonList;
        
    }
    
    public void grabMoneySetup(){
        
        showOptionMenu();
        
        buttonList = addButtons(3);
        
        buttonList[0].action = Button.ButtonAction.close;
        buttonList[1].action = Button.ButtonAction.gg1;
        buttonList[2].action = Button.ButtonAction.gg2;
        buttonList[3].action = Button.ButtonAction.gg3;
        
        addButtonText();
    }
    
    public void addButtonText(){
        
        GreenfootImage textImg;
        
        for (Button button : buttonList) {
            
            switch (button.action) {
                case gg1:
                    System.out.println("adding button 1");
                    textImg = new GreenfootImage(gg1Text, 30, Color.BLACK,new Color(0, 0, 0, 0),Color.RED);
                    break;
            
                case gg2:
                    System.out.println("adding button 2");
                    textImg = new GreenfootImage(gg2Text, 30, Color.BLACK,new Color(0, 0, 0, 0),Color.RED);
                    break;
            
                case gg3:
                    System.out.println("adding button 3");
                    textImg = new GreenfootImage(gg3Text, 30, Color.BLACK,new Color(0, 0, 0, 0),Color.RED);
                    getImage().drawImage(new GreenfootImage("warning.png"), getImage().getWidth()/2 - textImg.getWidth()/2, getImage().getHeight()/2 - textImg.getHeight()/2);
                    break;
                    
                case close:
                    System.out.println("no text to add to closed");
                    textImg = null;
            
                default:
                    System.out.println("No such action");
                    textImg = null;
                    break;
            }
            
            button.setText(textImg);
            
            
        }
        
    }
    
    boolean firsttime = true;
    public void act()
    {
        if(firsttime){
             grabMoneySetup();
             firsttime = false;
         }
    }
    
    public void showOptionMenu(){
        if(visible){
            image.setTransparency(0);
            visible = false;
        }
        else{
            image.setTransparency(200);
            visible = true;
        }
        
        setImage(image);
    }
    
    private String gg1Text = "Take 1 coin \nfrom the treasury. \nCannot be blocked \nor challenged. \n";
    private String gg2Text = "Take 2 coins \nfrom the treasury. \nCan be blocked \nby a Duke. \n";
    private String gg3Text = "Duke Action:\n\nTake 3 coins \nfrom the treasury. \n";
}
