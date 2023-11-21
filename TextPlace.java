import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;



/**
 * Write a description of class TextManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextPlace extends TextManager
{
    private SuperTextBox text;
    //private Font funFont = new Font ("Comic Sans MS", false, false, 16);
    private File fontFile = new File("cheeseFont.tty");
    private Font pixelFont, pixelFont32;
    private FileInputStream in;
    private Font ourFont; 
    private greenfoot.Font pixel; 
    
    private int x;
    private int y;
    private int textBoxWidth; 
    private int borderThickness;
    public TextPlace(String sentence, int x, int y, int textBoxWidth) throws FontFormatException, IOException {
        this.x = x;
        this.y = y;
        
        pixel = addFont(ourFont);
        
        this.textBoxWidth = textBoxWidth; 
        borderThickness = 4;
        
        text = new SuperTextBox(splitSentence(sentence), Constants.DARK_BLUE, Constants.LIGHT_AQUA, pixel, false, textBoxWidth, borderThickness, Constants.AQUA);
        setImage(new GreenfootImage(1,1));
    }
    public void setSentence(String sentence){
        getWorld().removeObject(text);
        text = new SuperTextBox(splitSentence(sentence), Constants.DARK_BLUE, Constants.LIGHT_AQUA, pixel, false, textBoxWidth, borderThickness, Constants.AQUA);
        getWorld().addObject(text,x,y+text.getImage().getHeight()/2);
    }
    public void removeSentence(){
        getWorld().removeObject(text);
    }
    public String[] splitSentence (String sentence){
        int stringWidth= SuperTextBox.getStringWidth(pixel,sentence);
        String[] words = sentence.split(" ");
        int curLength = 0;
        String curString = "";
        String multiLineString = "";
        String[] multiLine;
        for(String s: words){
            //ratio = stringWidth/textBoxWidth;
            //if(ratio <= 0){
            //    multiLineString += curString;
            //    multiLine = multiLineString.split("`");
            //    return multiLine;
            //}
            //System.out.println(s);
            if(s.equals("/n")){
                multiLineString += curString +"`";
                curString = "";
                curLength = 0;
                continue;
            }
            if(curLength + SuperTextBox.getStringWidth(pixel,s)  > textBoxWidth - borderThickness * 3){
                
                multiLineString += curString +"`";
                curString = s+" ";
                //stringWidth -= curLength;
                curLength = SuperTextBox.getStringWidth(pixel,s);
            }
            else{
                curLength += SuperTextBox.getStringWidth(pixel,s);
                curString += s +" "; 
            }
        }
        multiLineString += curString;
        multiLine = multiLineString.split("`");
        //System.out.println(Arrays.toString(multiLine));
        return multiLine;
    }
}
