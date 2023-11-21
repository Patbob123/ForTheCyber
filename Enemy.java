import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Entity
{
    public Enemy(){
        side = 1;
        hpBar = new HPBar(this);
        assignHpBar(hpBar);
    }
    public void addedToWorld(World w){
        w.addObject(getHpBar(), 0, 0);
    }
    public void act() 
    {
        super.act();
        dragHpBar();
    }   
    public void dragHpBar(){
        getHpBar().setLocation(getX(), getY()+60);
    }
    

}
