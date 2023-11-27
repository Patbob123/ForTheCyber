import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile class for ranged animation
 * 
 * @author Dawson
 * @version November 26 2023
 */
public class Projectile extends SuperSmoothMover
{
    private GreenfootImage projectileImage; 
    private int duration;
    
    /**
     * Makes an image of this url, with set duration
     * 
     * @param projectileImageUrl
     */
    public Projectile(String projectileImageUrl) {
        projectileImage = new GreenfootImage(projectileImageUrl);
        projectileImage.scale(projectileImage.getWidth()*Constants.IMAGE_SCALING, projectileImage.getHeight()*Constants.IMAGE_SCALING);
        duration = 60; 
        setImage(projectileImage);
    }
    
    
    /**
     * Duration ticks down, until it reaches 0 and removes itself from world
     */
    public void act()
    {
        duration--;
        if(duration == 0) {
            getWorld().removeObject(this);
        }
    }
}
