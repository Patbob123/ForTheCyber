import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World to display the Lose Screen when you die
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
    
    public LoseWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, 1);  
        
        
        Presser restartButton = new Presser(goEnemyWorld, "restartimg.png", "restartimg.png");
        addObject(restartButton, Constants.WORLD_WIDTH/2, 2*Constants.WORLD_HEIGHT/3);
        
        Presser menuButton = new Presser(goStartWorld, "menuimg.png", "menuimg.png");
        addObject(menuButton, Constants.WORLD_WIDTH/2, 2*Constants.WORLD_HEIGHT/3+50);
        
        bgImage = new GreenfootImage("youdiedBg.png");
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
