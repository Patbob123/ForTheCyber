import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * <p>This is the UserChar class. It 
 * 
 * @Edmond
 * @Nov 7 2023
 */
public class UserChar extends Entity
{
    private double maxHp = 100;
    public UserChar(){
        
        //set hp to max at beginning
        hp = maxHp;
        side = 0;
    }
    
    public void act() 
    {
        super.act();
        if (hp<= 0){
            //if hp is 0 or less, die
            //PUT DYING ANIM HERE IN FUTURE
            getWorld().removeObject(this);
        }
    }
    
    public void setAttack(double setattack){
        //set attack... attack == dmg for now
        this.attack = setattack;
    }
    
    public void setSpeed(double setspeed){
        //set speed
        this.speed = setspeed;
    }
    
    public void setDefense(double setdefense){
        this.defense = setdefense;
    }
    
    //speed,hp,defense
    
    public void attack(){
        ArrayList<Enemy> ppl = (ArrayList<Enemy>)getObjectsInRange (1000, Enemy.class);
            for (Entity c : ppl){
                c.takeDamage(this.attack);
            }
    }
}