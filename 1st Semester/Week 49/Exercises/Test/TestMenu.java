import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class TestMenu {
    //Menu task

    public static int menu(int number){
        System.out.println("Select an option from the menu:\n1.  Calculate\n2.  Print\n3.  Help");

        switch (number) {
            case 1:
                System.out.println("You selected 'Calculate'...");
                return 1;

            case 2:
                System.out.println("You selected 'Print'...");
                return 2;

            case 3:
                System.out.println("You selected 'Help'...");
                return 3;

            default:
                System.out.println(number + ". is not an available option");
                return 0;
        }
    }

    @Test
    public void testSelectionOne(){
        assertEquals(1,menu(1));
    }

    @Test
    public void testSelectionTwo(){
        assertEquals(2,menu(2));
    }

    @Test
    public void testSelectionThree(){
        assertEquals(3,menu(3));
    }

    @Test
    public void testSelectionUnavailableA(){
        assertEquals(0,menu(5));
    }

    @Test
    public void testSelectionUnavailableB(){
        assertEquals(0,menu(-1));
    }

}
