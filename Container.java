import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HELPER CLASS: Draws out the box that contains the user's stats in BattleWorld
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
    
    /**
     * Constructor for Container
     * 
     * @param image                        An image for the container
     * @param maxContained                 How much the stat containers can go up to
     * @param spacing                      Spaces out the containers 
     */
    public Container(GreenfootImage image, int maxContained, int spacing){
        image.scale(image.getWidth()*Constants.IMAGE_SCALING, image.getHeight()*Constants.IMAGE_SCALING);
        containerImage = new GreenfootImage((image.getWidth()+spacing)*maxContained, image.getHeight());
        curContained = 0;
        this.image = image;
        this.spacing = spacing;
        setImage(containerImage);
    }
    
    /**
     * Method to set contained and refreshes the image
     */
    public void setContained(int contained){
        curContained = contained;
        refresh();
    }
    
    /**
     * Gets contained
     * 
     * @return Current contained
     */
    public int getContained(){
        return curContained;
    }
    
    /**
     * Method to refresh the image
     */
    public void refresh(){
        for(int i = 0; i < curContained; i++){
            containerImage.drawImage(image, (image.getWidth()+spacing)*i, 0);
        }
    }
}
