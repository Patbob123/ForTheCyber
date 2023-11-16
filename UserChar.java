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
    private HPBar hpBar;
    
    public UserChar(){
        //set hp to max at beginning
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
    public void assignHpBar(HPBar hpBar){
        this.hpBar = hpBar;
        
    }
    public void setHp(double hp){
        super.setHp(hp);
        getHpBar().refresh();
    }
    public HPBar getHpBar(){
        return this.hpBar;
    }
    public double getMaxHp(){
        return this.maxHp;
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