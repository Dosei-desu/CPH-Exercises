import org.junit.Test;
import static org.junit.Assert.*;

public class TestQuadrant {
    //Quadrant task

    public static boolean quadrantMethod(int number){
        if(number < 0 || number > 40){
            System.out.println("Cannot print to screen!");
            return false;
        } else {
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    System.out.print("*");
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
        assertTrue(quadrantMethod(6));
    }

    @Test
    public void testElevenByEleven(){
        assertTrue(quadrantMethod(11));
    }

    @Test
    public void testTooBig(){
        assertFalse(quadrantMethod(66));
    }

    @Test
    public void testNegative(){
        assertFalse(quadrantMethod(-6));
    }
}
