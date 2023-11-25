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
        
        name = "Epick Wick's Shield";
        desc = "Reduce the damage you take and strike back /n with some force. /n Level Up: /n Strength +2 /n Defense +1";
    }

    public String activateLevelUp(){
        addLevelup();
        
        owner.setAttack(owner.getAttack()+1);
        owner.setDef(owner.getDef()+2);
        
        return owner+" gained 2 attack and 1 defense from "+getName();
    }
}
