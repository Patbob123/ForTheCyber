import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UI class converts GreenfootImages into Objects so that they can be added to the world
 * 
 * @author Rex
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class UI extends Actor
{
    
    /**
     * Makes a black UI, with width and height
     * 
     * @param width
     * @param height
     */
    public UI(int width, int height) {
        GreenfootImage rectangleImage = new GreenfootImage(width, height);
        rectangleImage.setColor(Color.BLACK);
        rectangleImage.fill();
        setImage(rectangleImage);
    }
    
    /**
     * Makes a UI, with the image given
     * 
     * @param image
     * @param scale       The image will be scaled to constant scaling if this is true
     */
    public UI(GreenfootImage image, boolean scale) {
        if(scale){
            image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        }
        setImage(image);
    }
    
}
