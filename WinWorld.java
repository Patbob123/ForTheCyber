import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * THE LAST WORLD: Displays the win screen when you beat all the waves
 * 
 * @author Dawson 
 * <p>
 * Modified by: Edmond
 * </p>
 * @version nov2023
 */
public class WinWorld extends SuperWorld
{
    private GreenfootImage bgImage;
    
    /**
     * Constructor for the WinWorld
     */
    public WinWorld()
    {
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);  
        
        // Set the buttons for restart and return to menu screen
        Presser restartButton = new Presser(goEnemyWorld, "restartimg.png", "restartimg.png");
        addObject(restartButton, Constants.WORLD_WIDTH/2, 2*Constants.WORLD_HEIGHT/3);
        
        Presser menuButton = new Presser(goStartWorld, "menuimg.png", "menuimg.png");
        addObject(menuButton, Constants.WORLD_WIDTH/2, 2*Constants.WORLD_HEIGHT/3+50);
        
        bgImage = new GreenfootImage("youwinBg.png");
        setBackground(bgImage);
    }
    public void act(){
        super.act();
    }
    public void goToEnemyWorld(){
        Greenfoot.setWorld(new EnemyWorld());
    }
    public void goToStartWorld(){
        Greenfoot.setWorld(new StartWorld());
    }
    
    public Function goEnemyWorld = () -> goToEnemyWorld();
    public Function goStartWorld = () -> goToStartWorld();
    
}
