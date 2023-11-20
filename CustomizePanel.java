import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class AugmentPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomizePanel extends Actor
{
    //private TextPlace augmentName;
    //private TextPlace augmentDesc;
    private GreenfootImage augmentPanelImg;
    private GreenfootImage movesetPanelImg;
    private boolean onAugment;
    private ArrayList <Attack> moveset;
    private ArrayList <Attack> totalMoveset;
    
    private TextPlace nameDisplay;
    private TextPlace descDisplay;
    
    public CustomizePanel(){
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        movesetPanelImg = new GreenfootImage("movesetpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        movesetPanelImg.scale(movesetPanelImg.getWidth()*Constants.IMAGE_SCALING, movesetPanelImg.getHeight()*Constants.IMAGE_SCALING);
        moveset = new ArrayList<>();
        totalMoveset = new ArrayList<>();
        totalMoveset.add(new ShotGun());
        totalMoveset.add(new PlasmaBeam()); 
        totalMoveset.add(new BodySlam());
        totalMoveset.add(new DeathRay());
        totalMoveset.add(new BoxJab());
        totalMoveset.add(new Pincer());
        
        setImage(augmentPanelImg);
        
        //addObject
    }
    public void addedToWorld(World w){
        nameDisplay = initTextDisplay("Select Augment", getX(), getY());
        descDisplay = initTextDisplay("Select Augment", getX(), getY()+50);
        
        getWorld().addObject(nameDisplay, getX(), getY());
        getWorld().addObject(descDisplay, getX(), getY());
    }
    public void goToAugment(){
        onAugment = true;
        augmentPanelImg = new GreenfootImage("augmentpanel.png");
        augmentPanelImg.scale(augmentPanelImg.getWidth()*Constants.IMAGE_SCALING, augmentPanelImg.getHeight()*Constants.IMAGE_SCALING);
        Augment curAugment = ((BuilderWorld)getWorld()).getUserChar().getAugment();
        if(curAugment != null){
            augmentPanelImg.drawImage(curAugment.getPortrait(), 36*Constants.IMAGE_SCALING, 32*Constants.IMAGE_SCALING);
            nameDisplay.setSentence(curAugment.getName());
            descDisplay.setSentence(curAugment.getDesc());
        }
        setImage(augmentPanelImg);
        
       
    }
    public void goToMoveset(){
        onAugment = false;
        nameDisplay.removeSentence();
        descDisplay.removeSentence();
        for(int i = 0 ; i < totalMoveset.size(); i++){
            Presser move = new Presser(setMoveset, "augmentbutton.png", "augmentbutton.png", totalMoveset.get(i).getName());
            getWorld().addObject(move, getX()-getImage().getWidth()/4, getY() - getImage().getHeight()/3 + i * 75);
            TextPlace attackDesc = initTextDisplay("Select Augment", getX(), getY() - getImage().getHeight()/3 + i * 75);
            attackDesc.setSentence(totalMoveset.get(i).getName());
        }
            
        setImage(movesetPanelImg);
    }
    public TextPlace initTextDisplay(String text, int x, int y){
        try{
            TextPlace textDisplay = new TextPlace(text, x, y);
            return textDisplay;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        return null;
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
