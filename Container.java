import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Draws out the box that contains the user's stats in BattleWorld
 * 
 * @author Jaiden
 * @version november, 2023
 */
public class Container extends Actor
{
    private GreenfootImage containerImage;
    private int curContained;
    private int spacing;
    private GreenfootImage image;
    
    public Container(GreenfootImage image, int maxContained, int spacing){
        image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        containerImage = new GreenfootImage((image.getWidth()+spacing)*maxContained, image.getHeight());
        curContained = 0;
        this.image = image;
        this.spacing = spacing;
        setImage(containerImage);
    }
    public void setContained(int contained){
        curContained = contained;
        refresh();
    }
    public int getContained(){
        return curContained;
    }
    public void refresh(){
        //containerImage.clear();
        for(int i = 0; i < curContained; i++){
            containerImage.drawImage(image, (image.getWidth()+spacing)*i, 0);
        }
    }
}
