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
    
    public Augment()
    {
       //Empty constructor for now 
    }
    public void setOwner(Entity owner){
        this.owner = owner;
    }
    public void scaleImage(GreenfootImage image){
        image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        
    }
    public HashMap<String, Augment> getAugmentList(){
        return this.augmentMap;
    }
    public GreenfootImage getPortrait(){
        return portraitImage;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
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
    public void addLevelup(){
        int x = owner.getWorld().getWidth()/2+owner.getWorld().getWidth()/5;
        int y = owner.getWorld().getHeight()/2-owner.getWorld().getHeight()/4;
        owner.getWorld().addObject(new Levelup(), x, y);
    }
    public static Augment getAugment(String augment){
        return augmentMap.get(augment);
    }
}
