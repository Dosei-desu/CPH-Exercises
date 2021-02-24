import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAntiAlphabeticaliser {

    public static List<String> antiAlphabeticaliser(String word1, String word2, String word3, String word4, String word5){
        List<String> list = new ArrayList<>();
        list.add(word1);
        list.add(word2);
        list.add(word3);
        list.add(word4);
        list.add(word5);

        System.out.println("Original order:");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("\nDescending order:");
        list.sort(Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(""); //spacer
        return list;
    }

    List<String> testList = antiAlphabeticaliser("Happy","Sad","Jumpy","Skittery","Crazy");

    @Test
    public void testSortFirst(){
        assertEquals("Skittery", testList.get(0));
    }

    @Test
    public void testSortLast(){
        assertEquals("Crazy", testList.get(4));
    }

    @Test
    public void testSortMid(){
        assertEquals("Jumpy", testList.get(2));
    }
}
