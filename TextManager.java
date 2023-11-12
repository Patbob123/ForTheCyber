import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
/**
 * Write a description of class TextManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextManager extends Actor
{
    private int spacing;
    private ArrayList<SuperTextBox> text;
    private Font funFont = new Font ("Comic Sans MS", false, false, 16);
    public TextManager(ArrayList <SuperTextBox> text){
        spacing = 60;
        
        this.text = text;
        setImage(new GreenfootImage("log.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        
    }
    public void addSentence(String sentence){
        text.add(0,new SuperTextBox(sentence,  funFont, 236));
        displayText();
    }
    public void displayText(){
        if(getWorld().getObjects((SuperTextBox.class)) != null){
            getWorld().removeObjects(getWorld().getObjects(SuperTextBox.class));
        }
         
        for(int i = text.size()-1; i>=0; i--){
           
            int opacity = 255-(i*spacing/2);
            if(opacity < 0) {
                text.remove(text.get(i));
                continue;
            }
            text.get(i).setOpacity(opacity);
            getWorld().addObject(text.get(i),getImage().getWidth()/2,getImage().getHeight()-(spacing*(i+1)+10));
        }
    }
    public void act()
    {
        // Add your action code here.
    }
}
