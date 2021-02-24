package Models;

public class Pizza {
    private int id;
    private String name;
    private String price;
    private String size;

    public Pizza(String name, String price, String size){
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public Pizza(int id, String name, String price, String size){
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return "#"+this.id+" \""+this.name+"\" ("+this.size+") --- "+this.price;
    }
}
