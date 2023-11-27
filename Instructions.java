import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Popup
{
    private GreenfootImage instructionImage = new GreenfootImage("instruction.png");
    private boolean clicked;
    
    public Instructions(){
        instructionImage.scale(instructionImage.getWidth()*Constants.IMAGE_SCALING, instructionImage.getHeight()*Constants.IMAGE_SCALING);
        setImage(instructionImage);
    }
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
