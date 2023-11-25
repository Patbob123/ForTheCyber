import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Juggernaut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juggernaut extends Enemy
{
    public Juggernaut(){
        name = "Juggernaut";
        addMoveset(new BodySlam());
 
        entityImageUrl = "enemy/juggernaut.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/JuggernautPortrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
        
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new Juggernaut();
    }
}
