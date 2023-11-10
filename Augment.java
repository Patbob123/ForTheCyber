/**
 * Write a description of class Augment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Augment  
{
    // instance variables - replace the example below with your own
    private String[] augmentList;
    public Augment()
    {
        augmentList = new String[]{"Mech Arm", "360 No Scope"};
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String[] getAugmentList(){
        return this.augmentList;
    }
    public void applyAugment(String augment){
        switch(augment){
            case "Mech Arm":
                //setAttack = asdasodma
                break;
            case "360 No Scope":
                //setAttack = 360
                break;
            default:
                System.out.println("ur broke");
        }
    }
}
