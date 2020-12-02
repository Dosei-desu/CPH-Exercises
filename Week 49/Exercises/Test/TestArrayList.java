import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;
import org.junit.Test;

/*
Haven't used Unit-testing before, so I'm following a tutorial I found online in a forum:
https://stackoverflow.com/questions/8751553/how-to-write-a-unit-test
*/

public class TestArrayList {
    //Array task tests :

    ArrayList<String> stringList = new ArrayList<>();

    public static boolean stringArrayMethod(ArrayList<String> arrayList, String string){
        if(!arrayList.contains(string) && string != null){ //checks that it isn't null
            arrayList.add(string); //if string isn't within the arrayList, adds string and returns "true"
            Collections.sort(arrayList);//sorts the array
            return true;
        }
        Collections.sort(arrayList);//sorts the array
        return false;
    }

    @Test
    public void testCorrectInput(){
        stringArrayMethod(stringList,"Bob");
        assertEquals(stringList.get(stringList.size()-1),"Bob");
    }

    @Test
    public void testAnotherCorrectInput(){
        stringArrayMethod(stringList,"John");
        assertEquals(stringList.get(stringList.size()-1),"John");
    }

    @Test
    public void testDuplicateInput(){
        stringArrayMethod(stringList,"Bob");
        assertFalse(stringArrayMethod(stringList,"Bob"));
    }

    @Test
    public void testNullInput(){
        stringArrayMethod(stringList,null);
        assertFalse(stringArrayMethod(stringList,null));
    }
}
