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
    
    /**
     * Constructor for TextPlace
     * 
     * @param sentence        Initial sentence
     * @param x               Initial x
     * @param y               Initial y
     * @param textBoxWidth    Width of the textbox
     * @param centered        If text is centered
     */
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
    
    /**
     * Set textbox of textplace
     * 
     * @param sentence            String that is to be added to the textplace
     */
    public void setSentence(String sentence){
        this.sentence = sentence;  
        refresh();
    }
    
    /**
     * Changes color of textplace
     * 
     * @param bgCol              Color of background
     * @param textCol            Color of text
     * @param borderCol          Color of border
     */
    public void setColour(Color bgCol, Color textCol, Color borderCol){
        bgColour = bgCol;
        textColour = textCol;
        borderColour = borderCol;
        refresh();
    }
    
    /**
     * Removes old SuperTextBox, and replaces with a new updated one
     */
    public void refresh(){
        getWorld().removeObject(text);
        text = new SuperTextBox(splitSentence(sentence), bgColour, textColour, pixel, centered, textBoxWidth, borderThickness, borderColour);
        getWorld().addObject(text,x,y+text.getImage().getHeight()/2);
    }
    
    /**
     * Makes the textbox bigger
     */
    public void multiplyScale(int scale){
        text.getImage().scale(text.getImage().getWidth()*scale, text.getImage().getHeight()*scale);
    }
    
    /**
     * Removes the textbox
     */
    public void removeSentence(){
        getWorld().removeObject(text);
    }
    
    /**
     * Getter for the textBox
     * 
     * @return text     The SuperTextBox of this textplace
     */
    public SuperTextBox getText(){
        return text;
    }
    
    /**
     * Algorithm to split words to next line if it crosses over the length of the textbox
     * 
     * @param sentence            String that is to be added to the log
     * @return multiLine          Array of string to be added to a multiline text box
     */
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
    
    /**
     * An easy way initialize this textplace
     * 
     * @param text                String that is to be added to the textplace
     * @param x                   Initial x
     * @param y                   Initial y
     * @param textBoxWidth        Width of the textbox in pixels
     * @param centered            If text will be centered or not
     * @return textDisplay        Array of string to be added to a multiline text box
     */
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
    
    /**
     * An easy way initialize this textplace, without filling in everything
     * 
     * @param text                String that is to be added to the textplace
     * @param x                   Initial x
     * @param y                   Initial y
     * @return textDisplay        Array of string to be added to a multiline text box
     */
    public static TextPlace initTextDisplay(String text, int x, int y){
        return initTextDisplay(text, x, y, 236, false);
    }
    
    /**
     * An easy way initialize this textplace, without filling in everything
     * 
     * @param text                String that is to be added to the textplace
     * @param x                   Initial x
     * @param y                   Initial y
     * @param textBoxWidth        Width of the textbox in pixels
     * @return textDisplay        Array of string to be added to a multiline text box
     */
    public static TextPlace initTextDisplay(String text, int x, int y, int textBoxWidth){
        return initTextDisplay(text, x, y, textBoxWidth, false);
    }
    
    /**
     * An easy way initialize this textplace, without filling in everything
     * 
     * @param text                String that is to be added to the textplace
     * @param x                   Initial x
     * @param y                   Initial y
     * @param centered            If text will be centered or not
     * @return textDisplay        Array of string to be added to a multiline text box
     */
    public static TextPlace initTextDisplay(String text, int x, int y, boolean centered){
        return initTextDisplay(text, x, y, 236, centered);
    }
}
