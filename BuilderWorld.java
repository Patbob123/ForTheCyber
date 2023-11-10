import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuilderWorld extends World
{
    private boolean doneMaking;
    private UserChar userCharInstance;
    
    /**
     * Constructor for objects of class StatWorld.
     * 
     */
    public BuilderWorld()
    {
        super(1024, 800, 1); 
        
        userCharInstance = new UserChar();
        
        UI blackRectangle = new UI(200, 800);
        UI eblackRectangle = new UI(200, 800);
        addObject(blackRectangle, 100, 400);
        addObject(eblackRectangle, 924, 400);
        
        Button hpButton = new Button("life");
        Button speedButton = new Button("speed");
        Button attackButton = new Button("strength");
        Button defenseButton = new Button("defense");
        
        Button armButton = new Button("Robotic arm", 50, 100);

        addObject(hpButton, 100, 100);
        addObject(speedButton, 100, 200);
        addObject(attackButton, 100, 300);
        addObject(defenseButton, 100, 400);
        
        addObject(armButton, 370, 400);

                
        userCharInstance = new UserChar();
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
    {    
        
    
    public UserChar getUserChar() {
        return userCharInstance;
    }
}
