import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatBar extends Actor
{
    private GreenfootImage atkStatImage = new GreenfootImage("strStat.png");
    private GreenfootImage defStatImage = new GreenfootImage("defStat.png");
    private GreenfootImage speedStatImage = new GreenfootImage("speedStat.png");
    
    private Container atkContainer;
    private Container defContainer;
    private Container speedContainer;
    private HPBar hpBar;
    
    public StatBar(UserChar uc){
        setImage(new GreenfootImage("stats.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        
        atkContainer = new Container(atkStatImage, 9, 10);
        defContainer = new Container(defStatImage, 9, 10);
        speedContainer = new Container(speedStatImage, 9, 10);
        
        atkContainer.setContained(4);
        defContainer.setContained(9);
        speedContainer.setContained(3);
        
        hpBar = new HPBar(uc);
        uc.assignHpBar(hpBar);
    }
    public void addedToWorld(World w){
        getWorld().addObject(atkContainer, 470+atkContainer.getImage().getWidth()/2, 675);
        getWorld().addObject(defContainer, 470+defContainer.getImage().getWidth()/2, 725);
        getWorld().addObject(speedContainer, 470+speedContainer.getImage().getWidth()/2, 775);
        
        getWorld().addObject(hpBar, 180+hpBar.getImage().getWidth()/2, 735);       
    }
}
