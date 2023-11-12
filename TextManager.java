import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



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
    //private Font funFont = new Font ("Comic Sans MS", false, false, 16);
    File fontFile = new File("cheeseFont.tty");
    Font pixelFont, pixelFont32;
    FileInputStream in;
    
    public TextManager(ArrayList <SuperTextBox> text){
        spacing = 60;
        
        this.text = text;
        setImage(new GreenfootImage("log.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        addFont();
        
    }
    //public void addFont() throws java.io.IOException, java.awt.FontFormatException, java.io.FileNotFoundException {
    public void addFont() {
        try{
            in = new FileInputStream(fontFile);
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, in);
            pixelFont32 = pixelFont.deriveFont(32f); 
            java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pixelFont32);
            greenfoot.Font pp = new greenfoot.Font(pixelFont32.getName(), pixelFont32.getStyle() % 2 == 1, pixelFont32.getStyle() / 2 == 1, pixelFont32.getSize());
            in.close();
        }
        
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (FontFormatException e){
            e.printStackTrace();
        }
    }
    public void addSentence(String sentence){
        //text.add(0,new SuperTextBox(sentence,funFont, 236));
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
