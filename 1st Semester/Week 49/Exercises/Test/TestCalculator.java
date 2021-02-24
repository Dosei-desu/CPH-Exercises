import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculator {
    //Calculator task

    public static boolean calculator(double num1, double num2){
        if(num1 <= 50 && num1 >= 1 && num2 <= 50 && num2 >= 1){
            System.out.println(num1 +" + "+ num2 +" = "+ (num1 + num2));
            System.out.println(num1 +" - "+ num2 +" = "+ (num1 - num2));
            //not sure why this below results in this format xx,xx rather than xx.xx
            System.out.println(num1 +" / "+ num2 +" = "+ String.format("%.2f", num1 / num2));
            System.out.println(num1 +" * "+ num2 +" = "+ (num1 * num2));
            return true;
        }else{
            System.out.println("Input Mismatch Exception error!");
            return false;
        }
    }

    @Test
    public void testCalculatorA(){
        assertTrue(calculator(15,29));
    }

    @Test
    public void testCalculatorB(){
        assertTrue(calculator(1.11,49.99));
    }

    @Test
    public void testCalculatorInputMismatchException(){
        assertFalse(calculator(0.99,50.01));
    }
}
