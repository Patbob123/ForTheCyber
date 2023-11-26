import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * THE FOURTH WORLD: The world where the user can customize their character before the simulation starts
 * 
 * @author Rex 
 * <p>
 * Modified by: Dawson 
 * </p>
 * @version November, 24, 2023
 */
public class BuilderWorld extends SuperWorld
{
    private boolean doneMaking;
    private int maxPoints;
    private int curPoints;
    private UserChar userCharInstance;
    private ArrayList<ArrayList<Enemy>> stages;
    private String curAugment;
    private CustomizePanel cp;
    
    private StatSetter attackSetter;
    private StatSetter defSetter;
    private StatSetter speedSetter;
    private StatSetter hpSetter;
    private TextPlace pointsLeftDisplay;
    private Presser nextButton;
    
    private GreenfootImage builderImage = new GreenfootImage("builderworld.png");
    private GreenfootImage builderBgImage = new GreenfootImage("builderworldbg.png");
    private GreenfootImage readyImage = new GreenfootImage("ready.png");
    private GreenfootImage notReadyImage = new GreenfootImage("builderworldbg.png");

    
    /**
     * Constructor for creating BuilderWorld.
     * 
     * @param stages        An array list that stores all enemies that are added to the stages
     */
    public BuilderWorld(ArrayList<ArrayList<Enemy>> stages)
    {
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1); 
        
        this.stages = stages;
        maxPoints = 18;
        curPoints = 0;
        
        UI builderUI = new UI(builderImage,true);
        UI eblackRectangle = new UI(200, 800);
        addObject(builderUI, getWidth()/2, getHeight()/2);
        
        // Add stat options to the world
        attackSetter = new StatSetter(setAttackFunc, 1 , "atk", 50, 170);  
        defSetter = new StatSetter(setDefFunc, 1 , "def", 50, 310);  
        speedSetter = new StatSetter(setSpeedFunc, 1 , "speed", 50, 450);  
        hpSetter = new StatSetter(setHpFunc, 10 , "hp", 50, 590);  
        
        pointsLeftDisplay = TextPlace.initTextDisplay(String.valueOf(maxPoints-curPoints), 150, 720, 100, true);
        
        
        addObject(attackSetter, 0, 0);
        addObject(defSetter, 0, 0);
        addObject(speedSetter, 0, 0);
        addObject(hpSetter, 0, 0);
        
        addObject(pointsLeftDisplay, 50, 620);
        pointsLeftDisplay.setSentence(String.valueOf(maxPoints-curPoints));
        
        // Add Buttons on the Screen
        Presser marmButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Robot Arm");
        Presser mlegButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Robot Leg");
        Presser cloakButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Stealth Cloak");
        Presser vestButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Kevlar Vest");
        Presser syringeButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Syringe");
        Presser shieldButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Shield");
        Presser longarmButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Long Arm");
        Presser taserButton = new Presser(setAugment, "augmentbutton.png", "augmentbuttonFlashed.png", "Taser");
        
        addObject(marmButton, 650, 400);
        addObject(mlegButton, 550, 500);
        addObject(cloakButton, 508, 200);
        addObject(vestButton, 508, 300);
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

        readyImage = new GreenfootImage("ready.png");
        readyImage.scale(readyImage.getWidth()*Constants.IMAGE_SCALING, readyImage.getHeight()*Constants.IMAGE_SCALING);
        notReadyImage = new GreenfootImage("notready.png");
        notReadyImage.scale(notReadyImage.getWidth()*Constants.IMAGE_SCALING, notReadyImage.getHeight()*Constants.IMAGE_SCALING);
        nextButton = new Presser(goBattleWorld, "notready.png", "notready.png");
        addObject(nextButton, 500, 700);  
        
        userCharInstance = new UserChar();
        doneMaking = false;

        

        sm.playSoundLoop("builderMusic");
        sm.fadeIn("builderMusic");
        builderBgImage.scale(builderBgImage.getWidth()*Constants.IMAGE_SCALING, builderBgImage.getHeight()*Constants.IMAGE_SCALING);
        setBackground(builderBgImage);
    }
    
    /**
     * Act method
     */
    public void act(){
        super.act();
        
        if(Greenfoot.mouseClicked(null)){
            //click sound
            sm.playSound("blip");
        }
        if(userCharInstance.getAugment()==null||cp.getMoveset().size()==0){
            nextButton.setButtonImage(notReadyImage);
        }else{
            nextButton.setButtonImage(readyImage);
        }
        
    }

    /**
     * Calculate how many points the user has for stats
     * 
     * @param prevAmount        Previous amount of stat points 
     * @param postAmount        Post amount of stat points
     * 
     * @return True or false
     */ 
    private boolean checkPoints(double prevAmount, double postAmount){
        if(prevAmount < postAmount){
            if(curPoints < maxPoints && postAmount < 10){
                curPoints++;
                pointsLeftDisplay.setSentence(String.valueOf(maxPoints-curPoints));
                return true;
            }
        }else{
            if(postAmount > 0){
                curPoints--;
                pointsLeftDisplay.setSentence(String.valueOf(maxPoints-curPoints));
                return true;
            }
        }
        return false;
    }
    
    /**
     * Sets User char HP
     * 
     * @param hp     The hp of the user character
     */
    private void setHp(double hp){
        sm.playSound("click");
        if(!checkPoints(getUserChar().getHp()/10, hp/10)) return;
        getUserChar().setHp(hp);
        hpSetter.update(hp/10);
    }
    
    /**
     * Sets User char defense
     * 
     * @param def     The def of the user character
     */
    private void setDef(double def){
        sm.playSound("click");
        if(!checkPoints(getUserChar().getDef(), def)) return;
        getUserChar().setDef(def);
        defSetter.update(def);
    }
    
    /**
     * Sets User char attack
     * 
     * @param attk     The attack of the user character
     */
    private void setAttack(double attk){
        sm.playSound("click");
        if(!checkPoints(getUserChar().getAttack()-3, attk)) return;
        getUserChar().setAttack(attk);
        attackSetter.update(attk);
    }
    
    /**
     * Sets User char speed
     * 
     * @param speed     The speed of the user character
     */
    private void setSpeed(double speed){
        sm.playSound("click");
        if(!checkPoints(getUserChar().getSpeed(), speed)) return;
        getUserChar().setSpeed(speed);
        speedSetter.update(speed);
    }
    
    /**
     * Sets User char augment
     * 
     * @param augment     The augment of the user character
     */    
    private void setAugment(String augment){
        sm.playSound("click");
        userCharInstance.setAugment(Augment.getAugment(augment));
        cp.goToAugment();
    }
        
    /**
     * Get User char
     * 
     * @return User character
     */
    public UserChar getUserChar() {
        return userCharInstance;
    }
    
    /**
     * Check if user has selected an augment and move, before switching to the next world
     */
    public void goToBattleWorld(){
        if(userCharInstance.getAugment()==null) return;
        if(cp.getMoveset().size()==0) return;
        userCharInstance.getAugment().activateInitial();
        userCharInstance.setMoveset(cp.getMoveset());
        goToWorld(new BattleWorld(userCharInstance, stages));
    }
    
    /**
     * Lambdas functions for presser
     */
    public AugmentFunction setAugment = (augment) -> setAugment(augment);    
    public SetterFunction setHpFunc = (increment) -> setHp(getUserChar().getHp()+increment);
    public SetterFunction setDefFunc = (increment) -> setDef(getUserChar().getDef()+increment);
    public SetterFunction setAttackFunc = (increment) -> setAttack(getUserChar().getAttack()-3+increment);
    public SetterFunction setSpeedFunc = (increment) -> setSpeed(getUserChar().getSpeed()+increment);
    public Function goBattleWorld = () -> goToBattleWorld();
}
