import org.junit.Test;
import static org.junit.Assert.*;

public class TestSearchingMethod {
    //Searching task

    public static int searchingMethod(String[] list, String s){
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(s)){
                return i;
            }
        }
        return -1;
    }

    String[] list = {"John","Bob","Amanda","Sven","Nathan"};

    @Test
    public void testA(){
        assertEquals(2,searchingMethod(list, "Amanda"));
    }

    @Test
    public void testB(){
        assertEquals(3,searchingMethod(list, "Sven"));
    }

    @Test
    public void testC(){
        assertEquals(0,searchingMethod(list, "John"));
    }

    @Test
    public void testFailedSearch(){
        assertEquals(-1,searchingMethod(list, "Hannah"));
    }
}
