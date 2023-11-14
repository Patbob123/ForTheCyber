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
    
    
    public UserChar(){
        //set hp to max at beginning
        maxHp = 100;
        hp = maxHp;
        
        side = 0;
        name = "ssundee";
        //addAttack(
    }
    
    public void act() 
    {
        super.act();
        if (isDead()){
            //if hp is 0 or less, die
            //PUT DYING ANIM HERE IN FUTURE
            getWorld().removeObject(this);
        }
    }
    
    
    
    //public void attack(Entity target){
        
        //makes the target, who was sent through the parameter, take damage
        //target.takeDamage(attack);
    //}
    
    public void attackAll(){
        ArrayList<Enemy> ppl = (ArrayList<Enemy>)getObjectsInRange (2000, Enemy.class);
        for (Entity e : ppl){
            e.takeDamage(this.attack);
        }
    }
}