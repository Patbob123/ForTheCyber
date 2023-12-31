import greenfoot.*;
/**
 * Vest gives the user regeneration on every turn
 * 
 * @author Dawson
 * @version November 2023
 */
public class Vest extends Augment 
{
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

    /**
     * Method to level up the augment
     */
    public String activateLevelUp(){
        addLevelup();
        
        owner.setDef(owner.getDef()+1);
        return owner+" gained 1 defense "+getName();
    }
    
    /**
     * Method to activate when it is owner's turn
     */
    public String activateOwnerTurn(){
        owner.heal(2);
        return owner+" heal 2 damage from "+getName();
    }
}
