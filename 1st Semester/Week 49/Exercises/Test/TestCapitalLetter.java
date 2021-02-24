import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCapitalLetter {
    //Capital Letter task

    public static int capitalLetter(List<String> list){
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if(list.get(i).charAt(0) == list.get(i).toUpperCase().charAt(0)){
                counter++;
            }
        }
        System.out.println(counter+" sentences started with a capital letter.\n");
        return counter;
    }

    @Test
    public void testA(){
        List<String> list = new ArrayList<>();
        list.add("Sentence one");
        list.add("Sentence two");
        list.add("sentence three");
        list.add("sentence four");
        list.add("Sentence five");

        assertEquals(3,capitalLetter(list));
    }

    @Test
    public void testB(){
        List<String> list = new ArrayList<>();
        list.add("sentence one");
        list.add("Sentence two");
        list.add("sentence three");
        list.add("sentence four");
        list.add("sentence five");

        assertEquals(1,capitalLetter(list));
    }

    @Test
    public void testC(){
        List<String> list = new ArrayList<>();
        list.add("Sentence one");
        list.add("Sentence two");
        list.add("Sentence three");
        list.add("Sentence four");
        list.add("Sentence five");

        assertEquals(5,capitalLetter(list));
    }
}
