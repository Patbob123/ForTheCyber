import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;



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
    Font ourFont; 
    greenfoot.Font pixel; 
    
    int textBoxWidth; 
    
    public TextManager(ArrayList <SuperTextBox> text) throws FontFormatException, IOException {
        spacing = 60;
        
        this.text = text;
        setImage(new GreenfootImage("log.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        addFont(ourFont);
        
        textBoxWidth = 236; 
        
    }
    public void addFont(Font theFont) {
        try {
            //Read the .ttf file containing the font
            fontFile = new File("cheeseFont.ttf");
            in = new FileInputStream(fontFile);

            // Convert the .ttf file into a Java.awt.font
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, in);
            pixelFont32 = pixelFont.deriveFont(14f); // Resize font (Change to lower size later)
            java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pixelFont32);

            // Create a greenfoot font using the newly created java.awt.font  
            pixel = new greenfoot.Font(pixelFont32.getName(), pixelFont32.getStyle() % 2 == 1, pixelFont32.getStyle() / 2 == 1, pixelFont32.getSize());
            in.close();
        }
        // Error handling for reading fonts (makes sure the file exists during compile time)
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }
    public void addSentence(String sentence){
        //splitSentence(sentence);
        //new SuperTextBox(splitSentence(sentence),pixel,1,false);
        text.add(0,new SuperTextBox(sentence,pixel, textBoxWidth));
        displayText();
    }
    public String[] splitSentence (String sentence){
        double ratio;
        int stringWidth= SuperTextBox.getStringWidth(pixel,sentence);
        String[] words = sentence.split("");
        int curLength = 0;
        String curString = "";
        String[] multiLine;
        for(String s: words){
            ratio = stringWidth%textBoxWidth;
            if(ratio <= 0){
                //return words;
            }
            if((curLength += SuperTextBox.getStringWidth(pixel,s)) > stringWidth){
                //multiLine += curString;
                curString = "";
                stringWidth -= curLength;
                curLength = 0;
            }
            else{
                curLength += SuperTextBox.getStringWidth(pixel,s);
                curString += s +" "; 
            }
        }
        return words;
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
