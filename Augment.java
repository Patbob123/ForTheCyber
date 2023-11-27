import java.util.HashMap;
import greenfoot.*;
/**
 * Adds the Augment to the User's Character
 * 
 * @author Dawson
 * @version November 2023
 */
public abstract class Augment  
{
    //Hashmap to store all availible augments
    private static HashMap<String, Augment> augmentMap = new HashMap<String, Augment>(){{
            put("Robot Arm", new RobotArm());
            put("Robot Leg", new RobotLeg());
            put("Stealth Cloak", new Cloak());
            put("Kevlar Vest", new Vest());
            put("Syringe", new Syringe());
            put("Shield", new Shield());
            put("Long Arm", new LongArm());
            put("Taser", new Taser());
        }};;
    protected GreenfootImage portraitImage;
    protected String name;
    protected String desc;
    protected Entity owner;
    
    /**
     * Constructor for Augment
     */
    public Augment()
    {
       //Empty constructor for now 
    }
    
    /**
     * Sets the owner of the augment
     * 
     * @param owner                 Entity
     */
    public void setOwner(Entity owner){
        this.owner = owner;
    }
    
    /**
     * Method to scale the image of the augment
     * 
     * @param image               Image of augment
     */
    public void scaleImage(GreenfootImage image){
        image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        
    }
    
    /**
     * Gets list of augments
     * 
     *@return augments
     */
    public HashMap<String, Augment> getAugmentList(){
        return this.augmentMap;
    }
    
    /**
     * Returns an image portrait of the augment
     * 
     * @return portrait
     */
    public GreenfootImage getPortrait(){
        return portraitImage;
    }
    
    /**
     * Gets name of augment
     * 
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets description of augment
     * 
     * @return description
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * Methods that by default do nothing
     */
    public void activateInitial(){
        //Default does nothing
    }
    public String activateLevelUp(){
        //Default does nothing
        return "";
    }
    public String activateOwnerTurn(){
        //Default does nothing
        return "";
    }
    public String activateOpposerTurn(){
        //Default does nothing
        return "";
    }
    
    /**
     * Method to add levelup text to a world
     */
    public void addLevelup(){
        int x = owner.getWorld().getWidth()/2+owner.getWorld().getWidth()/5;
        int y = owner.getWorld().getHeight()/2-owner.getWorld().getHeight()/4;
        owner.getWorld().addObject(new Levelup(), x, y);
    }
    
    /**
     * Gets an augment
     * 
     * @param augment       Augment name
     */
    public static Augment getAugment(String augment){
        return augmentMap.get(augment);
    }
}
