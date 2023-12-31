import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HELPER CLASS: Display the sprites for the stats the user has in battle world
 * 
 * @author Dawson
 * @version November 2023
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
    private UserChar u;
    
    /**
     * Constructor for StatBar
     * 
     * @param uc     User character
     */
    public StatBar(UserChar uc){
        this.u = uc;
        
        setImage(new GreenfootImage("stats.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        
        atkContainer = new Container(atkStatImage, 9, 10);
        defContainer = new Container(defStatImage, 9, 10);
        speedContainer = new Container(speedStatImage, 9, 10);
        
        refresh();
        
        hpBar = new HPBar(this.u);
        this.u.assignHpBar(hpBar);
        this.u.assignStatBar(this);
    }
    
    /**
     * Adds StatBar to a world
     * 
     * @param w       The world it gets added to
     */
    public void addedToWorld(World w){
        getWorld().addObject(atkContainer, 470+atkContainer.getImage().getWidth()/2, 675);
        getWorld().addObject(defContainer, 470+defContainer.getImage().getWidth()/2, 725);
        getWorld().addObject(speedContainer, 470+speedContainer.getImage().getWidth()/2, 775);
        
        getWorld().addObject(hpBar, 180+hpBar.getImage().getWidth()/2, 735);       
    }
    
    /**
     * Refreshes the stat bar
     */
    public void refresh(){
        atkContainer.setContained((int)u.getAttack()-3);
        defContainer.setContained((int)u.getDef());
        speedContainer.setContained((int)u.getSpeed());
    }
}
