/**
 * @Author Kristoffer Pauly (Hold C) DAT2020
 */

import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//------Arraylist task
        System.out.println("---Arraylist task---\n");
        ArrayList<String> stringList = new ArrayList<>();

        System.out.println("First string: "+stringArrayMethod(stringList,"Bob"));
        System.out.println("Repeat string (should return false): "+stringArrayMethod(stringList,"Bob"));
        System.out.println("New string: "+stringArrayMethod(stringList,"John"));
        System.out.println("Another new string: "+stringArrayMethod(stringList,"Zebra"));
        System.out.println("Another new string: "+stringArrayMethod(stringList,"Aaron"));
        System.out.println("Repeat string (should return false): "+stringArrayMethod(stringList,"Zebra"));
        System.out.println("Adding null value (should return false): "+stringArrayMethod(stringList,null));
        //view sorted array:
        System.out.println("\nString list in alphabetical order:");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }

//------Library task
        System.out.println("\n---Library task---\n");
        Library library = new Library();

        Book book1 = new Book("978-1-909227-85-9","The Dagger of Shadows",2016);
        library.addBook(book1);
        library.addBook("978-1-84970-872-2","Xenos",2001);
        System.out.println("True search: "+library.searchByISBN("978-1-84970-872-2"));
        System.out.println("False search: "+library.searchByISBN("978-1-85552-92-2"));
        //view library
        System.out.println("\nView library:\n");
        library.viewBooks();

//------Grass-cutting task
        System.out.println("\n---Grass-cutting task---\n");
        grassScanner();

//------Quadrant task
        System.out.println("\n---Quadrant task---\n");
        quadrantMethod();

//------Menu task
        System.out.println("\n---Menu task---\n");
        menu();

//------Proper case task
        System.out.println("\n---Proper case task---\n");
        System.out.println(properCaseMethod("i AM an aDUlt NAmEd Kris"));
        System.out.println("\nNull input: "+properCaseMethod(null));
        System.out.println("Test: "+properCaseMethod("tEsT te TEST icklES ickles TEsT"));

//------Calculator task
        System.out.println("\n---Calculator task---\n");
        calculator(15,29);
        //not including an error throw example, since the exception throw stops the program and I'm doing everything in
        //sequence (but an error throw example is in the test version)

//------Sorting task
        System.out.println("\n---Sorting task---\n");
        antiAlphabeticaliser();

//------Capital Letter task
        System.out.println("\n---Capital Letter task---\n");
        capitalLetter();

//------Strings task
        System.out.println("\n---Strings task---\n");
        stringsMethod("Hello","Face",'e','3');
        stringsMethod("Murb","durb",'r','l');

//------Strings task
        System.out.println("\n---Searching task---\n");
        String[] list = {"John","Bob","Amanda","Sven","Nathan"};

        if(searchingMethod(list, "Amanda") == -1) {
            System.out.println("\"Amanda\" is not contained within the list.");
        }else {
            System.out.println("\"Amanda\" is contained within the list at index: " + searchingMethod(list, "Amanda"));
        }

        if(searchingMethod(list, "Hannah") == -1) {
            System.out.println("\"Hannah\" is not contained within the list.");
        }else {
            System.out.println("\"Hannah\" is contained within the list at index: " + searchingMethod(list, "Hannah"));
        }
    }

    //TODO
    /*
    ArrayList :

    Skriv en metode, der modtager 2 parametre: en arrayliste og en streng.

    Metoden skal gøre følgende:
    •	Indsætte strengen i arraylisten, hvis den ikke findes i listen i forvejen. Ellers gøres ingenting med streng og arrayliste.
    •	returnere værdien true, hvis strengen er blevet indsat i arraylisten.  Ellers false.
    •	Inddrag fejlhåndtering i din løsning, således at null  værdier undgås i arraylisten
    •	Hold listen sorteret.
    */

    public static boolean stringArrayMethod(ArrayList<String> arrayList, String string){
        if(!arrayList.contains(string) && string != null){ //checks that it isn't null
            arrayList.add(string); //if string isn't within the arrayList, adds string and returns "true"
            Collections.sort(arrayList);//sorts the array
            return true;
        }
        Collections.sort(arrayList);//sorts the array
        return false;
    }

    //TODO
    /*
    Græs :

    Om sommeren vokser græsset ca. 0,8 cm om dagen.
    Skriv en metode, der tager imod 2 inputparametre: hvor langt græsset er lige nu og hvor højt
    det må være for at skulle slås.  Metoden skal beregne og returnere hvor mange dage der er til,
    at græsset skal slås næste gang.

    Hvor højt græsset er, når det skal slås, kan forstås på 2 måder.
    1.	Græsset skal overstige denne værdi, før vi starter græsslåmaskinen
    2.	Græsset skal slås, inden værdien overstiges
    3.
    Du vælger selv hvilken løsning du vil implementere.

    Benyt en Scanner til at få input fra brugeren, og udskriv resultatet på skærmen.
    Alle tal, som bliver udskrevet, bør kun have 2 decimaler efter kommaet.
    */

    public static void grassScanner(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input the length of your grass in cm (formatted like xx,xx):");
        try {
            double currentGrassLength = input.nextDouble();
            if (currentGrassLength > 10) {
                System.out.println("Your grass is too long! Get your lawnmower started!");
            }
            if (currentGrassLength <= 10 && currentGrassLength > 6.3) {
                System.out.println("Grass will be ready for a trim in " + Math.round((10 - currentGrassLength) / 0.8) + " days.");
            }
            if (currentGrassLength == 6.3) {
                System.out.println("According to the internet, your grass has the perfect length!");
            }
            if (currentGrassLength < 6.3 && currentGrassLength >= 0) {
                System.out.println("Let your grass grow, it is too short!");
            }
            if (currentGrassLength < 0) {
                System.out.println("Shutting down...");
            }
            /*
            else {
                System.out.println(""); //spacer
                grassScanner();
            }
            */
        }
        catch (InputMismatchException ex){
            System.out.println("Input mismatch error!");
        }
    }

    //TODO
    /*
    Kvadrat :

    Skriv en metode, der som parameter modtager et heltal. Metoden skal udskrive et kvadrat på skærmen
    svarende til heltallet. I det følgende eksempel er tallet 6 modtaget som parameter til metoden:

    *   *   *   *   *   *
    *   *   *   *   *   *
    *   *   *   *   *   *
    *   *   *   *   *   *
    *   *   *   *   *   *
    *   *   *   *   *   *

    •	Udvid metoden, så den også modtager et tegn, som er det tegn, som printes på skærmen
    •	Inddrag fejlhåndtering i din løsning (hvordan vil du håndtere et negativt heltal eller
        et meget stort heltal som ikke kan printes på én linje)
    */

    public static void quadrantMethod(){
        System.out.println("Enter in a number followed by a symbol:");
        Scanner input = new Scanner(System.in);
        try {
            int number = input.nextInt();
            String sign = input.next();
            if(number < 0 || number > 40){
                System.out.println("Cannot print to screen!");
            } else {
                for (int i = 0; i < number; i++) {
                    for (int j = 0; j < number; j++) {
                        if(sign.equals("") || sign.equals(" ")) {
                            System.out.print("*");
                        }else {
                            System.out.print(sign);
                        }
                        if (j < number - 1) {
                            System.out.print("  ");
                        }
                    }
                    System.out.println("");
                }
            }
        }
        catch (InputMismatchException ex){
            System.out.println("Input mismatch error!");
        }
    }
//Not sure how the sign-interpretation would work, so I'm continuing onwards and leaving this for later if I have time


    //TODO
    /*
    Menuvalg :

    Skriv en metode, som præsenterer brugeren for følgende menu på skærmen:
    1.	Beregn
    2.	Udskriv
    3.	Hjælp

    Metoden skal:
    •	udskrive menuen på skærmen
    •	læse brugerens valg (fra tastaturet)
    •	returnere menuvalget som et heltal
    •	Inddrag fejlhåndtering i din løsning (hvordan vil du håndtere et forkert menuvalg)
    */

    //This task seems really odd, like I've completed it like how it was written, but it honestly feels like it's
    //missing something, but maybe it's just an exercise in handling a menu with multiple choice?

    public static void menu(){
        System.out.println("Select an option from the menu:\n1.  Calculate\n2.  Print\n3.  Help");

        Scanner input = new Scanner(System.in);
        try {
            int number = input.nextInt();

            switch (number) {
                case 1:
                    System.out.println("You selected 'Calculate'...");
                    break;

                case 2:
                    System.out.println("You selected 'Print'...");
                    break;

                case 3:
                    System.out.println("You selected 'Help'...");
                    break;

                default:
                    System.out.println(number+". is not an available option");
            }
        }
        catch (InputMismatchException ex){
            System.out.println("Input mismatch error!");
        }
    }

    //TODO
    /*
    Proper case task

    Skriv en metode, der tager imod en sætning af ord med blanktegn imellem. Sætningen ændres efter følgende regler:
    •	Ord, som udelukkende er skrevet med store bogstaver, skal ikke ændres.
    •	Ord på mere end 3 bogstaver skal skrives med småt, dog med stort begyndelsesbogstav.
    •	Ord på max. 3 bogstaver skal skrives med småt.

    Metoden skal returnere den ændrede sætning.

    •	Inddrag fejlhåndtering (Hvordan vil du f.eks. håndtere en null-string som input?)
    */

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

    //TODO
    /*
    Regning :

    Skriv en metode der modtager to heltal som parametre. Såfremt begge tal ligger i intervallet 1-50
    (begge tal inklusive) skal metoden foretage følgende regneoperationer på tallene:

    •	Addition
    •	Subtraktion
    •	Division
    •	Multiplikation

    og efterfølgende udskrive resultatet af operationerne på skærmen.

    •	Såfremt et af tallene eller begge tal ikke opfylder betingelsen om at ligge i intervallet 1-50,
        skal metoden kaste en IllegalArgumentException.
    */

    public static void calculator(double num1, double num2){
        if(num1 <= 50 && num1 >= 1 && num2 <= 50 && num2 >= 1){
            System.out.println(num1 +" + "+ num2 +" = "+ (num1 + num2));
            System.out.println(num1 +" - "+ num2 +" = "+ (num1 - num2));
            //not sure why this below results in this format xx,xx rather than xx.xx
            System.out.println(num1 +" / "+ num2 +" = "+ String.format("%.2f", num1 / num2));
            System.out.println(num1 +" * "+ num2 +" = "+ (num1 * num2));
        }else{
            throw new IllegalArgumentException();
            //the same as initiating a new IllegalArgumentException with some kind of name, and then throwing that,
            //this is basically just a shorthand version, reducing two lines to one
        }
    }

    //TODO
    /*
    Skriv en metode, der indlæser 5 tekststrenge fra tastaturet og udskriver dem på skærmen i
    alfabetisk faldende orden på skærmen.

    Hvis der indlæses:
        abekat
        musefælde
        ananas
        slut
        solskin

    skal der udskrives følgende på skærmen:
        solskin
        slut
        musefælde
        ananas
        abekat
    */

    public static void antiAlphabeticaliser(){
        System.out.println("Input five words (separated by spaces):");
        Scanner input = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        list.add(input.next());
        list.add(input.next());
        list.add(input.next());
        list.add(input.next());
        list.add(input.next());

        System.out.println("Original order:");
        for (String value : list) {
            System.out.println(value);
        }

        System.out.println("\nDescending order:");
        //sorts in reverse order using the Collections.reverseOrder() Comparator
        list.sort(Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }

    //TODO
    /*
    Stort bogstav :

    Skriv et lille program, der indlæser et antal tekststrenge fra tastaturet og stopper, når der trykkes
    på <retur>tasten (dvs. uden at brugeren har skrevet nogen tekst).

    Til sidste skal det udskrives på skærmen, hvor mange af de indlæste tekststrenge, som begyndte med et
    stort forbogstav (A-Z).

    Eksempel:

    Der var en gang
    der var engang
    Engang var der

    2 tekststrenge begyndte med stort forbogstav
    */

    public static void capitalLetter(){
        Scanner input = new Scanner(System.in);
        try{
            int counter = 0;
            String sentence = input.nextLine();
            while(sentence.length() > 0){
                if(sentence.charAt(0) == sentence.toUpperCase().charAt(0)){
                    counter++;
                }
                sentence = input.nextLine();
            }
            System.out.println(counter+" sentences started with a capital letter.");
        }
        catch (InputMismatchException ex){
            System.out.println("Input Mismatch Exception error!");
        }
    }

    //TODO
    /*
    Strenge :

    Skriv en metode, der som parametre modtager to strenge og to tegn (typen char).

    Metoden skal gøre følgende:
    •	sætte de to inputstrenge sammen
    •	udskifte alle tegn i den sammensatte streng, som matcher det første inputtegn med det andet
        inputtegn og returnere det nye strengindhold
    •	Inddrag fejlhåndtering (hvordan vil du fx håndtere en tom streng som input)
    */

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

    //TODO
    /*
    Søgning :

    Skriv en metode, der som parametre modtager et array af typen String samt en String.
    Metoden skal undersøge om strengen findes i arrayet. Metoden skal returnere indekspositionen,
    hvis strengen findes i arrayet og –1 hvis strengen ikke findes i arrayet.

    Lav en alternativ fejlhåndtering, hvis strengen ikke findes i arrayet, hvor du i stedet kaster en exception.
    */

    public static int searchingMethod(String[] list, String s){
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(s)){
                return i;
            }
        }
        //throw new NullPointerException(); //commented out to not crash the program
        return -1;
    }
}
