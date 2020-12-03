import org.junit.Test;
import static org.junit.Assert.*;

public class TestQuadrant {
    //Quadrant task

    public static boolean quadrantMethod(int number, String sign){
        if(number < 0 || number > 40){
            System.out.println("Cannot print to screen!");
            return false;
        } else {
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if(sign.equals("") || sign.equals(" ")) {
                        System.out.print("*");
                    }else {
                        System.out.print(sign);
                    }
                    if (j < number - 1) {
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
            return true;
        }
    }

    @Test
    public void testSixBySix(){
        assertTrue(quadrantMethod(6, ""));
    }

    @Test
    public void testElevenByEleven(){
        assertTrue(quadrantMethod(11, "#"));
    }

    @Test
    public void testTooBig(){
        assertFalse(quadrantMethod(66,"%"));
    }

    @Test
    public void testNegative(){
        assertFalse(quadrantMethod(-6,"6"));
    }
}
