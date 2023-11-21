import greenfoot.*;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends Enemy
{
    // instance variables - replace the example below with your own
    public Cube()
    {
        entityImage = new GreenfootImage("enemy/gunner.png");
        entityImage.scale(entityImage.getWidth()*Constants.IMAGE_SCALING, entityImage.getHeight()*Constants.IMAGE_SCALING);
        
        portraitImage = new GreenfootImage("enemy/GunnerPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        name = "Cube"+String.valueOf(Greenfoot.getRandomNumber(500));
        attack = 5;
        speed = 3;
        hp = 100;
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }

    public GreenfootImage getPortrait(){
        return portraitImage;
    }
}
