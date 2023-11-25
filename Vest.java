import greenfoot.*;
/**
 * Write a description of class Vest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vest extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Vest
     */
    public Vest()
    {
        portraitImage = new GreenfootImage("augment/vest.png");
        scaleImage(portraitImage);
        
        name = "Kevlar Armor";
        desc = "The armor made for healing and /n withstanding anything /n that comes your way. /n Level Up: /n Defense +1";
    }

    public String activateLevelUp(){
        addLevelup();
        
        owner.setDef(owner.getDef()+1);
        return owner+" gained 1 defense "+getName();
    }
    public String activateOwnerTurn(){
        owner.heal(2);
        return owner+" heal 2 damage from "+getName();
    }
}
