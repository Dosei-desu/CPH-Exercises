import org.junit.Test;
import static org.junit.Assert.*;

public class TestGrassCutter {
    //Grass-cutter task

    public static int grassScanner(double currentGrassLength){
        if(currentGrassLength > 10){
            System.out.println("Your grass is too long! Get your lawnmower started!");
            return 1;
        }
        if(currentGrassLength <= 10 && currentGrassLength > 6.3){
            System.out.println("Grass will be ready for a trim in "+Math.round((10-currentGrassLength)/0.8)+" days.");
            return 2;
        }
        if(currentGrassLength == 6.3){
            System.out.println("According to the internet, your grass has the perfect length!");
            return 3;
        }
        if(currentGrassLength < 6.3 && currentGrassLength >= 0){
            System.out.println("Let your grass grow, it is too short!");
            return 4;
        }
        if(currentGrassLength < 0){
            System.out.println("Shutting down...");
            return -1;
        }
        return 0;
    }

    @Test
    public void testTooLong(){
        assertEquals(1,grassScanner(11.7));
    }

    @Test
    public void testNotPerfectButNotTooLong(){
        assertEquals(2,grassScanner(7.9));
    }

    @Test
    public void testPerfect(){
        assertEquals(3,grassScanner(6.3));
    }

    @Test
    public void testTooShort(){
        assertEquals(4,grassScanner(3.23));
    }

    @Test
    public void testShutDown(){
        assertEquals(-1,grassScanner(-1));
    }
}
