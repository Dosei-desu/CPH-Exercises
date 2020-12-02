//this is ribary!
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//TODO
/*
    Bog :

    Skriv en klasse kaldet Bibliotek, der indeholder en liste af Bog objekter.
    •	Skriv en metode i Bibliotek klassen, som tager et Bog objekt som parameter,
        og returnerer true, hvis listen indeholder et Bog objekt med samme ISBN.
*/

//A custom comparator used to sort books by name
// (necessary since Book is a complex data type and regular sort does not work)
class SortByTitle implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}

public class Library {
    private List<Book> libraryList = new ArrayList<>();

    public void viewBooks(){
        libraryList.sort(new SortByTitle());
        for (Book book : libraryList) {
            System.out.println(book.toString());
            System.out.println(""); //spacer
        }
    }

    public void addBook(Book book){
        libraryList.add(book);
    }

    public void addBook(String ISBN, String title, int publishingYear){
        Book book = new Book(ISBN,title,publishingYear);
        libraryList.add(book);
    }

    public boolean searchByISBN(String ISBN){
        for (int i = 0; i < libraryList.size(); i++) {
            if(libraryList.get(i).compareISBN(ISBN)){
                return true;
            }
        }
        return false;
    }


}
