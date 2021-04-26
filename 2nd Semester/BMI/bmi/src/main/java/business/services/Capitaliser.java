package business.services;

//because lowercase is upsetting...

public class Capitaliser {

    public static String capitalise(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }
}
