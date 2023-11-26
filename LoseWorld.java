import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * THE LAST WORLD: Displays the game over screen when the user dies
 * 
 * @author Dawson 
 * <p>
 * Modified by: Edmond
 * </p>
 * @version nov2023
 */
public class LoseWorld extends SuperWorld
{
    private GreenfootImage bgImage;
    
    /**
     * Constructor for the LoseWorld
     */
    public LoseWorld()
    {
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);  
        
        //user death sound
        sm.playSound("youdied");
        
        // Set the buttons for restart and return to menu screen
        Presser restartButton = new Presser(goEnemyWorld, "restartimg.png", "restartimg.png");
        addObject(restartButton, Constants.WORLD_WIDTH/2, 2*Constants.WORLD_HEIGHT/3);
        
        Presser menuButton = new Presser(goStartWorld, "menuimg.png", "menuimg.png");
        addObject(menuButton, Constants.WORLD_WIDTH/2, 2*Constants.WORLD_HEIGHT/3+50);
        
        bgImage = new GreenfootImage("youdiedBg.png");
        setBackground(bgImage);
    }
    
    /**
     * Act method
     */
    public void act(){
        super.act();
    }
    
    /**
     * Go to enemy world
     */
    public void goToEnemyWorld(){
        goToWorld(new EnemyWorld());
    }
    
    /**
     * Go to start world
     */
    public void goToStartWorld(){
        goToWorld(new StartWorld());
    }
    
    /**
     * Lambdas functions for presser
     */
    public Function goEnemyWorld = () -> goToEnemyWorld();
    public Function goStartWorld = () -> goToStartWorld();
    
    
    
}
