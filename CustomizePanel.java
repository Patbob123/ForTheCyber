import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    private ArrayList <Attack> moveset;
    
    public CustomizePanel(){
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        movesetPanelImg = new GreenfootImage("movesetpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        movesetPanelImg.scale(movesetPanelImg.getWidth()*Constants.IMAGE_SCALING, movesetPanelImg.getHeight()*Constants.IMAGE_SCALING);
        goToAugment();
        moveset = new ArrayList <>();

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
    public ArrayList<Attack> getMoveset(){
        return moveset;
    }
    public void addToMoveset(String move){
        switch(move){
            case "ShotGun": 
                moveset.add(new ShotGun());
                break;
            
            case "PlasmaBeam": 
                moveset.add(new PlasmaBeam());
                break;
            
            case "BodySlam": 
                moveset.add(new BodySlam());
                break;
            
            case "DeathRay": 
                moveset.add(new DeathRay());
                break;
                
            case "BoxJab": 
                moveset.add(new BoxJab());
                break;
                
            case "Pincer": 
                moveset.add(new Pincer());
                break;
        }
        
    }
    public AugmentFunction setMoveset = (move) -> addToMoveset(move);
}
