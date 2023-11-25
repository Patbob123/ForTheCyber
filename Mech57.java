import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mech57 is a difficult enemy that uses PlasmaBeam
 * 
 * @author Jaiden
 * <p>
 * Modified by: Dawson
 * </p>
 * @version November 2023
 */
public class Mech57 extends Enemy
{
    public Mech57(){
        name = "Mech57";
        addMoveset(new PlasmaBeam());
        
        entityImageUrl = "enemy/mech57.png";
        entityImage = createDuplicateImage();
        
        portraitImage = new GreenfootImage("enemy/Mech57Portrait.png");
        portraitImage.scale(portraitImage.getWidth()*Constants.PORTRAIT_SCALING, portraitImage.getHeight()*Constants.PORTRAIT_SCALING);
    
        setImage(entityImage);
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public Enemy cloneEnemy(){
        return new Mech57();
    }
}
