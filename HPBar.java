import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPBar extends Actor
{
    private GreenfootImage hpImage;
    private int maxHpWidth;
    private UserChar uc;
    
    public HPBar(UserChar uc){
        hpImage = new GreenfootImage(80, 2);
        hpImage.scale(hpImage.getWidth()*Constants.IMAGE_SCALING, hpImage.getHeight()*Constants.IMAGE_SCALING);
        maxHpWidth = hpImage.getWidth();
        
        hpImage.setColor(new Color(249, 126, 211));
        hpImage.fill();
        setImage(hpImage);
        
        this.uc = uc;
        
    }
    public void refresh(){
        getImage().scale((int)(maxHpWidth*(uc.getHp()/uc.getMaxHp())) ,getImage().getHeight());
        setLocation(180+getImage().getWidth()/2, 735);
    }
}
