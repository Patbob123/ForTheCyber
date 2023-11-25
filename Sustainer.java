import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sustain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sustainer extends Enemy
{
    public Sustainer(){
        name = "Sustainer";
        addMoveset(new Heal());
        
        entityImageUrl = "enemy/sustainer.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/SustainerPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new Sustainer();
    }
}
