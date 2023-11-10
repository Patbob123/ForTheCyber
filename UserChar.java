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
        if (isDead()){
            //if hp is 0 or less, die
            //PUT DYING ANIM HERE IN FUTURE
            getWorld().removeObject(this);
        }
    }
    
    //set attack, speed, hp, defense
    
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
    
    public void setHp(double sethp){
        this.hp = sethp;
    }

    //get attack, speed, hp, defense
    
    public double getAttack(){
        //attack == dmg for now
        return(this.attack);
    }
    
    public double getSpeed(){
        return(this.speed);
    }
    
    public double getDefense(){
        return(this.defense);
    }
    
    public double getHp(){
        return(this.hp);
    }
    
    /*public void Attack(实体目标){
        //使通过参数发送的目标受到伤害
        目标.takeDamage(攻击);
    }*/
    
    public void attackAll(){
        ArrayList<Enemy> ppl = (ArrayList<Enemy>)getObjectsInRange (2000, Enemy.class);
        for (Entity e : ppl){
            e.takeDamage(this.attack);
        }
    }
}