import com.sun.xml.internal.ws.util.StringUtils;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestProperCase {
    //Proper case task

    public static String properCaseMethod(String sentence){
        if(sentence != null){
            System.out.println("\nOriginal: \""+sentence+"\"");

            String newSentence = "";
            String[] sentenceBreakdown = sentence.split(" ");

            for (int i = 0; i < sentenceBreakdown.length; i++) {

                if(sentenceBreakdown[i].equals(sentenceBreakdown[i].toUpperCase())){
                    newSentence += sentenceBreakdown[i];
                }
                else if(sentenceBreakdown[i].length() <= 3){
                    newSentence += sentenceBreakdown[i].toLowerCase();
                }
                else{
                    newSentence += StringUtils.capitalize(sentenceBreakdown[i].toLowerCase());
                }

                if(i < sentenceBreakdown.length-1){
                    newSentence += " ";
                }
            }
            return newSentence;

        }else{
            return "\nNULL NOT ACCEPTED!";
        }
    }

    @Test
    public void testSentenceA(){
        assertEquals("Hello This IS A Test ICKLES", properCaseMethod("heLLO this IS A tEST ICKLES"));
    }

    @Test
    public void testSentenceB(){
        assertEquals("TEST te tes Test Test", properCaseMethod("TEST te tes test TesT"));
    }

    @Test
    public void testNullSentence(){ //even the "\n" has to be included
        assertEquals("\nNULL NOT ACCEPTED!", properCaseMethod(null));
    }
}
