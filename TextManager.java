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
public class TextManager extends Actor
{
    private int spacing;
    private ArrayList<SuperTextBox> text;
    //private Font funFont = new Font ("Comic Sans MS", false, false, 16);
    private File fontFile = new File("cheeseFont.tty");
    private Font pixelFont, pixelFont32;
    private FileInputStream in;
    private Font ourFont; 
    private greenfoot.Font pixel; 
    
    private int textBoxWidth; 
    private int borderThickness;
    
    public TextManager(ArrayList <SuperTextBox> text) throws FontFormatException, IOException {
        this.text = text;
        setImage(new GreenfootImage("log.png"));
        getImage().scale(getImage().getWidth()*Constants.IMAGE_SCALING, getImage().getHeight()*Constants.IMAGE_SCALING);
        addFont(ourFont);
        
        textBoxWidth = 236; 
        borderThickness = 4;
        spacing = 10;
        
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
        text.add(0,new SuperTextBox(splitSentence(sentence), Constants.DARK_BLUE, Constants.LIGHT_AQUA, pixel, false, textBoxWidth, borderThickness, Constants.AQUA));
        displayText();
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
            if((curLength += SuperTextBox.getStringWidth(pixel,s)) > textBoxWidth){
                
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
    public void displayText(){
        if(getWorld().getObjects((SuperTextBox.class)) != null){
            getWorld().removeObjects(text);
        }
            
        for(int i = text.size()-1; i>=0; i--){
            int textBoxHeight = text.get(i).getImage().getHeight();
            int opacity = 255-((textBoxHeight+spacing)*(i))/2;
            if(opacity < 0) {
                text.remove(text.get(i));
                continue;
            }
            text.get(i).setOpacity(opacity);
            
            getWorld().addObject(text.get(i),getX(),getY()+getImage().getHeight()/2-((textBoxHeight+spacing)*(i)+80));
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
