import java.util.HashMap;
import greenfoot.*;
/**
 * Write a description of class Augment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Augment  
{
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
    
    public Augment()
    {

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
    public void activateLevelUp(UserChar u){
        //Default does nothing
    }
    public void activateUserTurn(){
        //Default does nothing
    }
    public void activateEnemyTurn(){
        //Default does nothing
    }
    public static Augment getAugment(String augment){
        return augmentMap.get(augment);
    }
}
