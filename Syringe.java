import greenfoot.*;
/**
 * Write a description of class Syringe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Syringe extends Augment 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Syringe
     */
    public Syringe()
    {
        portraitImage = new GreenfootImage("augment/syringe.png");
        scaleImage(portraitImage);
        
        name = "Adrenaline Syringe";
        desc = "An elixir that grants /n you power, at the /n cost of your health. /n Level Up: /n Strength +4 /n Speed +1";
    }

    public String activateLevelUp(){
        addLevelup();
        
        owner.setAttack(owner.getAttack()+4);
        return owner+" gained 4 attack and 1 speed from "+getName();
    }
    public String activateOwnerTurn(){
        owner.takeDamage(2);
        return owner+" took 2 damage from "+getName();
    }
}
