import org.junit.Test;
import static org.junit.Assert.*;

public class TestStringsMethod {
    //Strings task

    public static String stringsMethod(String a, String b, char c, char d){
        if(!a.equals("") && !b.equals("") && c != '\0' && d != '\0') { // '\0' is the char equivalent of "null"
            String newWord = a + b; //combines strings
            System.out.println("Input: \""+a+"\" + \""+b+"\" (replace '"+c+ "' with '" +d+"')");
            System.out.println("Combined word: "+newWord);

            char[] newWordArray = new char[newWord.length()]; //makes a char array the length of the combined word above

            for (int i = 0; i < newWordArray.length; i++) {
                if(newWord.charAt(i) == c){
                    newWordArray[i] = d;
                }else {
                    newWordArray[i] = newWord.charAt(i);
                }
            }

            newWord = ""; //wipes word

            for (char value : newWordArray) {
                newWord += value;
            }
            System.out.println("Result: "+newWord);
            return newWord;
        }
        else{
            System.out.println("Input Mismatch Exception error!");
            return "";
        }
    }

    @Test
    public void testA(){
        assertEquals("H3lloFac3",stringsMethod("Hello","Face",'e','3'));
    }

    @Test
    public void testB(){
        assertEquals("He11oFace",stringsMethod("Hello","Face",'l','1'));
    }

    @Test
    public void testC(){
        assertEquals("helloFace",stringsMethod("Hello","Face",'H','h'));
    }

    @Test
    public void testFailureState(){
        assertEquals("",stringsMethod("Hello","",'H','h'));
    }
}
