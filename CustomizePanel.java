import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AugmentPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomizePanel extends Actor
{
    private Label augmentName;
    private Label augmentDesc;
    private GreenfootImage augmentPanelImg;
    private GreenfootImage movesetPanelImg;
    private boolean onAugment;
    
    
    public CustomizePanel(){
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        movesetPanelImg = new GreenfootImage("movesetpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        movesetPanelImg.scale(movesetPanelImg.getWidth()*Constants.IMAGE_SCALING, movesetPanelImg.getHeight()*Constants.IMAGE_SCALING);
        goToAugment();
        //addObject
    }
    public void goToAugment(){
        onAugment = true;
        setImage(augmentPanelImg);
    }
    public void goToMoveset(){
        onAugment = false;
        setImage(movesetPanelImg);
    }
    public void refresh(String text){
       //Label         
       
    }
}
