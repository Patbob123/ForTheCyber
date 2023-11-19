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
        augmentList = new String[]{
            "Robot Arm",
            "Robot Leg",
            "Stealth Cloak",
            "Kevlar Vest",
            "Syringe",
            "Shield",
            "Long Arm",
            "Taser"
        };
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
    public static void applyAugment(String augment, UserChar uc){
        switch(augment){
            case "Robot Arm":
                uc.setHp(100);
                break;
            case "Robot Leg":
                uc.setHp(100);
                break;
            case "Stealth Cloak":
                uc.setHp(100);
                break;
            case "Kevlar Vest":
                uc.setHp(100);
                break;
            case "Syringe":
                uc.setHp(100);
                break;
            case "Shield":
                uc.setAttack(360);
                break;
            case "Long Arm":
                uc.setAttack(360);
                break;
            case "Taser":
                uc.setAttack(360);
                break;
            default:
                System.out.println("ur broke");
        }
    }
}
