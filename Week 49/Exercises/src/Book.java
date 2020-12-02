//TODO
/*
    Bog :

    Skriv en klasse kaldet Bog, der indeholder ISBN-nummer, titel og udgivelsesår.
    Skriv flg. metoder:
    •	Konstruktør metode
    •	Get og set metoder
    •	toString metode
    •	Skriv en equals metode baseret på ISBN
*/

public class Book {
    private String ISBN;
    private String title;
    private int publishingYear;

    public Book(String ISBN, String title, int publishingYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishingYear = publishingYear;
    }

    public boolean compareISBN(String ISBN){
        if(this.ISBN.equals(ISBN)){
            return true;
        }
        return false;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString(){
        return
        "\""+this.title+"\""+
        "\nISBN: "+this.ISBN+
        "\nYear: "+this.publishingYear;
    }
}
