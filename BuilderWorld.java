import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuilderWorld extends World
{
    UserChar uc;
    
    private boolean doneMaking;
    
    /**
     * Constructor for objects of class StatWorld.
     * 
     */
    public BuilderWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        uc = new UserChar();
        doneMaking = false;
    }
    
    public void act(){
        if (doneMaking){
            setBattleWorld();
        }
    }
    
    private void setBattleWorld(){
        BattleWorld w = new BattleWorld(uc);
        Greenfoot.setWorld(w);
    }
    
    //set hp private methods for builderworld
    
    private void setHp(double hp){
        uc.setHp(hp);
    }
    
    private void setDef(double def){
        uc.setDef(def);
    }
    
    private void setAttack(double attk){
        uc.setAttack(attk);
    }
    
    private void setSpeed(double speed){
        uc.setSpeed(speed);
    }
}
