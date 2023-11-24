import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @Rex (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String attributeType; 
    private GreenfootImage buttonImage;
    private int Value = 0;
    
    public Button(String type) {
        attributeType = type;
        GreenfootImage buttonImage = new GreenfootImage(40, 40);
        buttonImage.setColor(Color.RED);
        buttonImage.fill();
        setImage(buttonImage);
    }
    
    public Button(String type, int width, int height) {
        attributeType = type;
        buttonImage = new GreenfootImage(width, height);
        buttonImage.setColor(Color.YELLOW);
        buttonImage.fill();
        setImage(buttonImage);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            UserChar user = ((BuilderWorld)getWorld()).getUserChar();
            if (attributeType.equals("life")) {
                user.setHp(user.getHp() + 1);
            } else if (attributeType.equals("speed")) {
                user.setSpeed(user.getSpeed() + 1);
            } else if (attributeType.equals("strength")) {
                user.setAttack(user.getAttack() + 1);
            } else if (attributeType.equals("defense")) {
                user.setDef(user.getDef() + 1);
            } else if (attributeType.equals("Robotic arm")) {
                if (Value == 0) {
                    Value = 1;
                    user.setAttack(user.getAttack() + 5);
                    user.setDef(user.getDef() + 2);
                } else {
                    user.setAttack(user.getAttack() - 5);
                    user.setDef(user.getDef() - 2);
                    Value = 0;
                }

            }
        }
    }
}