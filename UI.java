import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UI class converts GreenfootImages into Objects so that they can be added to the world
 * 
 * @author Rex
 * @version November 2023
 */
public class UI extends Actor
{
    public UI(int width, int height) {
        GreenfootImage rectangleImage = new GreenfootImage(width, height);
        rectangleImage.setColor(Color.BLACK);
        rectangleImage.fill();
        setImage(rectangleImage);
    }
    public UI(GreenfootImage image, boolean scale) {
        if(scale){
            image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        }
        setImage(image);
    }
    
    /**
     * Act - do whatever the UI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
