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
 * TextManger class is in charge of converting all string into SuperTextBox Objects to display to the world
 * 
 * @author Vincent
 * <p>
 * Modified by: Dawson
 * </p>
 * 
 * @version November 2023
 */
public class TextManager extends Actor
{
    private int spacing;
    private ArrayList<SuperTextBox> text;
    
    // Custom imported font
    private File fontFile = new File("cheeseFont.tty");
    private Font pixelFont, pixelFont32;
    private FileInputStream in;
    private Font ourFont; 
    private greenfoot.Font pixel; 
    
    private int textBoxWidth; 
    private int borderThickness;
    private int initPlaceY;
    
    public TextManager() throws FontFormatException, IOException {
        text = new ArrayList<SuperTextBox>();
        setImage(new GreenfootImage("log.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        addFont(ourFont);
        
        
        textBoxWidth = 236; 
        borderThickness = 4;
        spacing = 10;
        
    }
    public greenfoot.Font addFont(Font theFont) {
        
        // Code to get Java to read the .ttf file that stores the Font
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
            return pixel;
        }
        // Error handling for reading fonts (makes sure the file exists during compile time)
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addedToWorld(World w){
        initPlaceY = getY()+getImage().getHeight()/2-50;
    }
    
    public void addSentence(String sentence){
        text.add(0,new SuperTextBox(splitSentence(sentence), Constants.DARK_BLUE, Constants.LIGHT_AQUA, pixel, false, textBoxWidth, borderThickness, Constants.AQUA));
        displayText();
    }
    
    // Algorithm to split words to next line if it crosses over the length of the textbox
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
            
            // Check if the next word will cross over the textbox
            if((curLength += SuperTextBox.getStringWidth(pixel,s)) > textBoxWidth){
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
    
    // Algorithm for displaying textboxes from newest to oldest (bottom to top), as well as making older textboxes transparent and fade away
    public void displayText(){
        if(getWorld().getObjects((SuperTextBox.class)) != null){
            getWorld().removeObjects(text);
        }
        int placeY = 0; // Variable for determining where the next textbox goes
        for(int i = 0; i < text.size(); i++){
            int textBoxHeight = text.get(i).getImage().getHeight();
            int opacity = 255-(int)(((double)(placeY)/(getImage().getHeight()-100))*255);
            if(opacity < 0) {
                text.remove(text.get(i));
                continue;
            }
            text.get(i).setOpacity(opacity);
            
            placeY += textBoxHeight/2;
            getWorld().addObject(text.get(i),getX(),initPlaceY-placeY);
            placeY += textBoxHeight/2+spacing;
        }
    }
    public greenfoot.Font getFont(){
        return pixel;
    }
    public void act()
    {
        // Add your action code here.
    }
}
