import greenfoot.*;
/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Shield
     */
    public Shield()
    {
        portraitImage = new GreenfootImage("augment/shield.png");
        scaleImage(portraitImage);
        
        name = "Epic Wick's Shield";
        desc = "Go invis";
    }

    public String activateLevelUp(){
        addLevelup();
        
        owner.setAttack(owner.getAttack()+1);
        owner.setDef(owner.getDef()+2);
        
        return owner+" gained 2 attack and 1 defense from "+getName();
    }
}
