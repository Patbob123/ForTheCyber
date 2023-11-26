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
 * Add customizability to TextManager
 * 
 * @author Dawson
 * @version November 2023
 */
public class TextPlace extends TextManager
{
    private SuperTextBox text;
    private File fontFile = new File("cheeseFont.tty");
    private Font pixelFont, pixelFont32;
    private FileInputStream in;
    private Font ourFont; 
    private greenfoot.Font pixel; 
    
    private int x;
    private int y;
    private int textBoxWidth; 
    private int borderThickness;
    private boolean centered;
    private String sentence;
    private Color bgColour = Constants.DARK_BLUE;
    private Color textColour = Constants.LIGHT_AQUA;
    private Color borderColour = Constants.AQUA;
    
    public TextPlace(String sentence, int x, int y, int textBoxWidth, boolean centered) throws FontFormatException, IOException {
        this.x = x;
        this.y = y;
        
        pixel = addFont(ourFont);
        
        this.textBoxWidth = textBoxWidth;
        this.centered = centered;
        
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
        text = new SuperTextBox(splitSentence(sentence), bgColour, textColour, pixel, centered, textBoxWidth, borderThickness, borderColour);
        getWorld().addObject(text,x,y+text.getImage().getHeight()/2);
    }
    public void multiplyScale(int scale){
        text.getImage().scale(text.getImage().getWidth()*scale, text.getImage().getHeight()*scale);
    }
    public void removeSentence(){
        getWorld().removeObject(text);
    }
    public SuperTextBox getText(){
        return text;
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
            if(curLength + SuperTextBox.getStringWidth(pixel,s)  > textBoxWidth - (borderThickness * 5)){
                
                multiLineString += curString +"`";
                curString = s+" ";
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
    public static TextPlace initTextDisplay(String text, int x, int y, int textBoxWidth, boolean centered){
        try{
            TextPlace textDisplay = new TextPlace(text, x, y, textBoxWidth, centered);
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
    public static TextPlace initTextDisplay(String text, int x, int y){
        return initTextDisplay(text, x, y, 236, false);
    }
    public static TextPlace initTextDisplay(String text, int x, int y, int textBoxWidth){
        return initTextDisplay(text, x, y, textBoxWidth, false);
    }
    public static TextPlace initTextDisplay(String text, int x, int y, boolean centered){
        return initTextDisplay(text, x, y, 236, centered);
    }
}
