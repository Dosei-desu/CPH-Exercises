import org.junit.Test;
import static org.junit.Assert.*;

public class TestLibrary {
    //Library/book task tests :
    Library library = new Library();

    @Test
    public void testAddOne(){
        Book book1 = new Book("978-1-909227-85-9","The Dagger of Shadows",2016);
        library.addBook(book1);
        assertTrue(library.searchByISBN("978-1-909227-85-9"));
    }

    @Test
    public void testAddTwo(){
        library.addBook("978-1-84970-872-2","Xenos",2001);
        assertTrue(library.searchByISBN("978-1-84970-872-2"));
    }

    @Test
    public void testFalseSearch(){
        assertFalse(library.searchByISBN("978-1-85552-92-2"));
    }

}
