import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class of a instruction popup
 * 
 * @author Dawson
 * @version Nov 2023
 */
public class Instructions extends Popup
{
    private GreenfootImage instructionImage = new GreenfootImage("instruction.png");
    private boolean clicked;
    
    /**
     * Constructor for Instructions 
     */
    public Instructions(){
        instructionImage.scale(instructionImage.getWidth()*Constants.IMAGE_SCALING, instructionImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(instructionImage);
    }
    
    /**
     * When you click the image becomes smaller, and moves down
     * Until its width and height is 0, which then it removes itself
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            clicked = true;
        }
        if(clicked){
            int width = instructionImage.getWidth()/2;
            int height = instructionImage.getHeight()/2;
            if(width<=0||height<=0){
                getWorld().removeObject(this);
                return;
            }
            
            instructionImage.scale(width, height);
            setLocation(getX(), Constants.WORLD_HEIGHT-instructionImage.getHeight()/2);
            setImage(instructionImage);
            
        }
    }
}
