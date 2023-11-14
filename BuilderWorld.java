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
    private String curAugment;
    
    private GreenfootImage builderImage = new GreenfootImage("builderworld.png");
    /**
     * Constructor for objects of class StatWorld.
     * 
     */
    public BuilderWorld()
    {
        super(1008, 816, 1); 
        
        userCharInstance = new UserChar();
        
        UI builderUI = new UI(builderImage);
        UI eblackRectangle = new UI(200, 800);
        addObject(builderUI, getWidth()/2, getHeight()/2);
        //addObject(blackRectangle, 100, 400);
        //addObject(eblackRectangle, 924, 400);
        
        StatSetter attackSetter = new StatSetter(setAttackFunc, 1 , "atk", 50, 170, this);  
        StatSetter defSetter = new StatSetter(setDefFunc, 1 , "def", 50, 310, this);  
        StatSetter speedSetter = new StatSetter(setSpeedFunc, 1 , "speed", 50, 450, this);  
        StatSetter hpSetter = new StatSetter(setHpFunc, 1 , "hp", 50, 590, this);  
        
        Presser marmButton = new Presser(setAugment, "ready.png", "ready.png", "Mech Arm");
        Presser scopeButton = new Presser(setAugment, "ready.png", "ready.png", "360 No Scope");
        
        addObject(marmButton, 370, 200);
        addObject(scopeButton, 370, 300);
        
        Presser nextButton = new Presser(goBattleWorld, "ready.png", "ready.png");
        addObject(nextButton, 500, 700);
        // Button hpButton = new Button("life");
        // Button speedButton = new Button("speed");
        // Button attackButton = new Button("strength");
        // Button defenseButton = new Button("defense");
        
        Button armButton = new Button("Robotic arm", 50, 100);

        // addObject(hpButton, 100, 100);
        // addObject(speedButton, 100, 200);
        // addObject(attackButton, 100, 300);
        // addObject(defenseButton, 100, 400);
        
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
        BattleWorld w = new BattleWorld(userCharInstance);
        Greenfoot.setWorld(w);
    }
    
    //set hp private methods for builderworld
    
    private void setHp(double hp){
        getUserChar().setHp(hp);
    }
    
    private void setDef(double def){
        getUserChar().setDef(def);
    }
    
    private void setAttack(double attk){
        getUserChar().setAttack(attk);
    }
    
    private void setSpeed(double speed){
        getUserChar().setSpeed(speed);
    }
    
    private void setAugment(String augment){
        curAugment = augment;
    }
        
    
    public UserChar getUserChar() {
        return userCharInstance;
    }
    public void goToBattleWorld(){
        if(curAugment==null) return;
        Augment.applyAugment(curAugment, userCharInstance);
        Greenfoot.setWorld(new BattleWorld(userCharInstance));
    }
    
    public AugmentFunction setAugment = (augment) -> setAugment(augment);
    
    public SetterFunction setHpFunc = (increment) -> setHp(getUserChar().getHp()+increment);
    public SetterFunction setDefFunc = (increment) -> setDef(getUserChar().getDef()+increment);
    public SetterFunction setAttackFunc = (increment) -> setAttack(getUserChar().getAttack()+increment);
    public SetterFunction setSpeedFunc = (increment) -> setSpeed(getUserChar().getSpeed()+increment);

    public Function goBattleWorld = () -> goToBattleWorld();
}
