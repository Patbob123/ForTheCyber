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
    private CustomizePanel cp;
    
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
        
        Presser marmButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Robot Arm");
        Presser mlegButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Robot Leg");
        Presser cloakButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Stealth Cloak");
        Presser vestButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Kevlar Vest");
        Presser syringeButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Syringe");
        Presser shieldButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Shield");
        Presser longarmButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Long Arm");
        Presser taserButton = new Presser(setAugment, "augmentbutton.png", "augmentbutton.png", "Taser");
        
        addObject(marmButton, 650, 400);
        addObject(mlegButton, 550, 500);
        addObject(cloakButton, 508, 200);
        addObject(vestButton, 508, 350);
        addObject(syringeButton, 650, 350);
        addObject(shieldButton, 370, 400);
        addObject(longarmButton, 370, 350);
        addObject(taserButton, 370, 300);
        
        cp = new CustomizePanel();
        addObject(cp, 233*Constants.IMAGE_SCALING+cp.getImage().getWidth()/2, 19*Constants.IMAGE_SCALING+cp.getImage().getHeight()/2);
        Function goToAugment = () -> cp.goToAugment();
        Function goToMoveset = () -> cp.goToMoveset();
        GreenfootImage blankButtonImg = new GreenfootImage(47/3, 11/3);
        Presser toAugmentButton = new Presser(goToAugment, blankButtonImg);
        Presser toMovesetButton = new Presser(goToMoveset, blankButtonImg);
        addObject(toAugmentButton, 240*Constants.IMAGE_SCALING+toAugmentButton.getImage().getWidth()/2, 19*Constants.IMAGE_SCALING+toAugmentButton.getImage().getHeight()/2);
        addObject(toMovesetButton, 287*Constants.IMAGE_SCALING+toMovesetButton.getImage().getWidth()/2, 19*Constants.IMAGE_SCALING+toMovesetButton.getImage().getHeight()/2);

        
        Presser nextButton = new Presser(goBattleWorld, "ready.png", "ready.png");
        addObject(nextButton, 500, 700);
        // Button hpButton = new Button("life");
        // Button speedButton = new Button("speed");
        // Button attackButton = new Button("strength");
        // Button defenseButton = new Button("defense");

        // addObject(hpButton, 100, 100);
        // addObject(speedButton, 100, 200);
        // addObject(attackButton, 100, 300);
        // addObject(defenseButton, 100, 400);
        
                
        userCharInstance = new UserChar();
        doneMaking = false;
        setPaintOrder(Popup.class);
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
        userCharInstance.setAugment(Augment.getAugment(augment));
        cp.goToAugment();
    }
        
    
    public UserChar getUserChar() {
        return userCharInstance;
    }
    public void goToBattleWorld(){
        if(userCharInstance.getAugment()==null) return;
        
        userCharInstance.setMoveset(cp.getMoveset());
        Greenfoot.setWorld(new BattleWorld(userCharInstance));
    }
    
    
    
    public AugmentFunction setAugment = (augment) -> setAugment(augment);
        
    public SetterFunction setHpFunc = (increment) -> setHp(getUserChar().getHp()+increment);
    public SetterFunction setDefFunc = (increment) -> setDef(getUserChar().getDef()+increment);
    public SetterFunction setAttackFunc = (increment) -> setAttack(getUserChar().getAttack()+increment);
    public SetterFunction setSpeedFunc = (increment) -> setSpeed(getUserChar().getSpeed()+increment);
    
    
    public Function goBattleWorld = () -> goToBattleWorld();
}
