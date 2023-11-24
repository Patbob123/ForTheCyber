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
    private String sentence;
    private Color bgColour = Constants.DARK_BLUE;
    private Color textColour = Constants.LIGHT_AQUA;
    private Color borderColour = Constants.AQUA;
    
    public TextPlace(String sentence, int x, int y, int textBoxWidth) throws FontFormatException, IOException {
        this.x = x;
        this.y = y;
        
        pixel = addFont(ourFont);
        
        this.textBoxWidth = textBoxWidth; 
        borderThickness = 4;
        sentence = "NPEIDK";
        
        text = new SuperTextBox(splitSentence(sentence), bgColour, textColour, pixel, false, textBoxWidth, borderThickness, borderColour);
        setImage(new GreenfootImage(1,1));
    }
    public void setSentence(String sentence){
        this.sentence = sentence;  
        refresh();
    }
    public void setColour(Color bgCol, Color textCol, Color borderCol){
        bgColour = bgCol;
        textColour = textCol;
        borderColour = borderCol;
        refresh();
    }
    public void refresh(){
        getWorld().removeObject(text);
        text = new SuperTextBox(splitSentence(sentence), bgColour, textColour, pixel, false, textBoxWidth, borderThickness, borderColour);
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
        return multiLine;
    }
}
