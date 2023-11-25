import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SuperSmoothMover
{
    private GreenfootImage projectileImage; 
    private int duration;
    
    public Projectile(String projectileImageUrl) {
        projectileImage = new GreenfootImage(projectileImageUrl);
        projectileImage.scale(projectileImage.getWidth()*Constants.IMAGE_SCALING, projectileImage.getHeight()*Constants.IMAGE_SCALING);
        duration = 60; 
        setImage(projectileImage);
    }
    
    
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        duration--;
        if(duration == 0) {
            getWorld().removeObject(this);
        }
    }
}
